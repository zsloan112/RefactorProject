
public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private Price price;
    private String title;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
        
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
    	return price.getPriceCode();
    }
    
    public void setPriceCode(int priceCode) {
        if(priceCode == REGULAR) {
        	price = new RegularPrice();
        }else if(priceCode == CHILDREN) {
        	price = new ChildrenPrice();
        }else {
        	price = new NewRelease();
        }
    }
    
    public double getCharge(int daysRented) {
    	return price.getCharge(daysRented);
    }
    
    public int getFrequentRenterPoints(int daysRented) {
    	return price.getFrequentRenterPoints(daysRented);
    }
}
