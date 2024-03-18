package data.models;

public class Diary {
    private String username;
    private String password;
    private int id;
    private boolean isLocked = true;

    public Diary() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLock(boolean status) {
        isLocked = status;
    }
}
