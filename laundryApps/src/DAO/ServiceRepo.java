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
import model.Service;
import DAO.ServiceDao;
import DAO.ServiceRepo;


public class ServiceRepo implements ServiceDao {
	private Connection connection;
	
	final String insert = "INSERT INTO service (jenis, status, harga, satuan) VALUES (?, ?, ?, ?);";
	final String select = "SELECT * FROM service;" ;
	final String delete = "DELETE FROM service WHERE id = ?;";
	final String update = "UPDATE service SET jenis=?, status=?, harga=?, satuan=? WHERE id = ?;";
	

	
	public ServiceRepo () {
		connection = Database.getInstance().getConnection();
	}

	@Override
	public void save(Service service) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(insert);
			st.setString(1, service.getJenis());
			st.setString(2, service.getStatus());
			st.setDouble(3, service.getHarga());
			st.setDouble(4, service.getSatuan());
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
	public List<Service> show() {
		List<Service>ls = null;
		try {
			ls = new ArrayList<Service>();
			Statement  st = connection.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				Service service= new Service();
				service.setId(rs.getString("id"));
				service.setJenis(rs.getString("jenis"));
				service.setStatus(rs.getString("status"));
				service.setHarga(rs.getDouble("harga"));
				service.setSatuan(rs.getDouble("satuan"));
				ls.add(service);
			}
		}catch(SQLException e) {
			Logger.getLogger(ServiceDao.class.getName()).log(Level.SEVERE,null,e);
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
	public void update(Service service) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(update);
			st.setString(1, service.getJenis());
			st.setString(2, service.getStatus());
			st.setDouble(3, service.getHarga());
			st.setDouble(4, service.getSatuan());
			st.setString(5, service.getId());
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