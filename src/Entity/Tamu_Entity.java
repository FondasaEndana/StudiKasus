package Entity;

public class Tamu_Entity extends User_Entity{
    private String nama;
    private String alamat;
    private String pekerjaan;

    public Tamu_Entity(int id, String password,String nama, String alamat, String pekerjaan) {
        super(id, password);
        this.nama = nama;
        this.alamat = alamat;
        this.pekerjaan = pekerjaan;
    }

    public Tamu_Entity() {
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPekerjaan() {
        return this.pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }
}
