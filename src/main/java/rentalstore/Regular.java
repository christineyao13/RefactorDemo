package rentalstore;

public class Regular extends MovieType{
    public double getAmount(double thisAmount, Rental each){
        thisAmount += 2;
        if(each.getDayRented() > 2){
            thisAmount+=(each.getDayRented() - 2) * 1.5;
        }
        return thisAmount;
    }
}
