package lab5;

import java.util.ArrayList;

public interface BorrowingServiceAPI {
  public BorrowingBookResult borrowBook(Book book, ArrayList<Book> arrBooks);

  public void returnAllBorrowedBooks(ArrayList<Book> arrBooks);

  public BorrowingBookResult returnBook(Book book, ArrayList<Book> arrBooks);
}
