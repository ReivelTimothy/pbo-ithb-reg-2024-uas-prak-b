package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseHandler {

    private Connection con;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/pratamadb?serverTimezone=UTC&useSSL=false";
    private String username = "root";
    private String password = "";

    // Memuat driver dan menghubungkan ke database
    private Connection logOn() {
        try {
            // Memuat driver secara otomatis dengan MySQL Connector/J versi terbaru
            Class.forName(driver); // Dapat dihapus jika menggunakan MySQL Connector/J versi terbaru

            // Membuat koneksi ke database
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi berhasil!");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error occurred while connecting to the database: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "JDBC Driver not found: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Unexpected error: " + ex.getMessage());
        }
        return con;
    }

    // Menutup koneksi
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

    // Menghubungkan ke database
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
