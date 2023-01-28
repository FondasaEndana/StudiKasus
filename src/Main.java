import Model.Model_Admin;
import Model.Model_Buku;
import View.MenuFrame;

public class Main {
    public static void main(String[] args) {
        Model_Admin.initialAdmin();
        Model_Buku.initialBuku();
        new MenuFrame().setVisible(true);
    }
}