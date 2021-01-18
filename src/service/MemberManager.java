package service;

import module.Member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberManager {
    Scanner scanner = new Scanner(System.in);
    List<Member> memberList = new ArrayList<>();

    public void addMember(Member member) {
        memberList.add(member);
    }

    public void editMember(String idCard) {
        for (Member m : memberList) {
            if (m.getIdCard().equals(idCard)) {
                setInfoMember(m);
                System.out.println("Sửa thành công");
                return;
            }
        }
        System.out.println("Không tồn tại member");
    }

    public void delMember(String idCard) {
        for (Member m : memberList) {
            if (m.getIdCard().equals(idCard)) {
                memberList.remove(m);
                System.out.println("Xóa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy member");
    }

    public LocalDate setDate() {
        System.out.println("Nhập ngày");
        int day = scanner.nextInt();
        System.out.println("Nhập tháng");
        int month = scanner.nextInt();
        System.out.println("Nhập năm");
        int year = scanner.nextInt();

        return LocalDate.of(year, month, day);
    }

    public void setInfoMember(Member member) {
        System.out.println("Nhập họ tên");
        member.setName(scanner.nextLine());
        System.out.println("Nhập id card");
        member.setIdCard(scanner.next());
        System.out.println("Nhập địa chỉ");
        member.setAddress(scanner.nextLine());
        System.out.println("Nhập số điện thoại");
        member.setPhone(scanner.nextLine());
        System.out.println("Nhập ngày gia nhập");
        member.setJoinDate(setDate());
    }
}
