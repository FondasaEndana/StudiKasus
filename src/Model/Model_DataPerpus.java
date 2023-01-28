package Model;

import Entity.Buku_Entity;
import Entity.DataPerpus_Entity;
import Entity.Tamu_Entity;

import java.util.ArrayList;

public class Model_DataPerpus {
    private static ArrayList<DataPerpus_Entity> arrayData = new ArrayList<>();

    public static ArrayList<DataPerpus_Entity> all(){
        return arrayData;
    }

    public static void dataPerpus(Tamu_Entity pengunjung, Buku_Entity buku){
        arrayData.add(new DataPerpus_Entity(pengunjung, buku));
    }

    public static DataPerpus_Entity cari(int id,String judul){
        for(DataPerpus_Entity objek : arrayData){
            if(objek.getPengunjung().getId() == id && objek.getBuku().getJudulBuku().equals(judul)){
                return objek;
            }
        }
        return null;
    }

    public static DataPerpus_Entity cariUser(int id){
        for(DataPerpus_Entity objek : arrayData){
            if(objek.getPengunjung().getId() == id){
                return objek;
            }
        }
        return null;
    }

    public static void edit(DataPerpus_Entity data,String password,String alamat){
        data.getPengunjung().setPassword(password);
        data.getPengunjung().setAlamat(alamat);
    }

    public static void remove(DataPerpus_Entity data) {
        data.getBuku().getKembali();
        arrayData.remove(data);
    }
}
