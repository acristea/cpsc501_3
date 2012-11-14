
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class PersonTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testPerson() {
		Person aPerson = new Person();
		assertNotNull(aPerson);
	}
	@Test
	public void testAge() {
		Person aPerson = new Person();
		assertEquals(aPerson.age, 7);;
	}
	
	@Test
	public void testFirstLetter() {
		Person aPerson = new Person();
		assertEquals(aPerson.firstLetter, 'c');
	}
	

}
