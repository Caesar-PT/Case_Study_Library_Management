package service;

import module.Book;
import storage.ReadWriteFile;

import java.util.*;

public class BookManager {
    Scanner scanner = new Scanner(System.in);
    final String FILE_PATH = "listbook.dat";
    List<Book> bookList = (List<Book>) ReadWriteFile.readFile(FILE_PATH);
    private static BookManager instance;

    private BookManager() {
    }

    public static synchronized BookManager getBookManager() {
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }


    public void addBook(Book book) {
        bookList.add(book);
        ReadWriteFile.writeFile(bookList, FILE_PATH);
    }

    public void editBook(int idBook) {
        for (Book b : bookList) {
            if (b.getIdBook() == idBook) {
                setInfoBook(b);
                ReadWriteFile.writeFile(bookList, FILE_PATH);
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
                ReadWriteFile.writeFile(bookList, FILE_PATH);
                System.out.println("Xóa thành công");
                showAllBook();
                return;
            }
        }
        System.out.println("không tìm thấy");
    }

    public void foundBook(String name) {
        for (Book b : bookList) {
            if (b.getNameBook().equalsIgnoreCase(name)) {
                System.out.println(b);
                return;
            }
        }
        System.out.println("Không tìm thấy sách");
    }

    public void sortBook() {
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() < o2.getPrice()) {
                    return -1;
                } else
                    return 0;
            }
        });

        showAllBook();
    }

    public double sumTotalPriceBook() {
        double sum = 0;
        for (Book b : bookList) {
            sum += b.getPrice() * b.getAmount();
        }
        return sum;
    }

    public void setInfoBook(Book book) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập id sách");
        book.setIdBook(scanner.nextInt());
        System.out.println("Nhập tên sách");
        book.setNameBook(scanner1.nextLine());
        System.out.println("Nhập thể loại sách");
        book.setCategory(scanner.nextLine());
        System.out.println("Nhập tên tác giả");
        book.setAuthor(scanner1.nextLine());
        System.out.println("Nhập giá sách");
        book.setPrice(scanner.nextDouble());
    }

    public void showAllBook() {
        for (Book b : bookList) {
            System.out.println(b);
        }
    }

    public void buyBook(int idBook) {
        for (Book b : bookList) {
            if (b.getIdBook() == idBook) {
                double result = 0;
                if (b.getAmount() > 0) {
                    result = b.getAmount() - 1;
                    b.setAmount(result);
                    ReadWriteFile.writeFile(bookList, FILE_PATH);
                    System.out.println("Mua thành công");
                    return;
                }
                else {
                    System.out.println("Hết sách rồi");
                    return;
                }

            }
        }
        System.out.println("Không tìm thấy");
    }
}
