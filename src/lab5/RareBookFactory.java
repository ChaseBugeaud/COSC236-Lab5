package lab5;

public class RareBookFactory extends BookFactory{

	@Override
	public Book createBook(String title) {
		RareBook book = new RareBook(title);
		return book;
	}

}
