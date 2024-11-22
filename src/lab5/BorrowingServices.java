package lab5;

public class BorrowingServices implements BorrowingServiceAPI {

	@Override
	public boolean borrowBook(Member member, Book book) {
		if (book != null && member != null) {
		      member.borrowBook(book); // member borrows a book, not library
		}else{
		    return  false;
		}
		return true;
	}

	@Override
	public boolean returnBook(Member member, Book book) {
		
		return false;
	}
	

}
