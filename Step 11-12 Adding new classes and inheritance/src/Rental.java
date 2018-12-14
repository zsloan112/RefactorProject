
import java.util.ArrayList;
import java.util.List;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }
    
    public double getAmount() {
    	return movie.getCharge(daysRented);
    }
    
    public int getRentalPoints() {
    	return movie.getFrequentRenterPoints(daysRented);
    	
    }


}
