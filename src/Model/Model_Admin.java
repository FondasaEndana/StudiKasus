package Model;

import Entity.Admin_Entity;
import java.util.ArrayList;

public class Model_Admin {
    private static ArrayList<Admin_Entity> arrayAdmin = new ArrayList<>();

    public static ArrayList<Admin_Entity> all(){
        return arrayAdmin;
    }

    public static void initialAdmin(){
        arrayAdmin.add(new Admin_Entity(123, "bobodawgs", "fondasa"));
        arrayAdmin.add(new Admin_Entity(13, "zeroace", "endana"));
    }

    public static Admin_Entity cari(int id, String password){
        for(Admin_Entity objek : arrayAdmin){
            if(objek.getId()==id && objek.getPassword().equalsIgnoreCase(password)){
                return objek;
            }
        }
        return null;
    }
}
