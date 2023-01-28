package View;

import Controller.DataPerpusController;
import Entity.DataPerpus_Entity;
import javax.swing.*;
import java.awt.*;

public class BukuKembaliFrame extends MainFrame {
    private JLabel perpusLabel,bukuKembaliLabel,idLabel, passwordLabel;
    private JTextField idField,judulBukuField;
    private JButton loginBtn,keluarBtn;
    public BukuKembaliFrame() {
        super("Kembalikan Buku", 400, 600);
    }

    @Override
    protected void component() {
        perpusLabel = new JLabel("PERPUSTAKAAN");
        perpusLabel.setFont(new Font("Arial", Font.BOLD, 24));
        perpusLabel.setForeground(color("#2596be"));
        boundedAdd(perpusLabel, 100, 265, 200, 45);

        bukuKembaliLabel = new JLabel("KEMBALIKAN BUKU");
        bukuKembaliLabel.setFont(new Font("Arial", Font.BOLD, 20));
        bukuKembaliLabel.setHorizontalAlignment(SwingConstants.CENTER);
        boundedAdd(bukuKembaliLabel, 95, 300, 200, 30);

        idLabel = new JLabel("ID PENGUNJUNG");
        idLabel.setFont(new Font("Arial", Font.BOLD, 13));
        boundedAdd(idLabel, 65, 350, 250, 18);

        idField = new JTextField();
        boundedAdd(idField, 65, 370, 270, 30);

        passwordLabel = new JLabel("JUDUL BUKU YANG DIPINJAM");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 13));
        boundedAdd(passwordLabel, 65, 415, 250, 18);

        judulBukuField = new JPasswordField();
        boundedAdd(judulBukuField, 65, 435, 270, 30);

        loginBtn = new JButton("SAVE");
        loginBtn.setForeground(Color.white);
        loginBtn.setBackground(color("#2596be"));
        loginBtn.setFocusPainted(false);
        boundedAdd(loginBtn, 157, 485, 85, 30);

        keluarBtn = new JButton("Keluar");
        keluarBtn.setForeground(Color.white);
        keluarBtn.setBackground(color("#ff0000"));
        keluarBtn.setFocusPainted(false);
        boundedAdd(keluarBtn, 157, 525, 85, 30);
    }

    @Override
    protected void event() {
        loginBtn.addActionListener((e) -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String judul = judulBukuField.getText();

                DataPerpusController data = new DataPerpusController();
                DataPerpus_Entity objekData = data.kembali(id, judul);
                if (objekData!=null) {

                    JOptionPane.showMessageDialog(null, "SUKSES KEMBALIKAN " + objekData.getPengunjung().getNama(), "Kembalikan Buku",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new BukuKembaliFrame().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Id atau Judul Tidak Ada", "Gagal",
                            JOptionPane.ERROR_MESSAGE);
                    dispose();
                    new BukuKembaliFrame().setVisible(true);

                }
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "ID Harus Angka", "Login Gagal",
                        JOptionPane.ERROR_MESSAGE);
                dispose();
                new BukuKembaliFrame().setVisible(true);
            }
        });

        keluarBtn.addActionListener((e) -> {
            dispose();
            new MenuTamuFrame().setVisible(true);
        });
    }
}
