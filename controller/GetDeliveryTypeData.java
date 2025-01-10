package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class GetDeliveryTypeData {

    private static DatabaseHandler conn = new DatabaseHandler();

    public static String[] getType() {
        String[] types = new String[10];  
        int i = 0;

        try {
            conn.connect();

            String query = "SELECT * FROM delivertype";
            Statement stmt = conn.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {  
                types[i] = rs.getString("Type");
                i++;
            }

            if (i == 0) {
                JOptionPane.showMessageDialog(null, "Tidak ada jenis pengiriman tersedia");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            conn.disconnect();
        }

        return types;
    }
    public static int getPrice(String type) {
        
        int price = 0;

        try {
            conn.connect();

            String query = "SELECT * FROM delivertype";
            Statement stmt = conn.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {  
                if (rs.getString("Type").equalsIgnoreCase(type)) {
                    price = rs.getInt("fee");
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            conn.disconnect();
        }

        return price;
    }
}
