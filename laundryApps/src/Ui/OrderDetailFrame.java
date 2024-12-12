package Ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import DAO.OrderDetailRepo;
import DAO.ServiceRepo;
import model.OrderDetail;
import model.Service;
import table.TableOrderDetail;
import table.TableService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderDetailFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid_Order;
	private JTextField txtFieldTanggal;
	private JTextField txtTanggalPengambilan;
	private JComboBox cbPelanggan;
	private JTextField txtHargaKg;
	private JTextField txtJumlah;
	private JTextField txtTotal2;
	private JTable table_1;
	private JTextField txtSatuan;
	private JTable tableService;
	private JTextField txtJenis; //service
	private JTextField txtJenis1; //orderdetail
	private JTable tableUsers;
	private JTextField txtTotalRp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDetailFrame frame = new OrderDetailFrame();
					frame.setVisible(true);
					frame.loadTable(); //Table Service
					frame.loadTable1(); //Table detail order
					frame.loadDataRp();
					frame.loadPelangan();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	ServiceRepo svr = new ServiceRepo();  
	List<Service> ls;
	public String id;
	
	public void loadTable() {
		ls = svr.show();
		System.out.println(ls.size());
		TableService ts = new TableService(ls);
		tableService.setModel(ts);
		tableService.getTableHeader(). setVisible(true);
	
	}
	
	private double total(double harga, double qty) {
		return harga * qty;
	}
	public double hargabagi(double harga, double qty) {
		return harga / qty;
	}
	
	OrderDetailRepo odr = new OrderDetailRepo();
	List<OrderDetail> ls1;
	
	
	public void reset() {
		txtHargaKg.setText("");
		txtJumlah.setText("");
		txtTotal2.setText("");
		txtJenis1.setText("");
	}
	
	public void loadTable1() {
		ls1 = odr.show();
		TableOrderDetail ts1 = new TableOrderDetail(ls1);
		table_1.setModel(ts1);;
		table_1.getTableHeader().setVisible(true);
	}
	
	public void loadDataRp() {
		int total = 0;
		for (int i = 0; i < table_1.getRowCount(); i++) {
		    Object value = table_1.getValueAt(i, 3); 

		    total += Double.parseDouble(value.toString());
		}
	    txtTotalRp.setText("Rp. " + String.valueOf(total)); 
	}
	
	public void loadPelangan() {
		String cust;
        cust = "Sherly Sukmadira Putri";
        cbPelanggan.addItem(cust); 
	}
	
	LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formattedDate = today.format(formatter);
    

    
	public OrderDetailFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 330, 678);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblOrder = new JLabel("Oder ID");
		lblOrder.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblOrder.setBounds(10, 18, 87, 28);
		panel.add(lblOrder);
		
		txtid_Order = new JTextField();
		txtid_Order.setBounds(10, 44, 294, 28);
		panel.add(txtid_Order);
		txtid_Order.setColumns(10);
		
		JLabel lblPelanggan = new JLabel("Pelanggan");
		lblPelanggan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPelanggan.setBounds(10, 82, 87, 28);
		panel.add(lblPelanggan);
		
		cbPelanggan = new JComboBox();
		cbPelanggan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbPelanggan.setModel(new DefaultComboBoxModel(new String[] {"Pilih"}));
		cbPelanggan.setBounds(10, 113, 294, 28);
		panel.add(cbPelanggan);
		
		JLabel lblTanggal = new JLabel("Tanggal");
		lblTanggal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTanggal.setBounds(10, 147, 87, 28);
		panel.add(lblTanggal);
		
		txtFieldTanggal = new JTextField();
		txtFieldTanggal.setColumns(10);
		txtFieldTanggal.setBounds(10, 173, 294, 28);
		panel.add(txtFieldTanggal);
		
		JLabel lblTanggalPengambilan = new JLabel("Tanggal Pengambilan");
		lblTanggalPengambilan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTanggalPengambilan.setBounds(10, 211, 138, 28);
		panel.add(lblTanggalPengambilan);
		
		txtTanggalPengambilan = new JTextField();
		txtTanggalPengambilan.setColumns(10);
		txtTanggalPengambilan.setBounds(10, 243, 294, 28);
		panel.add(txtTanggalPengambilan);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStatus.setBounds(10, 281, 87, 28);
		panel.add(lblStatus);
		
		JComboBox cbStatus = new JComboBox();
		cbStatus.setBounds(10, 313, 294, 28);
		panel.add(cbStatus);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTotal.setBounds(10, 351, 87, 28);
		panel.add(lblTotal);
		
		JLabel lblPembayaran = new JLabel("Pembayaran");
		lblPembayaran.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPembayaran.setBounds(10, 428, 87, 28);
		panel.add(lblPembayaran);
		
		JComboBox comboBoxPembayaran = new JComboBox();
		comboBoxPembayaran.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Tranfer", "Qris"}));
		comboBoxPembayaran.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBoxPembayaran.setBounds(10, 460, 294, 28);
		panel.add(comboBoxPembayaran);
		
		JLabel lblStatusPembayaran = new JLabel("Status Pembayaran");
		lblStatusPembayaran.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStatusPembayaran.setBounds(10, 498, 111, 28);
		panel.add(lblStatusPembayaran);
		
		JComboBox cbStatusPembayaran = new JComboBox();
		cbStatusPembayaran.setModel(new DefaultComboBoxModel(new String[] {"Lunas", "Proses"}));
		cbStatusPembayaran.setBounds(10, 528, 294, 28);
		panel.add(cbStatusPembayaran);
		
		JButton btnNewButton = new JButton("Simpan");
		btnNewButton.setBounds(34, 583, 87, 35);
		panel.add(btnNewButton);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.setBounds(190, 583, 87, 35);
		panel.add(btnBatal);
		
		txtTotalRp = new JTextField();
		txtTotalRp.setBounds(10, 383, 138, 35);
		panel.add(txtTotalRp);
		txtTotalRp.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(350, 10, 477, 678);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLayanan = new JLabel("Layanan");
		lblLayanan.setBounds(10, 20, 61, 17);
		lblLayanan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel_1.add(lblLayanan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 457, 171);
		panel_1.add(scrollPane);
		
		tableService = new JTable();
		tableService.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Jenis", "Status", "satuan", "Harga"
			}
		));
		scrollPane.setViewportView(tableService);
		tableService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtHargaKg.setText(tableService.getValueAt(tableService.getSelectedRow(),3).toString());
				txtJumlah.setText("");
				txtJenis1.setText(tableService.getValueAt(tableService.getSelectedRow(),1).toString());
				txtTotal2.setText("");	
			}
		});
		
		
		JLabel lblHargakg = new JLabel("HargaKG");
		lblHargakg.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHargakg.setBounds(10, 242, 107, 17);
		panel_1.add(lblHargakg);
		
		txtHargaKg = new JTextField();
		txtHargaKg.setColumns(10);
		txtHargaKg.setBounds(10, 265, 185, 28);
		panel_1.add(txtHargaKg);
		
		JLabel lblJumlah = new JLabel("Jumlah");
		lblJumlah.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblJumlah.setBounds(10, 310, 107, 17);
		panel_1.add(lblJumlah);
		
		txtJumlah = new JTextField();
		txtJumlah.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
		        if (!txtTotal2.getText().isEmpty() && !txtJumlah.getText().isEmpty()) {
		            txtHargaKg.setText("" + hargabagi(Double.parseDouble(txtTotal2.getText()), Double.parseDouble(txtJumlah.getText())));
		        }
		    }
		});

		txtJumlah.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        if (!txtJumlah.getText().isEmpty() && !txtHargaKg.getText().isEmpty()) {
		            txtTotal2.setText("" + total(Double.parseDouble(txtHargaKg.getText()), Double.parseDouble(txtJumlah.getText())));
		        } else {
		            txtTotal2.setText("");
		        }
		    }
		});
		txtJumlah.setColumns(10);
		txtJumlah.setBounds(10, 334, 185, 28);
		panel_1.add(txtJumlah);
		
		txtTotal2 = new JTextField();
		txtTotal2.setColumns(10);
		txtTotal2.setBounds(254, 334, 185, 28);
		panel_1.add(txtTotal2);
		
		JLabel lblTotal_1 = new JLabel("Total");
		lblTotal_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTotal_1.setBounds(254, 310, 107, 17);
		panel_1.add(lblTotal_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 453, 457, 215);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable(); //Table Order Detail
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = table_1.getValueAt(table_1.getSelectedRow(),0).toString();
				txtJenis1.setText(table_1.getValueAt(table_1.getSelectedRow(),1).toString());
				txtJumlah.setText(table_1.getValueAt(table_1.getSelectedRow(),2).toString());
				txtTotal2.setText(table_1.getValueAt(table_1.getSelectedRow(),3).toString()+".0");
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Qty", "Jenis", "Total"
			}
		));
		table_1.getColumnModel().getColumn(2).setPreferredWidth(88);
		scrollPane_1.setViewportView(table_1);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderDetail ordd = new OrderDetail();
				ordd.setJenis(txtJenis1.getText());
				ordd.setQty(txtJumlah.getText());
				ordd.setTotal(txtTotal2.getText());
				ordd.setHarga(txtHargaKg.getText());
				reset();
				odr.save(ordd);
				loadTable1();
				loadDataRp();
			}
		});
		btnSimpan.setBounds(10, 394, 85, 21);
		panel_1.add(btnSimpan);
		
		JButton btnUbah = new JButton("Ubah");
		btnUbah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderDetail ordd = new OrderDetail();
				ordd.setJenis(txtJenis1.getText());
				ordd.setQty(txtJumlah.getText());
				ordd.setTotal(txtTotal2.getText());
				ordd.setId(id);
				odr.update(ordd);
				reset();
				loadTable1();
				loadDataRp();
			}
		});
		
		btnUbah.setBounds(139, 394, 85, 21);
		panel_1.add(btnUbah);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id != null) {
					odr.delete(id);
					reset();
					loadTable1();
					loadDataRp();
				}else {
					JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan di hapus");
				}
			}
		});
		btnHapus.setBounds(268, 394, 85, 21);
		panel_1.add(btnHapus);
		
		JButton btnBatal_1 = new JButton("Batal");
		btnBatal_1.setBounds(382, 394, 85, 21);
		panel_1.add(btnBatal_1);
		
		txtJenis1 = new JTextField();
		txtJenis1.setBounds(254, 269, 185, 28);
		panel_1.add(txtJenis1);
		txtJenis1.setColumns(10);
		
		JLabel lblJenis = new JLabel("Jenis");
		lblJenis.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblJenis.setBounds(254, 245, 107, 17);
		panel_1.add(lblJenis);
	}
}