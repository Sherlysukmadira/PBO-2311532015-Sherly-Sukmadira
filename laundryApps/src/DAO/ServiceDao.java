package DAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Service;

public interface  ServiceDao {
	void save(Service service);
	public List<Service> show();
	public void delete(String id);
	public void update(Service service);

}
