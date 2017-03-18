package pkgEmpty;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pkgLibrary.Book;
import pkgLibrary.BookException;
import pkgLibrary.Catalog;

public class test {

	@Test
	public void Booktest() {
		Book b = new Book("book1", "Felix", "New Place", "Novel", 10.0, new Date(1000L), "A good book", 10.0);

		assertEquals(b.getId(), "book1");
		assertEquals(b.getAuthor(), "Felix");
		assertEquals(b.getTitle(), "New Place");
		assertEquals(b.getGenre(), "Novel");
		equals(b.getPrice());
		assertEquals(b.getPublish_date(), new Date(1000L));
		assertEquals(b.getDescription(), "A good book");
		equals(b.getCost());

	}

	@BeforeClass
	public static void setUpBeforeClass() {
	}

	@AfterClass
	public static void tearDownAfterClass() {
	}

	@Before
	public void testSetup() {

	}

	@After
	public void testtearDown() {
	}

	@Test(expected = BookException.class)
	public void GetBooktest() throws BookException {
		Catalog cat = ReadXMLFile();
		cat.GetBook("book1");
	}

	@Test
	public void Addbooktest() throws BookException {
		Catalog cat = ReadXMLFile();
		Book b = new Book("book1", "Felix", "New Place", "Novel", 10.0, new Date(1000L), "A good book", 10.0);
		cat.AddBook(cat, b, "book1");
	}

	private static Catalog ReadXMLFile() {

		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "/src/main/resources/XMLFiles/Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return cat;

	}
}
