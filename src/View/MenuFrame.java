package View;

import javax.swing.*;
import java.awt.*;

public class MenuFrame extends MainFrame{
    private JButton userButton,admiButton;
    public MenuFrame() {
        super("Menu", 400, 600);
    }

    @Override
    protected void component() {
        userButton = new JButton("Pengunjung");
        userButton.setForeground(Color.white);
        userButton.setBackground(color("#000080"));
        userButton.setFocusPainted(false);
        boundedAdd(userButton, 145, 350, 100, 30);

        admiButton = new JButton("Admin");
        admiButton.setForeground(Color.white);
        admiButton.setBackground(color("#ff0000"));
        admiButton.setFocusPainted(false);
        boundedAdd(admiButton, 145, 300, 100, 30);
    }

    @Override
    protected void event() {
        admiButton.addActionListener((e)->{
            dispose();
            new LoginAdminFrame().setVisible(true);
        });

        userButton.addActionListener((e) -> {
            dispose();
            new MenuTamuFrame().setVisible(true);
        });
    }
}
