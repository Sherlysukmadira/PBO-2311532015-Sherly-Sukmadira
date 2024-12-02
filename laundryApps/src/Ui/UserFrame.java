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

import DAO.UserRepo;
import model.User;
import table.TableUser;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class UserFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTable tableUsers;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
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
		txtUsername.setText("");
		txtPassword.setText(" ");
	}
	//instance pada userframe
	UserRepo usr = new UserRepo();
	List<User> ls;
	public String id;
	
	public void loadTable() {
		ls = usr.show();
		TableUser tu = new TableUser(ls);
		tableUsers.setModel(tu);
		tableUsers.getTableHeader(). setVisible(true);
		
	}
	
	
	
	public UserFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 667);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableUsers.getValueAt(tableUsers.getSelectedRow(),0).toString();
				txtName.setText(tableUsers.getValueAt(tableUsers.getSelectedRow(), 1).toString());
				txtUsername.setText(tableUsers.getValueAt(tableUsers.getSelectedRow(), 2).toString());
				txtPassword.setText(tableUsers.getValueAt(tableUsers.getSelectedRow(), 3).toString());
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
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUsername.setBounds(21, 154, 108, 38);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassword.setBounds(21, 233, 108, 38);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(156, 154, 444, 38);
		contentPane.add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(156, 233, 444, 38);
		contentPane.add(txtPassword);
		
		JScrollPane JScrollPane = new JScrollPane();
		JScrollPane.setBounds(21, 378, 652, 88);
		contentPane.add(JScrollPane);
		
		tableUsers = new JTable();
		tableUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableUsers.getValueAt(tableUsers.getSelectedRow(),0).toString();
				txtName.setText(tableUsers.getValueAt(tableUsers.getSelectedRow(),1).toString());
				txtUsername.setText(tableUsers.getValueAt(tableUsers.getSelectedRow(),2).toString());
				txtPassword.setText(tableUsers.getValueAt(tableUsers.getSelectedRow(),3).toString());
			}
		});
		tableUsers.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Username ", "Password"
			}
		));
		JScrollPane.setViewportView(tableUsers);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(128, 255, 0));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User("" , "");
				user.setNama(txtName.getText());
				user.setUsername(txtUsername.getText());
				user.setPassword(txtPassword.getText());
				usr.save(user);
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
				User user = new User("", "");
				user.setNama(txtName.getText());
				user.setUsername(txtUsername.getText());
				user.setPassword(txtPassword.getText());
				user.setId(id);
				usr.update(user);
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
					usr.delete(id);
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
