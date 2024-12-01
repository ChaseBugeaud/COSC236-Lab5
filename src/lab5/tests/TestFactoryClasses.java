package lab5.tests;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lab5.AudioBook;
import lab5.Ebook;
import lab5.LibrarianController;
import lab5.Library;
import lab5.PaperBook;
import lab5.PaperBookFactory;
import lab5.RareBookFactory;

public class TestFactoryClasses {
	
	@Test
	void factoryTest() {
		PaperBookFactory paperFac = new PaperBookFactory();
		LibrarianController librarian = new LibrarianController();
		
		Library libraryTest = librarian.getLibrary();
		
		librarian.addBook(paperFac, "Dune");
		assertEquals(libraryTest.booksCount(), 1);
		
		
		librarian.addPaperBook("HungerGames");
		librarian.addAudioBook("Tanner");
		librarian.addEbook("Kody");
		
		assertEquals(libraryTest.booksCount(), 4);
		assertTrue(libraryTest.findBookByTitle("Tanner") instanceof AudioBook);
		assertTrue(libraryTest.findBookByTitle("Kody") instanceof Ebook);
		assertTrue(libraryTest.findBookByTitle("Dune") instanceof PaperBook);
		
		
		RareBookFactory rareFac = new RareBookFactory();
		
		librarian.addBook(rareFac, "Dune2");
		assertEquals(libraryTest.booksCount(), 4);
	
	}
}
