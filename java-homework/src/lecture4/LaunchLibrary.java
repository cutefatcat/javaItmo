package lecture4;

import java.util.ArrayList;
import java.util.HashMap;

public class LaunchLibrary {
    public static void main(String[] args) {
        Library library = new Library();
        // Не понятно как проверять иникальность всех полей класса не используя переменую book

        Book book1 = new Book("author1","title1",10);
        Book book2 = new Book("author2","title2",215);
        Book book3 = new Book("author3","title3",326);
        Book book4 = new Book("author4","title4",470);
        library.put(book1,5);
        library.put(book2,3);
        library.put(book3,1);
        library.put(book4,7);
        library.put(book2,1);

        library.get(book3,2);
        library.get(book1,1);
    }
}

class Book{
    String author;
    String title;
    int pagesNum;

    public Book(String author, String title, int pagesNum){
        this.author = author;
        this.title = title;
        this.pagesNum = pagesNum;
    }

    @Override
    public String toString() {
        return title + " " + author;
    }
}

class Library{
    public ArrayList<Book> bookList = new ArrayList<>();
    HashMap<Book, Integer> bookMap = new HashMap<>();

    void put(Book book, int quantity){
        if (bookMap.containsKey(book)){
            Integer currentQuantity = bookMap.get(book);
            bookMap.replace(book, currentQuantity, currentQuantity + quantity);
            System.out.println("В библиотеке появилось " + quantity + " новых экземпляров книги " + book.toString() + ".");
        } else {
            bookMap.put(book, quantity);
        }        
    }

    int get(Book book, int quantity){
        int newQuantity;
        if (bookMap.containsKey(book)){
            Integer currentQuantity = bookMap.get(book);
            newQuantity = currentQuantity - quantity > 0
                    ? currentQuantity - quantity
                    : 0;
            bookMap.replace(book, currentQuantity, newQuantity);
            System.out.println(newQuantity);
        } else {
            newQuantity = 0;
            System.out.println("Запрашиваемой книги нет в наличии.");
        }
        
        return newQuantity;
    }
}