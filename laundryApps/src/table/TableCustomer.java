package table;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Customer;

public class TableCustomer extends AbstractTableModel{
	List<Customer> ls;
	private String[] columnNames = {"ID", "Name", "Address", "Phone", "Email"};
	public TableCustomer(List <Customer> ls) {
		this.ls = ls;
	}
	public int getRowCount() {
		// TODO Auto-generated method stub
		return ls.size();
	}
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}
	public String getColumnName (int column) {
		return columnNames[column];
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return ls.get(rowIndex).getId();
		case 1 :
			return ls.get(rowIndex).getName();
		case 2 :
			return ls.get(rowIndex).getAddress();
		case 3 :
			return ls.get(rowIndex).getPhone();
		case 4 :
			return ls.get(rowIndex).getEmail();
		default :
		return null;
		}	
	}
}
