package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

  private String name;
  private ArrayList<Book> borrowedBooks; // Book class dependency
  private BorrowingServices borrowingServices;
  
  public Member(String name, BorrowingServices service) {
    this.name = name;
    this.borrowedBooks = new ArrayList<>();
    this.borrowingServices = service;
    
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
    BorrowingBookResult result = borrowingServices.borrowBook(book, borrowedBooks);
  }

  public void returnBook(Book book) {
    BorrowingBookResult result = borrowingServices.returnBook(book, borrowedBooks);
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
