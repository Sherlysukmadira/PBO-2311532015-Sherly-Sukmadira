package Ui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.CustomerRepo;
import listener.DataListener;
import table.TableCustomer;
import model.Customer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogPelanggan extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableplgn;

	private DataListener Listener;
	CustomerRepo usr = new CustomerRepo();
	List<Customer> ls;
	public String id;

	public void loadTable() {
		ls = usr.show();
		if (ls != null) {
			TableCustomer tu = new TableCustomer(ls);
			tableplgn.setModel(tu);
			tableplgn.getTableHeader().setVisible(true);
		}
	}

	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
		//	public void run() {
		//		try {
		//			DataListener listener = new DataListener() {
		//				@Override
			//			public void onDataReceived(String id, String nama) {
		//					System.out.println("ID: " + id + ", Nama: " + nama);
			//			}
			//		};
			//		DialogPelanggan frame = new DialogPelanggan(listener);
					//frame.setVisible(true);
				//} catch (Exception e) {
			//		e.printStackTrace();
			//	}
		//	}
	//	});
	//}

	/**
	 * Create the frame.
	 */
	public DialogPelanggan(DataListener listener) {
		this.Listener = listener;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 21, 529, 122);
		contentPane.add(scrollPane);
		
		tableplgn = new JTable();
		tableplgn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	            listener.onDataReceived(
	                tableplgn.getValueAt(tableplgn.getSelectedRow(), 0).toString(),
	                tableplgn.getValueAt(tableplgn.getSelectedRow(), 1).toString()
	            );
	            dispose();
	        }
		});
		tableplgn.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ID", "Nama", "Alamat", "Hp"
			}
		));
		scrollPane.setViewportView(tableplgn);
		loadTable();
	}
}
