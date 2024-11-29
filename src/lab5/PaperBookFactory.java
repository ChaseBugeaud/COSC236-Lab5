package lab5;

public class PaperBookFactory extends BookFactory{

	@Override
	public Book createBook(String title) {
		PaperBook book = new PaperBook(title);
		return book;
	}

}
