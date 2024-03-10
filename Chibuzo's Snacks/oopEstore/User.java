package oopEstore;

public class User {
    private int id;
    private String name;
    private int age;
    private String emailAddress;
    private Address homeAddress;
    private String password;
    private  String phone;

    public User(int id, String name, int age, String emailAddress, Address homeAddress, String password, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
        this.homeAddress = homeAddress;
        this.password = password;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public final boolean isCorrect(String password) {
        return this.password.equals(password);
    }
}
