package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.AudioBook;
import lab5.Book;
import lab5.BorrowingServices;
import lab5.Member;
import lab5.PaperBook;

class TestBorrowBooks {

	Member member1;
	Member member2;
	BorrowingServices service = BorrowingServices.getInstance();
	Book book1 = new PaperBook("Dune");
	Book book2 = new PaperBook("1984");
	Book book3 = new PaperBook("Another One");
	Book book4 = new PaperBook("Vlad the impalor");
	Book book5 = new AudioBook("sweet lulaby's with liam");
			
	
	@BeforeEach
	void setUp() throws Exception {
		
		member1 = new Member("Alice", service); // flush borrowedBook array 
		member2 = new Member("Bob", service);   // flush borrowedBook array 
		
		
		
		book1.setIsAvailable(true);
		book2.setIsAvailable(true);
		
		
	}
	@Test
	void borrowBookBook() {
		
		// borrow first book
		assertEquals(member1.borrowedBooksCount(), 0, "Borrowed book should be zero");
		assertTrue(book1.getIsAvailable(), "Book 1 must be available");
		member1.borrowBook(book1);
		assertFalse(book1.getIsAvailable(),"Book 1 must be not available");
		assertEquals(member1.borrowedBooksCount(),1, "Count of borrowed books must be 1");
		
		// borrow second book
		assertTrue(book2.getIsAvailable(),"Book must be available");
		member1.borrowBook(book2);
		assertFalse(book1.getIsAvailable(), "Book should not be available");
		assertEquals(member1.borrowedBooksCount(), 2, "The book coubnt shoud be 2");
		
		
		// borrow thrid book 
		
		
		
	}
	
	@Test
	void returnBookBook() {
		
		// borrow two books
		assertTrue(book1.getIsAvailable(), "Book 1 should be available");
		assertTrue(book2.getIsAvailable(), "Book 2 should be available");
		assertEquals(member1.borrowedBooksCount(), 0,"Member1 should not have any books" );
		member1.borrowBook(book1);
		member1.borrowBook(book2);
		assertEquals(member1.borrowedBooksCount(),2, "The count of books must be 2");
		assertFalse(book1.getIsAvailable(), "Book 1 should not be available");
		assertFalse(book2.getIsAvailable(), "Book 2 should not be available");
		
		// return first book
		member1.returnBook(book1);
		assertTrue(book1.getIsAvailable(), "Book should be available after return");
		assertEquals(member1.borrowedBooksCount(), 1, "Count of books must be 1");
		// return second book
		member1.returnBook(book2);
		assertTrue(book2.getIsAvailable(), "Book should be available after return");
		assertEquals(member1.borrowedBooksCount(), 0, "Member 1 should have no books");
		
	}
	@Test
	void testBook() {
		member1.borrowBook(book1);
		member1.borrowBook(book2);
		member1.borrowBook(book3);
		member1.borrowBook(book4);
		assertEquals(member1.borrowedBooksCount(), 3, "You can only borrow 3 books!");
		member1.returnBook(book5);
		member2.borrowBook(book1);
		

	}

}
