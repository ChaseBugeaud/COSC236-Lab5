package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

  private String name;
  private ArrayList<Book> borrowedBooks; // Book class dependency

  public Member(String name) {
    this.name = name;
    this.borrowedBooks = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public ArrayList<Book> getBorrowedBooks() {
    return borrowedBooks;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
    return "Member: " + name;
  }

  public void borrowBook(Book book) {
    BorrowingServices borrowService = new BorrowingServices();
    borrowService.borrowBook(book, borrowedBooks);
  }

  public void returnBook(Book book) {
    BorrowingServices borrowService = new BorrowingServices();
    borrowService.returnBook(book, borrowedBooks);
  }

  public void listBorrowedBooks() {
    for (Book book : borrowedBooks)
      System.out.println(book);
  }

  public int borrowedBooksCount() {
    return borrowedBooks.size();
  }

  public void returnAllBooks() {
    BorrowingServices borrowService = new BorrowingServices();
    borrowService.returnAllBorrowedBooks(borrowedBooks);
  }
}
