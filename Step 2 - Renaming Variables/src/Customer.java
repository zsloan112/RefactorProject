
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
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {
            double thisAmount = getAmount(rental);
            

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";

            totalAmount += thisAmount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }
    
    public double getAmount(Rental tempRental) {
    	double amount = 0;
    	switch (tempRental.getMovie().getPriceCode()) {
        case Movie.REGULAR:
            amount += 2;
            if (tempRental.getDaysRented() > 2)
                amount += (tempRental.getDaysRented() - 2) * 1.5;
            break;
        case Movie.NEW_RELEASE:
            amount += tempRental.getDaysRented() * 3;
            break;
        case Movie.CHILDREN:
            amount += 1.5;
            if (tempRental.getDaysRented() > 3)
                amount += (tempRental.getDaysRented() - 3) * 1.5;
            break;
    	}
    	return amount;
    }
}
