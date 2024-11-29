package lab5;

public class EBookFactory extends BookFactory{

	@Override
	public Book createBook(String title) {
		Ebook book = new Ebook(title);
		return book;
	}

}
