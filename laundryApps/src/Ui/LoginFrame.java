package Ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import error.ValidationException;
import model.User;
import service.LoginService;
import util.ValidationUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(59, 204, 67, 28);
		contentPane.add(lblNewLabel);
		
		textUsername = new JTextField();
		textUsername.setBounds(59, 242, 445, 54);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(59, 306, 67, 28);
		contentPane.add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(59, 344, 445, 54);
		contentPane.add(textPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userValue = textUsername.getText();
				String passValue = textPassword.getText();
				
				//create user object
				User user = new User(userValue, passValue);
				try {
					ValidationUtil.validate(user);
					LoginService loginService = new LoginService();
					if(loginService.authenticate(user)) {
						System.out.println("Login successful!");
						new MainFrame().setVisible(true);
						dispose();
					}
					else {
						System.out.println("Invalid username or password");
						JOptionPane.showMessageDialog(null, "Login Gagal, Invalid username or password.");
					}
				} catch (ValidationException | NullPointerException exception) {
					System.out.println("Data tidak valid : " + exception.getMessage());
					JOptionPane.showMessageDialog(null, "Login Gagal : " + exception.getMessage());
				} finally {
					System.out.println("Selalu di eksekusi");
				}
			}		
		});
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLogin.setBounds(59, 464, 445, 54);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("Laundry Apps");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(59, 86, 188, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Solusi Buat Kaum Sat Set");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(59, 139, 211, 37);
		contentPane.add(lblNewLabel_2);
	}
}
