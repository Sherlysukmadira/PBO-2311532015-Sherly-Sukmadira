package Ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import DAO.ServiceRepo;
import DAO.UserRepo;
import model.Customer;
import model.Service;
import model.User;
import table.TableService;
import table.TableUser;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ServiceFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtJenis;
	private JTextField txtStatus;
	private JTextField txtHarga;
	private JTable tableService;
	private ServiceRepo serviceRepo;
	private String selectedld = null;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceFrame frame = new ServiceFrame();
					frame.setVisible(true);
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
	
	//method reset
	public void reset () {
		txtJenis.setText("");
		txtStatus.setText("");
		txtHarga.setText(" ");
		txtSatuan.setText(" ");
	}
	
	//instance pada userframe
	ServiceRepo svr = new ServiceRepo();  
	List<Service> ls;
	public String id;
	private JTextField txtSatuan;
	
	
	public void loadTable() {
		ls = svr.show();
		System.out.println(ls.size());
		TableService ts = new TableService(ls);
		tableService.setModel(ts);
		tableService.getTableHeader(). setVisible(true);
		
	}
	
	
	
	public ServiceFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 667);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableService.getValueAt(tableService.getSelectedRow(),0).toString();
				txtJenis.setText(tableService.getValueAt(tableService.getSelectedRow(), 1).toString());
				txtStatus.setText(tableService.getValueAt(tableService.getSelectedRow(), 2).toString());
				txtHarga.setText(tableService.getValueAt(tableService.getSelectedRow(), 3).toString());
				txtSatuan.setText(tableService.getValueAt(tableService.getSelectedRow(), 4).toString());
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJenis = new JLabel("Jenis");
		lblJenis.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblJenis.setBounds(21, 75, 108, 38);
		contentPane.add(lblJenis);
		
		txtJenis = new JTextField();
		txtJenis.setBounds(156, 75, 444, 38);
		contentPane.add(txtJenis);
		txtJenis.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblStatus.setBounds(21, 154, 108, 38);
		contentPane.add(lblStatus);
		
		JLabel lblharga = new JLabel("Harga");
		lblharga.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblharga.setBounds(21, 233, 108, 38);
		contentPane.add(lblharga);
		
		txtStatus = new JTextField();
		txtStatus.setColumns(10);
		txtStatus.setBounds(156, 154, 444, 38);
		contentPane.add(txtStatus);
		
		txtHarga = new JTextField();
		txtHarga.setColumns(10);
		txtHarga.setBounds(156, 233, 444, 38);
		contentPane.add(txtHarga);

		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(255, 255, 128));
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCancel.setBounds(503, 389, 95, 26);
		contentPane.add(btnCancel);
		
		JLabel lblSatuan = new JLabel("Satuan");
		lblSatuan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSatuan.setBounds(21, 305, 108, 38);
		contentPane.add(lblSatuan);
		
		txtSatuan = new JTextField();
		txtSatuan.setColumns(10);
		txtSatuan.setBounds(156, 305, 444, 38);
		contentPane.add(txtSatuan);
		JScrollPane JScrollPane = new JScrollPane();
		JScrollPane.setBounds(22, 469, 652, 88);
		contentPane.add(JScrollPane);
		
		tableService = new JTable();
		tableService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableService.getValueAt(tableService.getSelectedRow(),0).toString();
				txtJenis.setText(tableService.getValueAt(tableService.getSelectedRow(),1).toString());
				txtStatus.setText(tableService.getValueAt(tableService.getSelectedRow(),2).toString());
				txtHarga.setText(tableService.getValueAt(tableService.getSelectedRow(),3).toString());
				txtSatuan.setText(tableService.getValueAt(tableService.getSelectedRow(),4).toString());
			}
		});
		tableService.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Jenis", "Status ", "Harga", "Satuan"
			}
		));
		JScrollPane.setViewportView(tableService);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(128, 255, 0));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service service = new Service();
				service.setJenis(txtJenis.getText());
				service.setStatus(txtStatus.getText());
				System.out.println(txtHarga.getText());System.out.println(txtSatuan);
				service.setHarga(Double.parseDouble(txtHarga.getText()));
				service.setSatuan(Double.parseDouble(txtSatuan.getText()));
				svr.save(service);
				reset();
				loadTable();
			}
		});
		
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave.setBounds(156, 389, 95, 26);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(0, 128, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service service = new Service();
				service.setJenis(txtJenis.getText());
				service.setStatus(txtStatus.getText());
				service.setHarga(Double.parseDouble(txtHarga.getText()));
				service.setSatuan(Double.parseDouble(txtSatuan.getText()));
				service.setId(id);
				svr.update(service);
				reset();
				loadTable();
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUpdate.setBounds(261, 389, 95, 26);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDelete.setBounds(378, 389, 95, 26);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id != null) {
					svr.delete(id);
					reset();
					loadTable();
				} else {
					JOptionPane.showMessageDialog(null,"Silakan pilih data yang akan di hapus");
				}
			}
		});
		
	}
}
