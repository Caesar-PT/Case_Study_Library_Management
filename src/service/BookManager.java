package service;

import module.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    Scanner scanner = new Scanner(System.in);
    List<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void editBook(int idBook) {
        for (Book b : bookList) {
            if (b.getIdBook() == idBook) {
                setInfoBook(b);
                System.out.println("Sửa thành công");
                return;
            }
        }
        System.out.println("ID không đúng");
    }

    public void delBook(int id) {
        for (Book b : bookList) {
            if (b.getIdBook() == id) {
                bookList.remove(b);
            }
        }
    }

    public void setInfoBook(Book book) {
        System.out.println("Nhập id sách");
        book.setIdBook(scanner.nextInt());
        System.out.println("Nhập tên sách");
        book.setNameBook(scanner.nextLine());
        System.out.println("Nhập thể loại sách");
        book.setCategory(scanner.nextLine());
        System.out.println("Nhập tên tác giả");
        book.setAuthor(scanner.nextLine());
        System.out.println("Nhập giá sách");
        book.setPrice(scanner.nextDouble());
    }

    public void showAllBook() {
        System.out.println(bookList);
    }
}
