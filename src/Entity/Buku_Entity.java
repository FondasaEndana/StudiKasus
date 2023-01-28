package Entity;

public class Buku_Entity {
    private String JudulBuku;
    private String karangan;
    private String penerbit;
    private int tahunTerbit;
    private int jumlah;
    private int pinjam = 1;

    public Buku_Entity(String JudulBuku, String karangan, String penerbit, int tahunTerbit, int jumlah) {
        this.JudulBuku = JudulBuku;
        this.karangan = karangan;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.jumlah = jumlah;
    }

    public String getJudulBuku() {
        return this.JudulBuku;
    }

    public void setJudulBuku(String JudulBuku) {
        this.JudulBuku = JudulBuku;
    }

    public String getKarangan() {
        return this.karangan;
    }

    public void setKarangan(String karangan) {
        this.karangan = karangan;
    }

    public String getPenerbit() {
        return this.penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getTahunTerbit() {
        return this.tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }


    public int getPinjam(){
        return this.jumlah -= this.pinjam;
    }

    public int getKembali(){
        return this.jumlah += this.pinjam;
    }

    public int getJumlah() {
        return this.jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
