package View;

import Controller.*;
import Entity.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PinjamFrame extends MainFrame{
    private JLabel perpusLabel,idLabel,judulBUkuLabel, passwordLabel;
    private JTextField idField,judulBukuField;
    private JPasswordField passwordField;
    private JButton SaveButton,keluarBtn;
    private JTable bukuTable;
    private JScrollPane scrollPane;
    public PinjamFrame() {
        super("LOGIN", 1200, 600);
        setLocation(290, 100);
    }

    @Override
    protected void component() {
        perpusLabel = new JLabel("PINJAM BUKU");
        perpusLabel.setFont(new Font("Arial", Font.BOLD, 24));
        perpusLabel.setForeground(color("#2596be"));
        boundedAdd(perpusLabel, 90, 265, 200, 45);

        idLabel = new JLabel("ID PENGUNJUNG");
        idLabel.setFont(new Font("Arial", Font.BOLD, 13));
        boundedAdd(idLabel, 50, 300, 150, 18);

        idField = new JTextField();
        boundedAdd(idField, 50, 320, 200, 30);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 13));
        boundedAdd(passwordLabel, 50, 365, 65, 18);

        passwordField = new JPasswordField();
        boundedAdd(passwordField, 50,385, 200, 30);

        judulBUkuLabel = new JLabel("JUDUL BUKU");
        judulBUkuLabel.setFont(new Font("Arial", Font.BOLD, 13));
        boundedAdd(judulBUkuLabel, 50, 425, 100, 18);

        judulBukuField = new JTextField();
        boundedAdd(judulBukuField, 50, 440, 200, 30);

        bukuTable = new JTable();
        bukuTable.setModel(createDataTable());
        bukuTable.setEnabled(false);
        bukuTable.getTableHeader().setReorderingAllowed(false);
        scrollPane = new JScrollPane(bukuTable);
        boundedAdd(scrollPane, 350, 72, 745, 440);

        SaveButton = new JButton("Save");
        SaveButton.setForeground(Color.white);
        SaveButton.setBackground(color("#2596be"));
        SaveButton.setFocusPainted(false);
        boundedAdd(SaveButton, 100, 485, 85, 30);

        keluarBtn = new JButton("Keluar");
        keluarBtn.setForeground(Color.white);
        keluarBtn.setBackground(color("#ff0000"));
        keluarBtn.setFocusPainted(false);
        boundedAdd(keluarBtn, 100, 525, 85, 30);
    }

    @Override
    protected void event() {
        SaveButton.addActionListener((e) -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String password = String.valueOf(passwordField.getPassword());
                String judul = judulBukuField.getText();

                TamuController objek = new TamuController();
                BukuController buku = new BukuController();
                DataPerpusController data = new DataPerpusController();

                Tamu_Entity pengunjung = objek.login(id, password);
                Buku_Entity objekBuku = buku.cari(judul);
                if(pengunjung!=null){
                    if(objekBuku!=null){
                        if(objekBuku.getJumlah()!=0){
                            data.data(pengunjung, objekBuku);
                            JOptionPane.showMessageDialog(null, "SUKSES DIPINJAM", "SUKSES",
                                    JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                            new PinjamFrame().setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null, "BUKU KOSONG", "PILIH YANG LAIN",
                                    JOptionPane.ERROR_MESSAGE);
                            dispose();
                            new PinjamFrame().setVisible(true);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "BUKU TIDAK DITEMUKAN", "TIDAK ADA BUKU",
                                JOptionPane.ERROR_MESSAGE);
                        dispose();
                        new PinjamFrame().setVisible(true);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "ID atau Password Salah", "Pinjam Gagal",
                            JOptionPane.ERROR_MESSAGE);
                    dispose();
                    new PinjamFrame().setVisible(true);
                }
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "ID Harus Angka", "Login Gagal",
                        JOptionPane.ERROR_MESSAGE);
                dispose();
                new PinjamFrame().setVisible(true);
            }

        });

        keluarBtn.addActionListener((e) -> {
            dispose();
            new MenuTamuFrame().setVisible(true);
        });
    }

    private DefaultTableModel createDataTable() {
        DefaultTableModel dataTable = new DefaultTableModel();
        Object column[] = {
                "Judul",
                "Karangan",
                "Penerbit",
                "Tahun Terbit",
                "Jumlah",
        };
        dataTable.setColumnIdentifiers(column);

        BukuController objek = new BukuController();

        ArrayList<Buku_Entity> bukuList = objek.all();

        for (Buku_Entity buku : bukuList) {
            Object[] data = new String[] {
                    buku.getJudulBuku(),
                    buku.getKarangan(),
                    buku.getPenerbit(),
                    String.valueOf(buku.getTahunTerbit()),
                    String.valueOf(buku.getJumlah())
            };

            dataTable.addRow(data);
        }
        return dataTable;
    }
}
