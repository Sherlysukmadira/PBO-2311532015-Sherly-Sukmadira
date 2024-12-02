package Ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pesanan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pesanan frame = new Pesanan();
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
	public Pesanan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(30, 126, 413, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Masukan Data");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(30, 89, 101, 38);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Simpan");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBounds(503, 126, 110, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblData = new JLabel("Data       :");
		lblData.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblData.setBounds(30, 193, 101, 38);
		contentPane.add(lblData);
		
		JLabel lblNewLabel_1_1 = new JLabel("Check Array Ke-");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(30, 270, 127, 38);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(167, 265, 279, 43);
		contentPane.add(textField_1);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnCheck.setBounds(503, 265, 110, 43);
		contentPane.add(btnCheck);
	}
}
