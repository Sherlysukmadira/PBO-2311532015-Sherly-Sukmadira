package confg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Database {
    private static Database instance; // Singleton instance
    private Connection connection;   // Connection untuk database

    // Constructor private agar tidak bisa diakses dari luar class
    private Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            connection = DriverManager.getConnection("jdbc:mysql://localhost/laundry_apps", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi database gagal: " + e.getMessage());
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    // Method untuk mendapatkan instance tunggal Database
    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) { // Untuk menghindari masalah multithreading
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    // Method untuk mendapatkan koneksi
    public Connection getConnection() {
        return connection;
    }
}
