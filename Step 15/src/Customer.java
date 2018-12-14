
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {

        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {
        	
            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getAmount()) + "\n";

        }

        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getFrequentRenterPoints() + " frequent renter points";

        return result;
    }
    
    public double amountFor(Rental tempRental) {
    	return tempRental.getAmount();
    }
    
    public double getTotalCharge() {
    	double result = 0;
    	for (Rental rental : rentals) {
    		result += rental.getAmount();
    	}
    	return result;
    }
    
    public int getFrequentRenterPoints() {
    	int result = 0;
    	for(Rental rental : rentals) {
    		result += rental.getRentalPoints();
    	}
    	return result;
    }
    
    public String  htmlStatement() {
    	String result = "<H1>Rentals for <EM>" + getName() +  "</EM></H1><P>\n";
    	for (Rental rental : rentals) {
    		result += rental.getMovie().getTitle() + ": " + rental.getAmount() + "<BR>\n";
    	}
    	
    	result += "<P>You owe <EM>" + getTotalCharge() + "</EM><P>\n";
    	result += "On this rental you earned <EM>" + getFrequentRenterPoints() + "</EM> frequent renter points<P>";
    	
    	return result;
    }
}
