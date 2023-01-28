package View;

import javax.swing.*;
import java.awt.*;

public class Menu_AdminFrame extends MainFrame{
    private JButton bukuButton,dataButton,keluarButton;
    public Menu_AdminFrame() {
        super("Menu", 400, 600);
    }

    @Override
    protected void component() {
        dataButton = new JButton("MANAGEMENT BUKU");
        dataButton.setForeground(Color.white);
        dataButton.setBackground(color("#ff0000"));
        dataButton.setFocusPainted(false);
        boundedAdd(dataButton, 80, 300, 250, 30);

        bukuButton = new JButton("MANAGEMENT DATA PERPUS");
        bukuButton.setForeground(Color.white);
        bukuButton.setBackground(color("#000080"));
        bukuButton.setFocusPainted(false);
        boundedAdd(bukuButton, 80, 350, 250, 30);

        keluarButton = new JButton("KELUAR");
        keluarButton.setForeground(Color.white);
        keluarButton.setBackground(color("#ff0000"));
        keluarButton.setFocusPainted(false);
        boundedAdd(keluarButton, 80, 400, 250, 30);
    }

    @Override
    protected void event() {
        dataButton.addActionListener((e)->{
            dispose();
            new BukuManagementFrame().setVisible(true);
        });

        bukuButton.addActionListener((e) -> {
            dispose();
            new DataPerpusFrame().setVisible(true);
        });

        keluarButton.addActionListener((e)-> {
            dispose();
            new MenuFrame().setVisible(true);
        });
    }
}
