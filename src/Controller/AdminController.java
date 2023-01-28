package Controller;

import Entity.Admin_Entity;
import Model.Model_Admin;

import java.util.ArrayList;

public class AdminController {
    public ArrayList<Admin_Entity> all(){
        return Model_Admin.all();
    }

    public Admin_Entity cari(int id, String password){
        return Model_Admin.cari(id, password);
    }
}
