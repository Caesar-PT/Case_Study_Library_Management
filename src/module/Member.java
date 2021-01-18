package module;

import java.time.LocalDate;

public class Member extends Person {
    private LocalDate joinDate;

    public Member() {
    }

    public Member withName(String name) {
        this.setName(name);
        return this;
    }

    public Member withIdCard(String idCard) {
        this.setIdCard(idCard);
        return this;
    }

    public Member withAddress(String address) {
        this.setAddress(address);
        return this;
    }

    public Member withPhone(String phone) {
        this.setPhone(phone);
        return this;
    }

    public Member withJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
        return this;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public Member build() {
        return this;
    }

    @Override
    public String toString() {
        return "Member{" +
                "joinDate=" + joinDate +
                '}';
    }
}
