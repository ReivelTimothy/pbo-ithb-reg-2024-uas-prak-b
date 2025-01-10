package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class LoginSingleton {
    private static LoginSingleton instance;
    private int id = -1;
    private int role;
    private static DatabaseHandler conn = new DatabaseHandler();

    // Private constructor untuk mencegah pembuatan instance langsung
    private LoginSingleton() {}

    // Mendapatkan instance tunggal dari LoginSingleton
    public static LoginSingleton getInstance() {
        if (instance == null) {
            instance = new LoginSingleton();
        }
        return instance;
    }

    // Method untuk melakukan pengecekan login
    public static void checkLogin(String nomorTelp, String password) {
        try {
            conn.connect(); // Membuka koneksi ke database

            // Query untuk memeriksa data login
            String query = "SELECT * FROM customer WHERE phone='" + nomorTelp + "' AND password='" + password + "'";
            Statement stmt = conn.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                // Mendapatkan data user dari result set
                String pass = rs.getString("password");
                String nama = rs.getString("name");
                int id = rs.getInt("id");
                int role = rs.getInt("role");

                // Memeriksa apakah password cocok
                if (password.equals(pass)) {
                    LoginSingleton.getInstance().setId(id);
                    LoginSingleton.getInstance().setRole(role);
                    JOptionPane.showMessageDialog(null, "Selamat Datang " + nama);
                } else {
                    JOptionPane.showMessageDialog(null, "Maaf, password atau nomor telepon Anda salah");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nomor telepon tidak ditemukan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            conn.disconnect(); // Menutup koneksi ke database
        }
    }

    // Getter dan Setter untuk id dan role
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
