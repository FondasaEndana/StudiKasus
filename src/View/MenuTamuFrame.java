package View;

import javax.swing.*;
import java.awt.*;

public class MenuTamuFrame extends MainFrame {
    private JButton daftarButton,pinjamButton,kembaliBukuButton,keluarButton;
    public MenuTamuFrame() {
        super("Menu Tamu", 400, 600);
    }

    @Override
    protected void component() {
        daftarButton = new JButton("Daftar");
        daftarButton.setForeground(Color.white);
        daftarButton.setBackground(color("#ff0000"));
        daftarButton.setFocusPainted(false);
        boundedAdd(daftarButton, 125, 270, 150, 30);

        pinjamButton = new JButton("Pinjam Buku");
        pinjamButton.setForeground(Color.white);
        pinjamButton.setBackground(Color.BLUE);
        pinjamButton.setFocusPainted(false);
        boundedAdd(pinjamButton, 125, 320, 150, 30);

        kembaliBukuButton = new JButton("Kembalikan Buku");
        kembaliBukuButton.setForeground(Color.white);
        kembaliBukuButton.setBackground(color("#ff0000"));
        kembaliBukuButton.setFocusPainted(false);
        boundedAdd(kembaliBukuButton, 125, 370, 150, 30);

        keluarButton = new JButton("Keluar");
        keluarButton.setForeground(Color.white);
        keluarButton.setBackground(Color.BLUE);
        keluarButton.setFocusPainted(false);
        boundedAdd(keluarButton, 125, 420, 150, 30);
    }

    @Override
    protected void event() {
        daftarButton.addActionListener((e) -> {
            dispose();
            new DaftarTamuFrame().setVisible(true);
        });

        pinjamButton.addActionListener((e)->{
            dispose();
            new PinjamFrame().setVisible(true);
        });

        kembaliBukuButton.addActionListener((e)->{
            dispose();
            new BukuKembaliFrame().setVisible(true);
        });

        keluarButton.addActionListener((e)->{
            dispose();
            new MenuFrame().setVisible(true);
        });
    }
}
