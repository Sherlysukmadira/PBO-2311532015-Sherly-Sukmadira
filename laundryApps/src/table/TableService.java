package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Service;

public class TableService extends AbstractTableModel {
    List<Service> ls;
    private String[] columnNames = {"ID", "Jenis", "Status", "Harga", "Satuan"};

    public TableService(List<Service> ls) {
        this.ls = ls;
    }
    public int getRowCount() {
        return ls.size();
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public String getColumnName(int column) {
        return columnNames[column];
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        Service service = ls.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return service.getId();  
            case 1:
                return service.getJenis();  
            case 2:
                return service.getStatus(); 
            case 3:
                return service.getHarga();  
            case 4:
                return service.getSatuan();  
            default:
                return null;
        }
    }
}
