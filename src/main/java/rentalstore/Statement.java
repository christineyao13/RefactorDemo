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
            result += eachRentalString(thisAmount,each);
            totalAmount += thisAmount;
        }

        //add footer lines
        result += footerString(totalAmount, frequentRenterPoints);
        return result;

    }

    abstract String footerString(double totalAmount, int frequentRenterPoints);

    abstract String eachRentalString(double thisAmount, Rental each);

    abstract String headerString(String name);
}
