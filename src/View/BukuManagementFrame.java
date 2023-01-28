package View;

import Controller.BukuController;
import Entity.Buku_Entity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class BukuManagementFrame extends MainFrame{
    private JLabel perpusLabel,juduLabel,karanganLabel,tambahLabel,penerbitLabel, tahunLabel,jumlahLabel;
    private JTextField juduField,karanganField,penerbField,tahunField,jumField;
    private JButton saveBtn,keluarBtn,hapusButton,editButton;
    private JTable bukuTable;
    private JScrollPane scrollPane;

    private JTextField selectedField = new JTextField();
    public BukuManagementFrame() {
        super("Buku Management", 1200, 800);
        setLocation(220, 40);
    }

    @Override
    protected void component() {
        perpusLabel = new JLabel("MANAGEMENT BUKU");
        perpusLabel.setFont(new Font("Arial", Font.BOLD, 24));
        perpusLabel.setForeground(color("#2596be"));
        boundedAdd(perpusLabel, 90, 265, 250, 45);

        tambahLabel = new JLabel("TAMBAH BUKU");
        tambahLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tambahLabel.setForeground(color("#2596be"));
        boundedAdd(tambahLabel, 100, 300, 200, 45);

        juduLabel = new JLabel("JUDUL BUKU");
        juduLabel.setFont(new Font("Arial", Font.BOLD, 13));
        boundedAdd(juduLabel, 65, 350, 200, 18);

        juduField = new JTextField();
        boundedAdd(juduField, 65, 370, 200, 30);

        karanganLabel = new JLabel("KARANGAN BUKU");
        karanganLabel.setFont(new Font("Arial", Font.BOLD, 15));
        boundedAdd(karanganLabel, 65, 410, 200, 18);

        karanganField = new JTextField();
        boundedAdd(karanganField, 65, 430, 200, 30);

        penerbitLabel = new JLabel("PENERBIT BUKU");
        penerbitLabel.setFont(new Font("Arial", Font.BOLD, 15));
        boundedAdd(penerbitLabel, 65, 470, 200, 18);

        penerbField = new JTextField();
        boundedAdd(penerbField, 65, 490, 200, 30);

        tahunLabel = new JLabel("TAHUN TERBIT");
        tahunLabel.setFont(new Font("Arial", Font.BOLD, 15));
        boundedAdd(tahunLabel, 65, 530, 200, 18);

        tahunField = new JTextField();
        boundedAdd(tahunField, 65, 550, 200, 30);

        jumlahLabel = new JLabel("JUMLAH BUKU");
        jumlahLabel.setFont(new Font("Arial", Font.BOLD, 15));
        boundedAdd(jumlahLabel, 65, 590, 200, 18);

        jumField = new JTextField();
        boundedAdd(jumField, 65, 610, 200, 30);

        bukuTable = new JTable();
        bukuTable.setModel(createDataTable());
        bukuTable.getTableHeader().setReorderingAllowed(false);
        scrollPane = new JScrollPane(bukuTable);
        boundedAdd(scrollPane, 350, 72, 745, 440);

        saveBtn = new JButton("SAVE");
        saveBtn.setForeground(Color.white);
        saveBtn.setBackground(color("#2596be"));
        saveBtn.setFocusPainted(false);
        boundedAdd(saveBtn, 115, 650, 85, 30);

        keluarBtn = new JButton("Keluar");
        keluarBtn.setForeground(Color.white);
        keluarBtn.setBackground(color("#ff0000"));
        keluarBtn.setFocusPainted(false);
        boundedAdd(keluarBtn, 115, 690, 85, 30);

        hapusButton = new JButton("Hapus");
        hapusButton.setForeground(Color.white);
        hapusButton.setBackground(color("#2596be"));
        hapusButton.setFocusPainted(false);
        boundedAdd(hapusButton, 550, 650, 85, 30);

        editButton = new JButton("Edit");
        editButton.setForeground(Color.white);
        editButton.setBackground(color("#ff0000"));
        editButton.setFocusPainted(false);
        boundedAdd(editButton, 550, 690, 85, 30);
    }

    @Override
    protected void event() {
        saveBtn.addActionListener((e)-> {
            try {
                String JudulBuku = juduField.getText();
                String karangan = karanganField.getText();
                String penerbit = penerbField.getText();
                int tahunTerbit = Integer.parseInt(tahunField.getText());
                int jumlah = Integer.parseInt(jumField.getText());

                BukuController buku = new BukuController();
                buku.tambahBuku(JudulBuku, karangan, penerbit, tahunTerbit, jumlah);
                JOptionPane.showMessageDialog(null, "Sukses DITAMBAH", "Sukses",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new BukuManagementFrame().setVisible(true);
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "Tahun Terbit dan Jumlah Buku Harus Angka ", "Gagal",
                        JOptionPane.ERROR_MESSAGE);
                dispose();
                new BukuManagementFrame().setVisible(true);
            }
        });

        bukuTable.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = bukuTable.getSelectedRow();
                String selectedId = bukuTable.getValueAt(i, 0).toString();
                selectedField.setText(selectedId);
            }
        });

        hapusButton.addActionListener((e) -> {
            String judul = selectedField.getText();
            BukuController buku = new BukuController();
            Buku_Entity objekBuku = buku.cari(judul);
            if(objekBuku!=null){
                buku.hapus(objekBuku);
                dispose();
                new BukuManagementFrame().setVisible(true);
            }
        });

        editButton.addActionListener((e)-> {
            String judul = selectedField.getText();
            int jumlah = Integer.parseInt(jumField.getText());
            BukuController buku = new BukuController();
            Buku_Entity objekBuku = buku.cari(judul);
            if(objekBuku!=null){
                buku.edit(objekBuku, jumlah);
                dispose();
                new BukuManagementFrame().setVisible(true);
            }
        });

        keluarBtn.addActionListener((e) ->{
            dispose();
            new Menu_AdminFrame().setVisible(true);
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
