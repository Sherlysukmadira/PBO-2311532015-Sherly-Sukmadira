package DAO;

import java.util.List;

import model.Order;

public interface OrderDao {
	void save (Order cs);
	public List<Order> show();
	public void delete(Order id);
	public void update(Order cs);
}
