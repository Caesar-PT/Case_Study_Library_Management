package service;

import account.Customer;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManager {
    Scanner scanner = new Scanner(System.in);
    final String CUSTOMER_PATH = "customer.dat";
    List<Customer> customerList = (List<Customer>) ReadWriteFile.readFile(CUSTOMER_PATH);

    public void addCustomer(Customer customer){
        customerList.add(customer);
        ReadWriteFile.writeFile(customerList, CUSTOMER_PATH);
    }

    public void delCustomer(String cmt){
        for (Customer a : customerList) {
            if (a.getCmt().equalsIgnoreCase(cmt)){
                customerList.remove(a);
                ReadWriteFile.writeFile(customerList, CUSTOMER_PATH);
                System.out.println("Xóa thành công");
            }
        }
        System.out.println("Không tìm thấy");
    }

    public void editCustomer(String cmt){
        for (Customer c:customerList) {
            if (c.getCmt().equalsIgnoreCase(cmt)){
                setInfoCus(c);
                ReadWriteFile.writeFile(customerList, CUSTOMER_PATH);
                System.out.println("Sửa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy");
    }

    public void setInfoCus(Customer customer){
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhập id");
        customer.setId(scanner2.nextLine());
        System.out.println("Nhập password");
        customer.setPassword(scanner.nextLine());
        System.out.println("Nhập cmt");
        customer.setCmt(scanner2.nextLine());
        System.out.println("Nhập tên");
        customer.setName(scanner.nextLine());
        System.out.println("Nhập số điện thoại");
        customer.setPhone(scanner2.nextLine());
        System.out.println("Nhập địa chỉ");
        customer.setAddress(scanner.nextLine());
    }

    public void showCustomer(){
        for (Customer c:customerList) {
            System.out.println(c);
        }
    }

    public boolean checkLoginCustomer(String id, String password){
        for (Customer c:customerList) {
            if (c.getId().equalsIgnoreCase(id) && c.getPassword().equalsIgnoreCase(password)){
                return true;
            }
        }
        return false;
    }
}
