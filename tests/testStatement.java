import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class testStatement {
	
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Movie> movies = new ArrayList<Movie>();
	ArrayList<Rental> rentals = new ArrayList<Rental>();

	@Before
	public void setUp() throws Exception {
		customers.add(0, new Customer("John"));
		customers.add(1, new Customer("Jim"));
		customers.add(2, new Customer("Mary"));
		customers.add(3, new Customer("Tom"));
		customers.add(4, new Customer("Dick"));
		customers.add(5, new Customer("Harry"));
		customers.add(5, new Customer("Fred"));
		
		movies.add(0, new Movie("Titanic", Movie.REGULAR));
		movies.add(1, new Movie("Avatar", Movie.NEW_RELEASE));
		movies.add(2, new Movie("The Incredibles", Movie.CHILDRENS));
		movies.add(3, new Movie("Terminator", Movie.REGULAR));
		movies.add(4, new Movie("Guardians", Movie.NEW_RELEASE));
		movies.add(5, new Movie("Cars", Movie.CHILDRENS));
		
		rentals.add(0,new Rental(movies.get(0),1));
		rentals.add(1,new Rental(movies.get(1),1));
		rentals.add(2,new Rental(movies.get(2),1));
		rentals.add(3,new Rental(movies.get(3),3));
		rentals.add(4,new Rental(movies.get(4),2));
		rentals.add(5,new Rental(movies.get(5),4));
		
		customers.get(0).addRental(rentals.get(0));
		customers.get(1).addRental(rentals.get(1));
		customers.get(2).addRental(rentals.get(2));
		customers.get(3).addRental(rentals.get(3));
		customers.get(4).addRental(rentals.get(4));
		customers.get(5).addRental(rentals.get(5));
		customers.get(6).addRental(rentals.get(3));
		customers.get(6).addRental(rentals.get(4));
		customers.get(6).addRental(rentals.get(5));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		//System.out.printf("%s\n\n", customers.get(0).statement());
		assertEquals("Rental Record for John\n" +
				 "\tTitanic	2.0\n" +
				 "amount owed is 2.0\n" +
				 "You earned 1 frequent renter points",
				 customers.get(0).statement() );

		//System.out.printf("%s\n\n", customers.get(1).statement());
		assertEquals("Rental Record for Jim\n" +
				 "\tAvatar	3.0\n" +
				 "amount owed is 3.0\n" +
				 "You earned 1 frequent renter points",
				 customers.get(1).statement() );

		//System.out.printf("%s\n\n", customers.get(2).statement());
		assertEquals("Rental Record for Mary\n" +
				 "\tThe Incredibles	1.5\n" +
				 "amount owed is 1.5\n" +
				 "You earned 1 frequent renter points",
				 customers.get(2).statement() );

		//System.out.printf("%s\n\n", customers.get(3).statement());
		assertEquals("Rental Record for Tom\n" +
				 "\tTerminator	3.5\n" +
				 "amount owed is 3.5\n" +
				 "You earned 1 frequent renter points",
				 customers.get(3).statement() );

		//System.out.printf("%s\n\n", customers.get(4).statement());
		assertEquals("Rental Record for Dick\n" +
				 "\tGuardians	6.0\n" +
				 "amount owed is 6.0\n" +
				 "You earned 2 frequent renter points",
				 customers.get(4).statement() );

		//System.out.printf("%s\n\n", customers.get(5).statement());
		assertEquals("Rental Record for Fred\n" +
				 "\tCars	3.0\n" +
				 "amount owed is 3.0\n" +
				 "You earned 1 frequent renter points",
				 customers.get(5).statement() );

		//System.out.printf("%s\n\n", customers.get(6).statement());
		assertEquals("Rental Record for Harry\n" +
				 "\tTerminator	3.5\n" +
				 "\tGuardians	6.0\n" +
				 "\tCars	3.0\n" +
				 "amount owed is 12.5\n" +
				 "You earned 4 frequent renter points",
				 customers.get(6).statement() );
		

	}

}
