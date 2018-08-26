package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg){
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement(){
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String result = headerString();
        while(rentals.hasMoreElements()){
            double thisAmount =0;
            Rental each = (Rental) rentals.nextElement();

            switch (each.getMovie().getPriceCode()){
                case Movie.REGULAR:
                    thisAmount += 2;
                    if(each.getDayRented() > 2){
                        thisAmount+=(each.getDayRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount+=each.getDayRented()*3;
                    break;
                    case Movie.CHILDRENS:
                        thisAmount+=1.5;
                        if(each.getDayRented() > 3){
                            thisAmount += (each.getDayRented() -3)*1.5;
                        }
                        break;
            }
            //add frequent renter points
            frequentRenterPoints ++;
            //add bonus for a two day new release rental
            if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1){
                frequentRenterPoints ++;
            }

            //show figures for this rental
            result += eachRentalString(thisAmount, each);
            totalAmount += thisAmount;
        }

        //add footer lines
        result += footerString(totalAmount, frequentRenterPoints);
        return result;
    }

    private String footerString(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + String.valueOf(totalAmount) + "\n"+
                "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
    }

    private String eachRentalString(double thisAmount, Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
    }

    private String headerString() {
        return "Rental Record for " + getName() + "\n";
    }

    public String HtmlStatement(){
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String result = htmlheaderString();
        while(rentals.hasMoreElements()){
            double thisAmount =0;
            Rental each = (Rental) rentals.nextElement();

            switch (each.getMovie().getPriceCode()){
                case Movie.REGULAR:
                    thisAmount += 2;
                    if(each.getDayRented() > 2){
                        thisAmount+=(each.getDayRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount+=each.getDayRented()*3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount+=1.5;
                    if(each.getDayRented() > 3){
                        thisAmount += (each.getDayRented() -3)*1.5;
                    }
                    break;
            }
            //add frequent renter points
            frequentRenterPoints ++;
            //add bonus for a two day new release rental
            if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1){
                frequentRenterPoints ++;
            }

            //show figures for this rental
            result += htmlEachRentalString(thisAmount, each);
            totalAmount += thisAmount;
        }

        //add footer lines
        result += htmlFooterString(totalAmount, frequentRenterPoints);
        return result;
    }

    private String htmlFooterString(double totalAmount, int frequentRenterPoints) {
        return "<P>You owe<EM>" + String.valueOf(totalAmount) + "</EM><P>\n"+
                "On this rental you earned <EM>" + String.valueOf(frequentRenterPoints) + "</EM> frequent renter points<P>";
    }

    private String htmlEachRentalString(double thisAmount, Rental each) {
        return each.getMovie().getTitle() + ": " + String.valueOf(thisAmount) + "<BR>\n";
    }

    private String htmlheaderString() {
        return "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
    }
}
