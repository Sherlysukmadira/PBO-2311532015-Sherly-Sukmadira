package DAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.OrderDetail;

public interface  OrderDetailDao {
	void save(OrderDetail odm);
	public List<OrderDetail> show();
	public void delete(String id);
	public void update(OrderDetail odm);
}

