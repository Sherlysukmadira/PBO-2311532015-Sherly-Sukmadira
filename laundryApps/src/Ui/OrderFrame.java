package Ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.Color;

public class OrderFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFrame frame = new OrderFrame();
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
	public OrderFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataOrderan = new JLabel("DATA ORDERAN");
		lblDataOrderan.setFont(new Font("Serif", Font.BOLD, 20));
		lblDataOrderan.setBounds(23, 42, 685, 38);
		contentPane.add(lblDataOrderan);
		
		JButton btnCustomer = new JButton("Edit/Detail");
		btnCustomer.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCustomer.setBounds(598, 83, 110, 21);
		contentPane.add(btnCustomer);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDelete.setBounds(478, 84, 110, 21);
		contentPane.add(btnDelete);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderDetailFrame odf = new OrderDetailFrame();
				odf.setVisible(true);
				odf.loadTable();
				odf.loadTable1();
				odf.loadDataRp();
				odf.loadPelangan();
				dispose();
			}
		});
		btnOrder.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnOrder.setBounds(23, 91, 139, 21);
		contentPane.add(btnOrder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 119, 698, 254);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setToolTipText("");
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		table.setFillsViewportHeight(true);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mf = new MainFrame();
				mf.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnBack.setBounds(598, 10, 110, 21);
		contentPane.add(btnBack);
	}
}