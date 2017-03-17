package pkgEmpty;
import pkgLibrary.Book;
import java.sql.Date;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class test {


	@Test
	public void Booktest() {
		Book b = new Book("book1","Felix","New Place","Novel",10.0,new Date(1000L),"A good book",10.0);
		
		assertEquals(b.getId(), "book1");
		assertEquals(b.getAuthor(),"Felix");
		assertEquals(b.getTitle(),"New Place");
		assertEquals(b.getGenre(),"Novel");
		assertEquals(b.getPublish_date(),new Date(1000L));
		assertEquals(b.getDescription(),"A good book");

		
		
	}
	
	@Test
	public void CatalogTest() {
		
	}
}