package rentalstore;

public abstract class MovieType {
    public abstract double getAmount(double thisAmount, Rental each);
    public int getFrequentRenterPoints(int frequentRenterPoints, Rental each) {
        frequentRenterPoints ++;
        return frequentRenterPoints;
    }
}
