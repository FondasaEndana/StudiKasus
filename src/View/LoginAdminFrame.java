package View;

import Controller.AdminController;
import Entity.Admin_Entity;
import javax.swing.*;
import java.awt.*;

public class LoginAdminFrame extends MainFrame{
    private AdminController admin = new AdminController();
    private JLabel perpusLabel,loginLabel,idLabel, passwordLabel;
    private JTextField idField;
    private JPasswordField passwordField;
    private JButton loginBtn,keluarBtn;

    public LoginAdminFrame() {
        super("LOGIN", 400, 600);
    }

    @Override
    protected void component() {

        perpusLabel = new JLabel("PERPUSTAKAAN");
        perpusLabel.setFont(new Font("Arial", Font.BOLD, 24));
        perpusLabel.setForeground(color("#2596be"));
        boundedAdd(perpusLabel, 100, 265, 200, 45);

        loginLabel = new JLabel("LOGIN ADMIN");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 20));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        boundedAdd(loginLabel, 95, 300, 200, 30);

        idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Arial", Font.BOLD, 13));
        boundedAdd(idLabel, 65, 350, 100, 18);

        idField = new JTextField();
        boundedAdd(idField, 65, 370, 270, 30);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 13));
        boundedAdd(passwordLabel, 65, 415, 65, 18);

        passwordField = new JPasswordField();
        boundedAdd(passwordField, 65, 435, 270, 30);

        loginBtn = new JButton("Masuk");
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
                String password = String.valueOf(passwordField.getPassword());
                Admin_Entity objekAdmin = admin.cari(id, password);
                if (objekAdmin!=null) {
                    JOptionPane.showMessageDialog(null, "Hallo " + objekAdmin.getNama(), "Login Sukses",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new Menu_AdminFrame().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Id atau Password Salah", "Login Gagal",
                            JOptionPane.ERROR_MESSAGE);
                    dispose();
                    new LoginAdminFrame().setVisible(true);
                }
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "ID Harus Angka", "Login Gagal",
                        JOptionPane.ERROR_MESSAGE);
                dispose();
                new LoginAdminFrame().setVisible(true);
            }
        });

        keluarBtn.addActionListener((e) -> {
            dispose();
            new MenuFrame().setVisible(true);
        });
    }
}
