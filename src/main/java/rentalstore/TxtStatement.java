package rentalstore;

import java.util.Enumeration;

public class TxtStatement extends Statement {


    String footerString(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + String.valueOf(totalAmount) + "\n"+
                "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
    }

    String eachRentalString(double thisAmount, Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
    }

    String headerString(String name) {
        return "Rental Record for " + name + "\n";
    }
}
