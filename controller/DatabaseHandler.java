package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseHandler {

    private Connection con;
    private String url = "jdbc:mysql://localhost/db_uas_1123010?serverTimezone=UTC&useSSL=false";
    private String username = "root";
    private String password = "";

    // Memuat driver dan menghubungkan ke database
    private Connection logOn() {
        try {

            // Membuat koneksi ke database
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi berhasil!");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error occurred while connecting to the database: " + e.getMessage());
        }
        return con;
    }

    private void logOff() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Koneksi ditutup.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error occurred while closing the connection: " + e.getMessage());
        }
    }

    public void connect() {
        con = logOn();
    }

    // Menutup koneksi ke database
    public void disconnect() {
        logOff();
    }

    // Mendapatkan koneksi
    public Connection getConnection() {
        return con;
    }
}
