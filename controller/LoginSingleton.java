package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import models.classes.Customer;

public class LoginSingleton {
    private static LoginSingleton instance;
    private int id = -1;
    private static Customer customer;
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

    
    public static void checkLogin(String nomorTelp, String password) {
        try {
            conn.connect(); 

            String query = "SELECT * FROM customer WHERE phone='" + nomorTelp + "' AND password='" + password + "'";
            Statement stmt = conn.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                String pass = rs.getString("password");
                String nama = rs.getString("name");
                int id = rs.getInt("id");
                String alamat = rs.getString("address");
                String telp = nomorTelp;
                customer = new Customer(id, nama, password, alamat, telp);

                if (password.equals(pass)) {
                    LoginSingleton.getInstance().setId(id);
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
            conn.disconnect(); 
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public static DatabaseHandler getConn() {
        return conn;
    }

    public static void setConn(DatabaseHandler conn) {
        LoginSingleton.conn = conn;
    }

    public static void setInstance(LoginSingleton instance) {
        LoginSingleton.instance = instance;
    }
}
