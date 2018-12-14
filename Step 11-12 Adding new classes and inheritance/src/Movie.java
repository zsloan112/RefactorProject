
public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private Price price;
    private String title;
    private int priceCode;

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
    	double result = 0;
    	switch(getPriceCode()) {
    	case Movie.REGULAR:
    		result += 2;
    		if(daysRented > 2)
    			result += (daysRented - 2) * 1.5;
    		break;
    	case Movie.NEW_RELEASE:
    		result += daysRented * 3;
    		break;
    	case Movie.CHILDREN:
    		if (daysRented > 3) {
    			result += (daysRented - 3) * 1.5;
    		}
    		break;
    	}
    	
    	return result;
    }
    
    public int getFrequentRenterPoints(int daysRented) {
    	{
		  if ( ( getPriceCode() == NEW_RELEASE ) && daysRented > 1 )
		    return 2;
		  else
		    return 1;
		}
    }
}
