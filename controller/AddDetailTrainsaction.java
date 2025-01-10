package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.classes.DeliverDetail;
import models.classes.Transaction;
import models.enumeration.DeliverStatus;

public class AddDetailTrainsaction {
    private static DatabaseHandler conn = new DatabaseHandler();
    private static AddDetailTrainsaction instance;

    AddDetailTrainsaction() {

    }

    public static boolean RecordDetailTransaction(DeliverDetail transaction, DeliverStatus status) {
        conn.connect();

        if (status.name().equalsIgnoreCase(DeliverStatus.ARRIVED.name())) {
            String query = "INSERT INTO deliverdetail (status, currentPosition, evidience, updateBy, date, transaction_Id) "
                    +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = conn.getConnection().prepareStatement(query)) {
                stmt.setString(1, transaction.getStatus().name());
                stmt.setString(2, transaction.getCurrentPosition());
                stmt.setString(3, transaction.getEvidence());
                stmt.setString(4, transaction.getUpdate_By());
                stmt.setDate(5, transaction.getDate());
                stmt.setInt(6, transaction.getTransaction_id());

                int rows = stmt.executeUpdate();

                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Transaction successfully recorded!", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to record transaction.", "Error",
                            JOptionPane.ERROR_MESSAGE);
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
        } else {
            String query = "INSERT INTO deliverdetail (status, currentPosition,  updateBy, date, transaction_Id) "
                    +
                    "VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = conn.getConnection().prepareStatement(query)) {
                stmt.setString(1, transaction.getStatus().name());
                stmt.setString(2, transaction.getCurrentPosition());
                stmt.setString(3, transaction.getUpdate_By());
                stmt.setDate(4, transaction.getDate());
                stmt.setInt(5, transaction.getTransaction_id());

                int rows = stmt.executeUpdate();

                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Transaction successfully recorded!", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to record transaction.", "Error",
                            JOptionPane.ERROR_MESSAGE);
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
}
