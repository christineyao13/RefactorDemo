package rentalstore;

public class NewRelease {
    public double getAmount(double thisAmount, Rental each){
        return thisAmount+=each.getDayRented()*3;
    }
}
