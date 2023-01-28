package Entity;

public class Admin_Entity extends User_Entity{
    private String nama;

    public Admin_Entity(int id, String password,String nama) {
        super(id, password);
        this.nama = nama;
    }

    public Admin_Entity() {
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
