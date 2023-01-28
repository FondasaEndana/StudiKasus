package Entity;

import Utility.Information;

public class DataPerpus_Entity {
    private Tamu_Entity pengunjung;
    private Buku_Entity buku;
    private String tanggalPinjam;
    private String tanggalKembali;

    public DataPerpus_Entity(Tamu_Entity pengunjung, Buku_Entity buku) {
        this.pengunjung = pengunjung;
        this.buku = buku;
        this.tanggalPinjam = Information.now();
    }

    public Tamu_Entity getPengunjung() {
        return this.pengunjung;
    }

    public void setPengunjung(Tamu_Entity pengunjung) {
        this.pengunjung = pengunjung;
    }

    public Buku_Entity getBuku() {
        return this.buku;
    }

    public void setBuku(Buku_Entity buku) {
        this.buku = buku;
    }

    public String getTanggalPinjam() {
        return this.tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali() {
        return this.tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

}
