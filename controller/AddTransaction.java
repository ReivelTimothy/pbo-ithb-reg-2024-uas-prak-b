package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.classes.Transaction;

public class AddTransaction {
    private static DatabaseHandler conn = new DatabaseHandler();

    public static boolean RecordTransaction(Transaction transaction) {
        conn.connect();

        String query = "INSERT INTO transaction (expected_weight, deliver_type, receipt_address, receipt_phone, total_cost, customer_id) " +
                       "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(query)) {
            stmt.setInt(1, transaction.getExpected_weight());
            stmt.setString(2, transaction.getDeliver_type());
            stmt.setString(3, transaction.getReceipt_address());
            stmt.setString(4, transaction.getReceipt_phone());
            stmt.setDouble(5, transaction.getTotal_cost());
            stmt.setInt(6, transaction.getCustomer_id());

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Transaction successfully recorded!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Failed to record transaction.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            conn.disconnect();
        }
    }
}
