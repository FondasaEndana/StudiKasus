package Model;

import Entity.Tamu_Entity;
import java.util.ArrayList;

public class Model_Tamu {
    private static ArrayList<Tamu_Entity> arrayPengunjung = new ArrayList<>();

    public static ArrayList<Tamu_Entity> all(){
        return arrayPengunjung;
    }

    public static void tambahPengunjung(Tamu_Entity pengunjung){
        arrayPengunjung.add(pengunjung);
    }

    public static Tamu_Entity cariLogin(int id, String password){
        for(Tamu_Entity objek : arrayPengunjung){
            if(objek.getId()==id && objek.getPassword().equals(password)){
                return objek;
            }
        }
        return null;
    }

    public static void remove(Tamu_Entity pengunjung) {
        arrayPengunjung.remove(pengunjung);
    }

    public static Tamu_Entity cariPengnjung(int id){
        for(Tamu_Entity objek : arrayPengunjung){
            if(objek.getId()==id){
                return objek;
            }
        }
        return null;
    }

    public static void editPassAlamat(Tamu_Entity pengunjung, String password,String alamat){
        pengunjung.setPassword(password);
        pengunjung.setAlamat(alamat);
    }
}
