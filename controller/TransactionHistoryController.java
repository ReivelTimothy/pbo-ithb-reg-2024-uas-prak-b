package controller;

import models.classes.Transaction;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryController {
    private DatabaseHandler dbHandler;

    public TransactionHistoryController() {
        dbHandler = new DatabaseHandler();
        dbHandler.connect(); 
    }

    public DefaultTableModel getHistory(int customerId) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Transaction ID");
        model.addColumn("Expected Weight");
        model.addColumn("Total Cost");
        model.addColumn("Delivery Type");
        model.addColumn("Receipt Address");
        model.addColumn("Receipt Phone");

        String query = "SELECT * FROM transaction WHERE customer_id = ?"; 
        try (PreparedStatement stmt = dbHandler.getConnection().prepareStatement(query)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getInt("expected_weight"),
                        rs.getInt("total_cost"),
                        rs.getString("deliver_type"),
                        rs.getString("receipt_address"),
                        rs.getString("receipt_phone")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }

    
    public void closeConnection() {
        dbHandler.disconnect();
    }
}
