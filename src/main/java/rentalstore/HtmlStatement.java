package rentalstore;

import java.util.Enumeration;

public class HtmlStatement extends Statement {


    String footerString(double totalAmount, int frequentRenterPoints) {
        return "<P>You owe<EM>" + String.valueOf(totalAmount) + "</EM><P>\n"+
                "On this rental you earned <EM>" + String.valueOf(frequentRenterPoints) + "</EM> frequent renter points<P>";
    }

    String eachRentalString(double thisAmount, Rental each) {
        return each.getMovie().getTitle() + ": " + String.valueOf(thisAmount) + "<BR>\n";
    }

    String headerString(String name) {
        return "<H1>Rentals for <EM>" + name + "</EM></H1><P>\n";
    }
}
