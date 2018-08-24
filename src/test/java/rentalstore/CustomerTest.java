package rentalstore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest{
    private Customer customer = new Customer("Jerry");
    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_1_day(){
        Movie movie = new Movie("REGULAR",0);
        Rental OneDayRental = new Rental(movie,1);
        customer.addRental(OneDayRental);

        String statement = customer.statement();
        assertEquals("Rental Record for Jerry\n" +
                "\t" + movie.getTitle() + "\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", statement);
    }

}