package rentalstore;

public class NewRelease extends MovieType{
    public double getAmount(double thisAmount, Rental each){
        return thisAmount+=each.getDayRented()*3;
    }
}
