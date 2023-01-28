package Entity;

public abstract class User_Entity {
    private int id;
    private String password;

    public User_Entity(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public User_Entity() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
