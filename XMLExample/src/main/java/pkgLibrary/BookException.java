package pkgLibrary;

public class BookException extends Exception {

	private String id;

	public BookException(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
