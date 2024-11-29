package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class BorrowingServices implements BorrowingServiceAPI {
  private static BorrowingServices instance;
  private final int BORROWING_LIMIT = 3;

  public BorrowingServices() {

  }

  public static synchronized BorrowingServices getInstance() {
    if (instance == null) {
      instance = new BorrowingServices();
    }
    return instance;
  }

  @Override
  public BorrowingBookResult borrowBook(Book book, ArrayList<Book> arrBooks) {
    // create BBR object with scope for function - this should always be changed
    BorrowingBookResult result = new BorrowingBookResult(false, "error: message not assigned");
    if (book == null) {
      result.setFailure();
      result.setBorrowingMessage("error: cannot borrow book that does not exist");
    } else if (!book.getIsAvailable()) {
      result.setFailure();
      result.setBorrowingMessage("error: book is unavailable to borrow");
    } else if (arrBooks.size() >= BORROWING_LIMIT) {
      result.setFailure();
      result.setBorrowingMessage("error: member borrowing book exceeded");
    }

    if (book != null && book.getIsAvailable() && arrBooks.size() < BORROWING_LIMIT) {
      arrBooks.add(book);
      book.setIsAvailable(false);
      result.setSuccessful();
      result.setBorrowingMessage("success borrowing: " + book.toString());
    }
    return result;
  }

  @Override
  public BorrowingBookResult returnBook(Book book, ArrayList<Book> arrBooks) {
    // create BBR object with scope for function - this should always be changed
    BorrowingBookResult result = new BorrowingBookResult(false, "error: message not assigned");
    if (book == null) {
      result.setBorrowingMessage("error: cannot return book that does not exist");
      result.setFailure();
    } else if (book.getIsAvailable()) {
      result.setBorrowingMessage("error: cannot return book that is not borrowed");
      result.setFailure();
    }

    if (book != null && !book.getIsAvailable()) {
      arrBooks.remove(book);
      book.setIsAvailable(true);
      result.setSuccessful();
      result.setBorrowingMessage("success returning: " + book.toString());
    }
    return result;
  }

  @Override
  public void returnAllBorrowedBooks(ArrayList<Book> borrowedBooks) {
    Book book = borrowedBooks.get(0);
    Iterator<Book> bookIterator = borrowedBooks.iterator();
    while (bookIterator.hasNext()) {
      book = bookIterator.next();
      book.setIsAvailable(true);
    }
    System.out.println("All books cleared");
    borrowedBooks.clear();
  }

}
