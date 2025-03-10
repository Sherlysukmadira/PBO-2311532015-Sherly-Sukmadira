package DAO;

import java.util.logging.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import confg.Database;
import model.Order;

public class OrderRepo{
	
private Connection connection;
final String insert = "INSERT INTO orders (id, id_pelanggan, tanggal, tanggal_pengambilan, status, pembayaran, status_pembayaran, total)" + "VALUES (?,?,?,?,?,?,?,?);";
final String select = "SELECT * FROM orders;";
final String delete = "DELETE FROM orders WHERE id=?;";
final String delete_detail = "DELETE FROM order_detail WHERE order_id=?;";
final String update = "UPDATE orders SET id_pelanggan=?, tanggal=?, tanggal_pengambilan=?, status=?, pembayaran=?, status_pembayaran=?, total=? WHERE id=?;";



public OrderRepo() {
	connection = Database.getInstance().getConnection();
 }

public void save(Order cs) {
    PreparedStatement st = null;
    try {
        // Inisialisasi PreparedStatement
        st = connection.prepareStatement(insert);

        // Set parameter untuk query SQL
        st.setString(1, cs.getId());
        st.setString(2, cs.getId_pelanggan());
        st.setString(3, cs.getTanggal());
        st.setString(4, cs.getTanggal_pengambilan());
        st.setString(5, cs.getStatus());
        st.setString(6, cs.getPembayaran());
        st.setString(7, cs.getStatus_pembayaran());
        st.setString(8, cs.getTotal());

        // Eksekusi query
        st.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            // Pastikan `st` tidak null sebelum menutup
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


public List<Order> show(){
	List<Order> ls=null;
	try {
		ls = new ArrayList<Order>();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(select);
		while(rs.next()) {
			Order cs = new Order();
			cs.setId(rs.getString("id"));
			cs.setId_pelanggan(rs.getString("id_pelanggan"));
			cs.setTanggal(rs.getString("tanggal"));
			cs.setStatus(rs.getString("status"));
			cs.setPembayaran(rs.getString("pembayaran"));
			cs.setStatus_pembayaran(rs.getString("status_pembayaran"));
			cs.setTotal(rs.getString("total"));
			ls.add(cs);
		}
	} catch(SQLException e) {
		Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null,e);
	}
	return ls;
}

public void delete(String id) {
	PreparedStatement st = null;
	PreparedStatement st_detail = null;
	try {
		st = connection.prepareStatement(delete);
		st.setString(1, id);
		st.executeUpdate();
		
		st_detail = connection.prepareStatement(delete_detail);
		st_detail.setString(1,id);
		st_detail.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			st.close();
			st_detail.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

public void update(Order cs) {
	PreparedStatement st = null;
	try {
		st = connection.prepareStatement(update);
		
		st = connection.prepareStatement(update);
		st.setString(1, cs.getId_pelanggan());
		st.setString(2, cs.getTanggal());
		st.setString(3, cs.getTanggal_pengambilan());
		st.setString(4, cs.getStatus());
		st.setString(5, cs.getPembayaran());
		st.setString(6, cs.getStatus_pembayaran());
		st.setString(7, cs.getTotal());
		st.setString(8, cs.getId());
		st.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
}