package rentalstore;

import java.util.Enumeration;

public abstract class Statement {

    public String getStatementContent(Customer customer){
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = customer.getRentals().elements();
        String result = headerString(customer.getName());
        while(rentals.hasMoreElements()){
            double thisAmount =0;
            Rental each = (Rental) rentals.nextElement();

            thisAmount = each.getAmount(thisAmount, each);

            //add frequent renter points
            frequentRenterPoints = getFrequentRenterPoints(frequentRenterPoints, each);

            //show figures for this rental
            result += eachRentalString(thisAmount,each);
            totalAmount += thisAmount;
        }

        //add footer lines
        result += footerString(totalAmount, frequentRenterPoints);
        return result;
    }

    private int getFrequentRenterPoints(int frequentRenterPoints, Rental each) {
       return each.getMovieType().getFrequentRenterPoints(frequentRenterPoints,each);
    }

    abstract String footerString(double totalAmount, int frequentRenterPoints);

    abstract String eachRentalString(double thisAmount, Rental each);

    abstract String headerString(String name);
}
