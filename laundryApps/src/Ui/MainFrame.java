package Ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Laundry Apps");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(210, 28, 172, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Pesanan");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(60, 110, 104, 71);
		contentPane.add(btnNewButton);
		
		JButton btnLayanan = new JButton("Layanan");
		btnLayanan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLayanan.setBounds(224, 110, 104, 71);
		contentPane.add(btnLayanan);
		
		JButton btnPelanggan = new JButton("Pelanggan");
		btnPelanggan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnPelanggan.setBounds(392, 110, 104, 71);
		contentPane.add(btnPelanggan);
		
		JButton btnPengguna = new JButton("Pengguna");
		btnPengguna.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnPengguna.setBounds(60, 244, 104, 71);
		contentPane.add(btnPengguna);
		
		JButton btnLaporan = new JButton("Laporan");
		btnLaporan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLaporan.setBounds(224, 244, 104, 71);
		contentPane.add(btnLaporan);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnProfile.setBounds(392, 244, 104, 71);
		contentPane.add(btnProfile);
		
		JButton btnNewButton_1 = new JButton("Keluar");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1.setBounds(54, 339, 454, 40);
		contentPane.add(btnNewButton_1);
	}

}
