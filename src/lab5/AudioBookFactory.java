package lab5;

public class AudioBookFactory extends BookFactory{

	@Override
	public Book createBook(String title) {
		AudioBook book = new AudioBook(title);
		return book;
	}

}
