package rentalstore;

public abstract class MovieType {
    public abstract double getAmount(double thisAmount, Rental each);
    public int getFrequentRenterPoints(int frequentRenterPoints, Rental each) {
        frequentRenterPoints ++;
        //add bonus for a two day new release rental
        if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1){
            frequentRenterPoints ++;
        }
        return frequentRenterPoints;
    }
}
