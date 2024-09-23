package confg;
import java.sql.Connection;  //import sqlnya
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Database {
	Connection conn;
	public static Connection koneksi () { //membuka method Connection untuk membuka koneksi ke database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/laundry_apps", "root", "");
		return conn;  //jika koneksi berhasil maka akan mengembalikan nilai connection
		}
		
		catch (Exception e) {
			JOptionPane.showInputDialog(null, e);
			return null; //jika koneksi gagal maka akan tampil pesan eror menggunakan JOptionPane
		}
	}
	

}
