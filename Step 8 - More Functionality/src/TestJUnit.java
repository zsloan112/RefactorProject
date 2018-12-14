import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class TestJUnit {
	Movie movie = new Movie("Avengers", Movie.REGULAR);
	Rental rental = new Rental(movie, 3);
	Customer customer = new Customer("Zack");
	
	
	public TestJUnit() {
		customer.addRental(rental);
	}

   
	
   //Movie
	
   //Test getPriceCode
   @Test
   public void testMovieGetPriceCode() {
      int priceCode = movie.REGULAR;
      assertEquals(priceCode, movie.getPriceCode());
   }
   
   //SetPriceCode
   @Test
   public void testMoviePriceCode() {
	   movie.setPriceCode(movie.CHILDREN);
	   assertEquals(movie.CHILDREN, movie.getPriceCode());
   }
   
   //GetTitle
   @Test
   public void testGetTitle() {
	   assertEquals("Avengers", movie.getTitle());
   }
   
   
   //Rental
   
   //GetDaysRented
   @Test
   public void testRentalGetDaysRented() {
	   assertEquals(3, rental.getDaysRented());
   }
   
   @Test
   public void testRentalGetMovie() {
	   assertEquals("Avengers", rental.getMovie().getTitle());
	   assertEquals(Movie.REGULAR, rental.getMovie().getPriceCode());
   }
   
   
   //Customer
   
   //GetName
   @Test
   public void testCustomerGetName() {
	   assertEquals("Zack", customer.getName());
   }
   
   //GetStatement
   @Test
   public void testCustomerGetStatement() {
	   System.out.println(customer.statement());
	   assertNotNull(customer.statement());
	   System.out.println();
	   System.out.println(customer.htmlStatement());
	   assertNotNull(customer.htmlStatement());
   }

}