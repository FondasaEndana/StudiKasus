package Controller;

import Model.Model_Buku;
import Entity.Buku_Entity;

import java.util.ArrayList;

public class BukuController {
    public ArrayList<Buku_Entity> all(){
        return Model_Buku.all();
    }

    public Buku_Entity cari(String judul){
        return Model_Buku.cari(judul);
    }

    public void tambahBuku(String JudulBuku, String karangan, String penerbit, int tahunTerbit, int jumlah){
        Buku_Entity buku = new Buku_Entity(JudulBuku, karangan, penerbit, tahunTerbit, jumlah);
        Model_Buku.tambahBuku(buku);
    }

    public void edit(Buku_Entity buku,int jumlah){
        Model_Buku.edit(buku, jumlah);
    }

    public void hapus(Buku_Entity buku){
        Model_Buku.remove(buku);
    }
}
