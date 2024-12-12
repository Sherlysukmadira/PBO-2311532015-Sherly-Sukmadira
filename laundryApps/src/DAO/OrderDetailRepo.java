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
import javax.swing.table.AbstractTableModel;
import confg.Database;
import model.OrderDetail;
import DAO.OrderDetailDao;

public class OrderDetailRepo implements OrderDetailDao {
	private Connection connection;
	final String insert = "INSERT INTO order_detail (jenis, qty, total,harga) VALUES (?,?,?,?);";
	final String select = "SELECT * FROM order_detail;";
	final String delete = "DELETE FROM order_detail WHERE id=?;";
	final String update = "UPDATE order_detail SET jenis=?, qty=?, total=?, harga=? WHERE id=?;";
	
	public OrderDetailRepo () {
		connection = Database.getInstance().getConnection();
	}

	@Override
	public void save(OrderDetail orderdetail) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(insert);
			st.setString(1, orderdetail.getJenis());
			st.setString(2, orderdetail.getQty());
			st.setString(3, orderdetail.getTotal());
			st.setString(4, orderdetail.getHarga());
			st.executeUpdate();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				st.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<OrderDetail> show() {
		List<OrderDetail>ls = null;
		try {
			ls = new ArrayList<OrderDetail>();
			Statement  st = connection.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				OrderDetail orderdetail = new OrderDetail();
				orderdetail.setId(rs.getString("id"));
				orderdetail.setJenis(rs.getString("jenis"));
				orderdetail.setQty(rs.getString("qty"));
				orderdetail.setTotal(rs.getString("total"));
				ls.add(orderdetail);
			}
		}catch(SQLException e) {
			Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,e);
		}
		return ls;
	}

	@Override
	public void delete(String id) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(delete);
			st.setString(1,id);
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

	@Override
	public void update(OrderDetail orderdetail) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(update);
			st.setString(1, orderdetail.getJenis());
			st.setString(2, orderdetail.getQty());
			st.setString(3, orderdetail.getTotal());
			st.setString(4, orderdetail.getHarga());
			st.setString(5, orderdetail.getId());
			st.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		finally {
			try {
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}	
	}

}
