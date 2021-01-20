package menus;

import account.Admin;
import account.Customer;
import module.Book;
import service.*;

import java.util.Map;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        AdminManager adminManager = new AdminManager();

        do {
            MenuLogin.showMenuLogin();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Nhập id");
                    String id = scanner.nextLine();
                    System.out.println("Nhập pass");
                    String password = scanner.nextLine();

                    if (adminManager.checkLoginAdmin(id, password)){
                        adminInterface();
                    } else
                        System.out.println("Nhập sai rồi");
                    break;
                case 2:
                    System.out.println("Nhập id");
                    String idC = scanner.nextLine();
                    System.out.println("Nhập pass");
                    String pass = scanner.nextLine();

                    if (customerManager.checkLoginCustomer(idC, pass)){
                        customerInterface();
                    } else
                        System.out.println("Nhập sai rồi");
                    break;
                case 3:
                    Customer customer = addCustomer();
                    customerManager.addCustomer(customer);
                    break;
                case 4:
                    return;
            }
        } while (true);


    }

    private static void customerInterface(){
        BookManager bookManager = BookManager.getBookManager();
        do {
            MenuCustomer.showMenuCustomer();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    bookManager.showAllBook();
                    break;
                case 2:
                    System.out.println("Nhập id sách cần mua");
                    int idBook = Integer.parseInt(scanner.nextLine());
                    bookManager.buyBook(idBook);
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    private static void adminInterface() {
        BookManager bookManager = BookManager.getBookManager();
        CustomerManager customerManager = new CustomerManager();
        AdminManager adminManager = new AdminManager();
        do {
            Menu.showMenu();
            Scanner sc=new Scanner(System.in);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    bookManager.showAllBook();
                    break;
                case 2:
                    Book book =  addNewBook();
                    bookManager.addBook(book);
                    break;
                case 3:
                    System.out.println("Nhập id sách cần xóa");
                    int id = scanner.nextInt();
                    bookManager.delBook(id);
                    break;
                case 4:
                    System.out.println("Nhập tên sách cần tìm");
                    String name = scanner.nextLine();
                    bookManager.foundBook(name);
                    break;
                case 5:
                    System.out.println("Nhập id sách cần sửa");
                    int idBook = scanner.nextInt();
                    bookManager.editBook(idBook);
                    break;
                case 6:
                    bookManager.sortBook();
                    break;
                case 7:
                    double sum = bookManager.sumTotalPriceBook();
                    System.out.println("Tổng tiền sách là: " + sum);
                    break;
                case 8:
                    customerManager.showCustomer();
                    break;
                case 9:
                    Admin admin = addAdmin();
                    adminManager.addAdmin(admin);
                    break;
                case 10:
                    adminManager.showAdmin();
                    break;
                case 11:
                    return;

            }
        } while (true);
    }

    public static Book addNewBook(){
        System.out.println("Nhập id");
        int id =Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sách");
        String name = scanner.nextLine();
        System.out.println("Nhập thể loại sách");
        String category = scanner.nextLine();
        System.out.println("Nhập tên tác giả");
        String author = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        double price =Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lượng sách");
        double amount =Double.parseDouble(scanner.nextLine());

        Book book = new Book(id, name, category, author, price, amount);
        return book;
    }

    public static Admin addAdmin(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập id");
        String id = scanner.nextLine();
        System.out.println("Nhập password");
        String password = scanner1.nextLine();
        System.out.println("Nhập idAdmin");
        int idAdmin = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên");
        String name = scanner1.nextLine();
        System.out.println("Nhập tuổi");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số điện thoại");
        String phone = scanner1.nextLine();

        Admin admin = new Admin(id, password, idAdmin, name, age, phone);
        return admin;
    }

    public static Customer addCustomer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id");
        String id = scanner.nextLine();
        System.out.println("Nhập password");
        String password = sc.nextLine();
        System.out.println("Nhập chứng minh thư");
        String cmt = scanner.nextLine();
        System.out.println("Nhập tên");
        String name = sc.nextLine();
        System.out.println("Nhập số điện thoại");
        String phone = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = sc.nextLine();

        Customer customer =new Customer(id, password, cmt, name, phone, address);
        return customer;
    }

}
