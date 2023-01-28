package Controller;

import Model.Model_DataPerpus;
import Entity.DataPerpus_Entity;
import Entity.Tamu_Entity;
import Entity.Buku_Entity;
import Utility.Information;


import java.util.ArrayList;

public class DataPerpusController {
    public ArrayList<DataPerpus_Entity> all(){
        return Model_DataPerpus.all();
    }

    public void data(Tamu_Entity pengunjung, Buku_Entity buku){
        buku.getPinjam();
        Model_DataPerpus.dataPerpus(pengunjung, buku);
    }

    public void hapus(DataPerpus_Entity data){
        Model_DataPerpus.remove(data);
    }

    public void editAlamatUser(DataPerpus_Entity data,String password,String alamat){
        Model_DataPerpus.edit(data,password ,alamat);
    }

    public DataPerpus_Entity cari(int id){
        return Model_DataPerpus.cariUser(id);
    }

    public DataPerpus_Entity kembali(int id,String judul){
        DataPerpus_Entity data = Model_DataPerpus.cari(id, judul);
        if(data!=null){
            data.getBuku().getKembali();
            data.setTanggalKembali(Information.now());
            return data;
        }else{
            return null;
        }
    }
}
