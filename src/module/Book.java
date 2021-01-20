package module;

import java.io.Serializable;

public class Book implements Serializable{
    private int idBook;
    private String nameBook;
    private String category;
    private String author;
    private double price;
    private double amount;

    public Book() {
    }

    public Book(int idBook, String nameBook, String category, String author, double price, double amount) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.category = category;
        this.author = author;
        this.price = price;
        this.amount = amount;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getSumPriceBook(){
        return price * amount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", nameBook='" + nameBook + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
