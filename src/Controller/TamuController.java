package Controller;

import Entity.Tamu_Entity;
import Model.Model_Tamu;
import java.util.ArrayList;

public class TamuController {
    public ArrayList<Tamu_Entity> all(){
        return Model_Tamu.all();
    }

    public Tamu_Entity login(int id, String password){
        return Model_Tamu.cariLogin(id, password);
    }

    public Tamu_Entity cariPengunjung(int id){
        return Model_Tamu.cariPengnjung(id);
    }

    public void hapus(Tamu_Entity pengunjung){
        Model_Tamu.remove(pengunjung);
    }

    public void edit(Tamu_Entity pengunjung, String password,String alamat){
        Model_Tamu.editPassAlamat(pengunjung, password, alamat);
    }

    public void tambahPengunjung(int id, String password,String nama, String alamat, String pekerjaan){
        Tamu_Entity pengunjung = new Tamu_Entity(id, password, nama, alamat, pekerjaan);
        Model_Tamu.tambahPengunjung(pengunjung);
    }
}
