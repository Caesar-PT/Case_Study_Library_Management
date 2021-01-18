package module;

public abstract class Person {
    private String name;
    private String idCard;
    private String address;
    private String phone;

    public Person() {
    }

    public Person withName(String name) {
        this.name = name;
        return this;
    }

    public Person withIdCard(String idCard) {
        this.idCard = idCard;
        return this;
    }

    public Person withAddress(String address) {
        this.address = address;
        return this;
    }

    public Person withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Person build() {
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
