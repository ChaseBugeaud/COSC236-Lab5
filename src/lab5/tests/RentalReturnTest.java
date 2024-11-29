package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.Library;
import lab5.Book;
import lab5.BorrowingServices;
import lab5.PaperBook;
import lab5.Member;



class RentalReturnTest {
	
	private Library library;
	
	@BeforeEach
	void setUp() throws Exception {
		 this.library = new Library(); // empty library for each test
	}
	
	BorrowingServices service = BorrowingServices.getInstance();
	Book book1 = new PaperBook("Dune");
	Book book2 = new PaperBook("1984");
	Book book3 = new PaperBook("Moby Dick");
	
	Member member = new Member("Grady Booch", service);
	
	@Test
	void rentalTest() {
		
		assertEquals(library.booksCount(), 0, "Should be no books in library");	
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
		
		
		member.borrowBook(book1);
		assertEquals(member.borrowedBooksCount(), 1, "Member should only have one book atm");
	}
	
	@Test
	void returnTest() {
		
		rentalTest();
		member.returnBook(book1);
		
		assertEquals(member.borrowedBooksCount(), 0, "Member should no books atm");
	}
}
