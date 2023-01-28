package View;

import Controller.DataPerpusController;
import Controller.TamuController;
import Entity.DataPerpus_Entity;
import Entity.Tamu_Entity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DataPerpusFrame extends MainFrame {
    private JTable pengunjungTable,dataPerpusTable;
    private JScrollPane scrollPane;
    private JLabel perpusLabel,passwordLabel,alamatLabel;
    private JTextField alamatField;
    private JPasswordField passwordField;
    private JButton keluarBtn,editButton,hapusButton,refreshButton;
    private JTextField selectedField = new JTextField();
    public DataPerpusFrame() {
        super("Data Management", 1450, 800);
        setLocation(40, 40);
    }

    @Override
    protected void component() {
        perpusLabel = new JLabel("PERPUSTAKAAN");
        perpusLabel.setFont(new Font("Arial", Font.BOLD, 24));
        perpusLabel.setForeground(color("#2596be"));
        boundedAdd(perpusLabel, 100, 265, 200, 45);

        alamatLabel = new JLabel("ALAMAT PENGUNJUNG");
        alamatLabel.setFont(new Font("Arial", Font.BOLD, 13));
        boundedAdd(alamatLabel, 65, 350, 150, 18);

        alamatField = new JTextField();
        boundedAdd(alamatField, 65, 370, 270, 30);

        passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 13));
        boundedAdd(passwordLabel, 65, 415, 150, 18);

        passwordField = new JPasswordField();
        boundedAdd(passwordField, 65, 435, 270, 30);

        pengunjungTable = new JTable();
        pengunjungTable.setModel(createDataPerpusTable());
        pengunjungTable.setEnabled(false);
        pengunjungTable.getTableHeader().setReorderingAllowed(false);
        scrollPane = new JScrollPane(pengunjungTable);
        boundedAdd(scrollPane, 400, 72, 900, 200);

        dataPerpusTable = new JTable();
        dataPerpusTable.setModel(createDataPerpusTable());
        dataPerpusTable.getTableHeader().setReorderingAllowed(false);
        scrollPane = new JScrollPane(dataPerpusTable);
        boundedAdd(scrollPane, 400, 300, 1000, 200);

        editButton = new JButton("Edit");
        editButton.setForeground(Color.white);
        editButton.setBackground(color("#ff0000"));
        editButton.setFocusPainted(false);
        boundedAdd(editButton, 257, 525, 85, 30);

        hapusButton = new JButton("Hapus");
        hapusButton.setForeground(Color.white);
        hapusButton.setBackground(Color.BLUE);
        hapusButton.setFocusPainted(false);
        boundedAdd(hapusButton, 157, 525, 85, 30);

        refreshButton = new JButton("Refresh");
        refreshButton.setForeground(Color.white);
        refreshButton.setBackground(Color.blue);
        refreshButton.setFocusPainted(false);
        boundedAdd(refreshButton, 357, 525, 85, 30);

        keluarBtn = new JButton("Keluar");
        keluarBtn.setForeground(Color.white);
        keluarBtn.setBackground(color("#ff0000"));
        keluarBtn.setFocusPainted(false);
        boundedAdd(keluarBtn, 57, 525, 85, 30);
    }

    @Override
    protected void event() {
        dataPerpusTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = dataPerpusTable.getSelectedRow();
                String selectedId = dataPerpusTable.getValueAt(i, 0).toString();
                selectedField.setText(selectedId);
            }
        });

        editButton.addActionListener((e)-> {
            int id = Integer.parseInt(selectedField.getText());
            String alamat = alamatField.getText();
            String password = String.valueOf(passwordField.getPassword());

            DataPerpusController objekData = new DataPerpusController();
            TamuController objekPengunjung = new TamuController();

            DataPerpus_Entity data = objekData.cari(id);
            Tamu_Entity pengunjung = objekPengunjung.cariPengunjung(id);
            if(data!=null){
                objekData.editAlamatUser(data, password, alamat);
                objekPengunjung.edit(pengunjung, password, alamat);
                JOptionPane.showMessageDialog(null, "SUKSES EDIT DATA", "SUKSES",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new DataPerpusFrame().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "DATA TIDAK ADA", "GAGAL",
                        JOptionPane.ERROR_MESSAGE);
                dispose();
                new DataPerpusFrame().setVisible(true);
            }
        });

        hapusButton.addActionListener((e) -> {
            int id = Integer.parseInt(selectedField.getText());

            DataPerpusController objekData = new DataPerpusController();
            TamuController objekPengunjung = new TamuController();

            DataPerpus_Entity data = objekData.cari(id);
            Tamu_Entity pengunjung = objekPengunjung.cariPengunjung(id);
            if(data!=null){
                objekData.hapus(data);
                objekPengunjung.hapus(pengunjung);
                JOptionPane.showMessageDialog(null, "HAPUS DATA SUKSES", "SUKSES",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new DataPerpusFrame().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "DATA TIDAK ADA", "GAGAL",
                        JOptionPane.ERROR_MESSAGE);
                dispose();
                new DataPerpusFrame().setVisible(true);
            }
        });

        refreshButton.addActionListener((e) -> {
            dispose();
            new DataPerpusFrame().setVisible(true);
        });

        keluarBtn.addActionListener((e) -> {
            dispose();
            new Menu_AdminFrame().setVisible(true);
        });
    }

    private DefaultTableModel createDataPerpusTable() {
        DefaultTableModel dataTable = new DefaultTableModel();
        Object column[] = {
                "ID",
                "Nama",
                "Alamat",
                "Pekerjaan",
                "Judul",
                "Karangan",
                "Penerbit",
                "Tahun Terbit",
                "Tanggal Pinjam",
                "Tanggal Kembali"
        };
        dataTable.setColumnIdentifiers(column);
        DataPerpusController objekData = new DataPerpusController();
        ArrayList<DataPerpus_Entity> arrayData = objekData.all();

        for (DataPerpus_Entity objek : arrayData) {

            Object[] data = new String[] {
                    String.valueOf(objek.getPengunjung().getId()),
                    objek.getPengunjung().getNama(),
                    objek.getPengunjung().getAlamat(),
                    objek.getPengunjung().getPekerjaan(),
                    objek.getBuku().getJudulBuku(),
                    objek.getBuku().getKarangan(),
                    objek.getBuku().getPenerbit(),
                    String.valueOf(objek.getBuku().getTahunTerbit()),
                    objek.getTanggalPinjam(),
                    objek.getTanggalKembali()
            };
            dataTable.addRow(data);
        }
        return dataTable;
    }
}
