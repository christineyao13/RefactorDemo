package rentalstore;

public class NewRelease extends MovieType{
    public double getAmount(double thisAmount, Rental each){
        return thisAmount + each.getDayRented() * 3;
    }
    public int getFrequentRenterPoints(int frequentRenterPoints, Rental each) {
        frequentRenterPoints ++;
        //add bonus for a two day new release rental
        if( each.getDayRented() > 1){
            frequentRenterPoints ++;
        }
        return frequentRenterPoints;
    }
}
