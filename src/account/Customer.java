package account;

import java.io.Serializable;

public class Customer extends Account implements Serializable {
    private String cmt;
    private String name;
    private String phone;
    private String address;

    public Customer() {
    }

    public Customer(String cmt, String name, String phone, String address) {
        this.cmt = cmt;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Customer(String id, String password, String cmt, String name, String phone, String address) {
        super(id, password);
        this.cmt = cmt;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cmt='" + cmt + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
