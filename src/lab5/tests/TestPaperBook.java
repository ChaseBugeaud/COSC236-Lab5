package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import lab5.Book;
import lab5.PaperBook;

public class TestPaperBook {

	@Test
	void testObjectName() {
		Book book = new PaperBook("harry Potter");
		
		
		assertEquals(book.getClass().getName(), "lab5.PaperBook");
		assertTrue(book instanceof lab5.Book);
		
	}
	
	
}
