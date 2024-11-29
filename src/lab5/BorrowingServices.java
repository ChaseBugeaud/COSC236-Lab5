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
		if (book != null && book.getIsAvailable() && arrBooks.size() < BORROWING_LIMIT) {
			arrBooks.add(book);
			book.setIsAvailable(false);
			BorrowingBookResult result = new BorrowingBookResult(true, book.toString() + " successfully returned");
			return result;
		} else {
			BorrowingBookResult result = new BorrowingBookResult(false, " return error");
			return result;
		}
	}

	@Override
	public BorrowingBookResult returnBook(Book book, ArrayList<Book> arrBooks) {

		if (book != null && !book.getIsAvailable()) {
			arrBooks.remove(book);
			book.setIsAvailable(true);
			BorrowingBookResult result = new BorrowingBookResult(true, book.toString() + " successfully returned");
			return result;
		} else {
			BorrowingBookResult result = new BorrowingBookResult(false, " return error");
			return result;
		}
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
