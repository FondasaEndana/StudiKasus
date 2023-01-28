package View;

import Controller.TamuController;
import javax.swing.*;
import java.awt.*;

public class DaftarTamuFrame extends MainFrame{
    private JLabel idLabel,passwordLabel,namaLabel,alamatLabel,pekerjaanLabel;
    private JTextField idField,passworField,namaField,alamaField,pekerjaanField;
    private JButton saveBtn,keluarBtn;
    public DaftarTamuFrame() {
        super("Tamu", 700, 600);
    }

    @Override
    protected void component() {
        idLabel = new JLabel("ID Pengunjung");
        idLabel.setFont(new Font("Arial", Font.BOLD, 13));
        boundedAdd(idLabel, 65, 250, 200, 18);

        idField = new JTextField();
        boundedAdd(idField, 65, 270, 200, 30);

        passwordLabel = new JLabel("Password Pengunjung");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));
        boundedAdd(passwordLabel, 65, 305, 200, 18);

        passworField = new JTextField();
        boundedAdd(passworField, 65, 325, 200, 30);

        namaLabel = new JLabel("Nama Pengunjung");
        namaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        boundedAdd(namaLabel, 65, 360, 200, 18);

        namaField = new JTextField();
        boundedAdd(namaField, 65, 380, 200, 30);

        alamatLabel = new JLabel("Alamat Pengunjung");
        alamatLabel.setFont(new Font("Arial", Font.BOLD, 15));
        boundedAdd(alamatLabel, 400, 250, 200, 18);

        alamaField = new JTextField();
        boundedAdd(alamaField, 400, 270, 200, 30);

        pekerjaanLabel = new JLabel("Pekerjaan Pengunjung");
        pekerjaanLabel.setFont(new Font("Arial", Font.BOLD, 15));
        boundedAdd(pekerjaanLabel, 400, 305, 200, 18);

        pekerjaanField = new JTextField();
        boundedAdd(pekerjaanField, 400, 325, 200, 30);


        keluarBtn = new JButton("Keluar");
        keluarBtn.setForeground(Color.white);
        keluarBtn.setBackground(Color.red);
        keluarBtn.setFocusPainted(false);
        boundedAdd(keluarBtn, 280, 505, 85, 30);

        saveBtn = new JButton("Save");
        saveBtn.setForeground(Color.white);
        saveBtn.setBackground(color("#2596be"));
        saveBtn.setFocusPainted(false);
        boundedAdd(saveBtn, 280, 450, 85, 30);
    }

    @Override
    protected void event() {
        saveBtn.addActionListener((e) -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String password = passworField.getText();
                String nama = namaField.getText();
                String alamat = alamaField.getText();
                String pekerjaan = pekerjaanField.getText();

                TamuController pengunjung = new TamuController();
                pengunjung.tambahPengunjung(id, password, nama, alamat, pekerjaan);
                JOptionPane.showMessageDialog(null, "Sukses ", "Sukses Daftar",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new DaftarTamuFrame().setVisible(true);
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "Id Harus Angka", "Gagal Daftar",
                        JOptionPane.ERROR_MESSAGE);
                dispose();
                new DaftarTamuFrame().setVisible(true);
            }
        });

        keluarBtn.addActionListener((e)->{
            dispose();
            new MenuTamuFrame().setVisible(true);
        });
    }
}
