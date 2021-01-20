package service;

import account.Admin;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminManager {
    Scanner scanner = new Scanner(System.in);
    final String ADMIN_PATH = "admin.dat";
    List<Admin> adminList = (List<Admin>) ReadWriteFile.readFile(ADMIN_PATH);

    public void addAdmin(Admin admin){
        adminList.add(admin);
        ReadWriteFile.writeFile(adminList, ADMIN_PATH);
    }

    public void delAdmin(int idAdmin){
        for (Admin a: adminList) {
            if (a.getIdAdmin() == idAdmin){
                adminList.remove(a);
                ReadWriteFile.writeFile(adminList, ADMIN_PATH);
                System.out.println("Xóa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy");
    }

    public void editAdmin(int idAdmin){
        for (Admin a:adminList) {
            if (a.getIdAdmin() == idAdmin){
                setInfoAdmin(a);
                ReadWriteFile.writeFile(adminList, ADMIN_PATH);
                System.out.println("Sửa thành công");
            }
        }
    }

    public void setInfoAdmin(Admin admin){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập id");
        admin.setId(scanner.nextLine());
        System.out.println("Nhập password");
        admin.setPassword(scanner1.nextLine());
        System.out.println("Nhập idAdmin");
        admin.setIdAdmin(scanner.nextInt());
        System.out.println("Nhập tên");
        admin.setName(scanner1.nextLine());
        System.out.println("Nhập tuổi");
        admin.setAge(scanner.nextInt());
        System.out.println("Nhập sdt");
        admin.setPhone(scanner.nextLine());
    }

    public boolean checkLoginAdmin(String id, String password){
        for (Admin a:adminList) {
            if (a.getId().equalsIgnoreCase(id) && a.getPassword().equalsIgnoreCase(password)){
                return true;
            }
        }
        return false;
    }

    public void showAdmin(){
        for (Admin a : adminList) {
            System.out.println(a);
        }
    }
}
