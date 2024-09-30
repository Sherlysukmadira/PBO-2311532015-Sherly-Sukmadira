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

import DAO.CustomerRepo;
import model.Customer;
import model.User;
import table.TableCustomer;
import table.TableUser;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class CustomerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTable tableCustomer;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
					frame.setVisible(true);
					frame.loadTable();
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
	
	//method riset
	public void reset () {
		txtName.setText("");
		txtAddress.setText("");
		txtPhone.setText(" ");
	}
	//instance pada userframe
	CustomerRepo cus = new CustomerRepo();
	List<Customer> ls;
	public String id;
	
	public void loadTable() {
		ls = cus.show();
		TableCustomer tc = new TableCustomer(ls);
		tableCustomer.setModel(tc);
		tableCustomer.getTableHeader(). setVisible(true);
		
	}
	
	
	
	public CustomerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 667);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableCustomer.getValueAt(tableCustomer.getSelectedRow(),0).toString();
				txtName.setText(tableCustomer.getValueAt(tableCustomer.getSelectedRow(), 1).toString());
				txtAddress.setText(tableCustomer.getValueAt(tableCustomer.getSelectedRow(), 2).toString());
				txtPhone.setText(tableCustomer.getValueAt(tableCustomer.getSelectedRow(), 3).toString());
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblName.setBounds(21, 75, 108, 38);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(156, 75, 444, 38);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAddress.setBounds(21, 154, 108, 38);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone ");
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPhone.setBounds(21, 233, 108, 38);
		contentPane.add(lblPhone);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(156, 154, 444, 38);
		contentPane.add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(156, 233, 444, 38);
		contentPane.add(txtPhone);
		
		JScrollPane JScrollPane = new JScrollPane();
		JScrollPane.setBounds(21, 378, 652, 88);
		contentPane.add(JScrollPane);
		
		tableCustomer = new JTable();
		tableCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableCustomer.getValueAt(tableCustomer.getSelectedRow(),0).toString();
				txtName.setText(tableCustomer.getValueAt(tableCustomer.getSelectedRow(),1).toString());
				txtAddress.setText(tableCustomer.getValueAt(tableCustomer.getSelectedRow(),2).toString());
				txtPhone.setText(tableCustomer.getValueAt(tableCustomer.getSelectedRow(),3).toString());
			}
		});
		tableCustomer.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Address", "Phone"
			}
		));
		JScrollPane.setViewportView(tableCustomer);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(128, 255, 0));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer();
				customer.setName(txtName.getText());
				customer.setAddress(txtAddress.getText());
				customer.setPhone(txtPhone.getText());
				cus.save(customer);
				reset();
				loadTable();
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave.setBounds(156, 312, 95, 26);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(0, 128, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer();
				customer.setName(txtName.getText());
				customer.setAddress(txtAddress.getText());
				customer.setPhone(txtPhone.getText());
				customer.setId(id);
				cus.update(customer);
				reset();
				loadTable();
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUpdate.setBounds(267, 312, 95, 26);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id != null) {
					cus.delete(id);
					reset();
					loadTable();
				} else {
					JOptionPane.showMessageDialog(null,"Silakan pilih data yang akan di hapus");
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDelete.setBounds(387, 312, 95, 26);
		contentPane.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(255, 255, 128));
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCancel.setBounds(505, 312, 95, 26);
		contentPane.add(btnCancel);
		
		
	}
}
