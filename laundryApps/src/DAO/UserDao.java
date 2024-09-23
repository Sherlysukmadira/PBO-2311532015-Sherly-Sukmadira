package DAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.User;

public interface  UserDao {
	void save(User user);
	public List<User> show();
	public void delete(String id);
	public void update(User user);

}
