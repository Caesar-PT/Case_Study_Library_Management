package account;

import java.io.Serializable;

public class Admin extends Account implements Serializable {
    private int idAdmin;
    private String name;
    private int age;
    private String phone;

    private Admin(){
    }

    public Admin(String id, String password, int id1, String name, int age, String phone) {
        super(id, password);
        this.idAdmin = idAdmin;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }


    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int id) {
        this.idAdmin = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "idAdmin=" + idAdmin +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
