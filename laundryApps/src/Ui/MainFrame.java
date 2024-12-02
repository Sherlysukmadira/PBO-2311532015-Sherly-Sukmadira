package Ui;

import util.ValidationArray;
import error.ValidationException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    private int[] dataArray = new int[10]; // Array untuk menyimpan data
    private int currentIndex = 0;

    private JTextField inputField;
    private JTextField indexField;
    private JTextArea outputArea;
    private JButton btnSimpan;
    private JButton btnCek;

    public MainFrame() {
        setTitle("Main Frame - Array Management");
        setSize(499, 540);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel inputLabel = new JLabel("Masukkan Angka:");
        inputLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        inputLabel.setBounds(20, 79, 126, 29);
        getContentPane().add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(167, 80, 172, 27);
        getContentPane().add(inputField);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(367, 81, 100, 25);
        getContentPane().add(btnSimpan);

        JLabel indexLabel = new JLabel("Cek Index:");
        indexLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        indexLabel.setBounds(20, 193, 100, 25);
        getContentPane().add(indexLabel);

        indexField = new JTextField();
        indexField.setBounds(167, 192, 172, 29);
        getContentPane().add(indexField);

        btnCek = new JButton("Cek");
        btnCek.setBounds(367, 194, 100, 27);
        getContentPane().add(btnCek);

        outputArea = new JTextArea();
        outputArea.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	}
        });
        outputArea.setBounds(20, 291, 447, 175);
        getContentPane().add(outputArea);
        
        JLabel infoData = new JLabel("Data: "); // Teks default langsung diatur
        infoData.setBounds(167, 137, 223, 25);
        getContentPane().add(infoData);
        
        infoData.setBounds(167, 137, 223, 25);
        getContentPane().add(infoData);
        
        JLabel lblData = new JLabel("Data     :");
        lblData.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblData.setBounds(20, 137, 100, 25);
        getContentPane().add(lblData);

        
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Ambil input dari pengguna
                    String input = inputField.getText().trim();

                    // Pecah input menjadi array string berdasarkan koma
                    String[] inputArray = input.split(",");

                    for (String str : inputArray) {
                        // Hilangkan spasi jika ada
                        str = str.trim();

                        // Parse setiap elemen menjadi angka
                        int value = Integer.parseInt(str);

                        // Simpan ke array jika masih ada ruang
                        if (currentIndex < dataArray.length) {
                            dataArray[currentIndex++] = value;
                        } else {
                            JOptionPane.showMessageDialog(null, "Array sudah penuh!");
                            return;
                        }
                    }

                    // Update tampilan data di JLabel infoData
                    StringBuilder dataString = new StringBuilder();
                    for (int i = 0; i < currentIndex; i++) {
                        dataString.append(dataArray[i]).append(", ");
                    }
                    if (dataString.length() > 0) {
                        dataString.setLength(dataString.length() - 2); // Hapus koma terakhir
                    }
                    infoData.setText(dataString.toString());

                    // Kosongkan input field
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus berupa angka, dipisahkan dengan koma!");
                }
            }
        });

        

        btnCek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(indexField.getText().trim());

                    // Validasi array index
                    ValidationArray.ValidateArrayIndex(dataArray, index);

                    // Tampilkan hasil pengecekan di outputArea
                    outputArea.setText("Hasil index ke-" + index + " adalah " + dataArray[index]);
                } catch (ValidationException ex) {
                    outputArea.setText(ex.getMessage()); // Pesan error dari ValidationException
                } catch (ArrayIndexOutOfBoundsException ex) {
                    outputArea.setText("Index di luar batas array");
                } catch (NumberFormatException ex) {
                    outputArea.setText("Index harus berupa angka");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
