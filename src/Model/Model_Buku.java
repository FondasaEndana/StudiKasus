package Model;

import Entity.Buku_Entity;
import java.util.ArrayList;

public class Model_Buku {
    private static ArrayList<Buku_Entity> arrayBuku = new ArrayList<>();

    public static ArrayList<Buku_Entity> all(){
        return arrayBuku;
    }

    public static void tambahBuku(Buku_Entity buku){
        arrayBuku.add(buku);
    }

    public static void initialBuku(){
        arrayBuku.add(new Buku_Entity("java", "ucu", "airlangga", 2002, 4));
        arrayBuku.add(new Buku_Entity("pkn", "pras", "joko", 2000, 0));
        arrayBuku.add(new Buku_Entity("kancil", "pras", "putra", 2000,1));
    }

    public static Buku_Entity cari(String judul){
        for(Buku_Entity objek : arrayBuku){
            if(objek.getJudulBuku().equals(judul)){
                return objek;
            }
        }
        return null;
    }

    public static void edit(Buku_Entity buku,int jumlah){
        buku.setJumlah(jumlah);
    }

    public static void remove(Buku_Entity buku) {
        arrayBuku.remove(buku);
    }
}
