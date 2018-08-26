package rentalstore;

import java.util.Vector;

class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<Rental>();

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental arg){
        rentals.addElement(arg);
    }

    String getName() {
        return name;
    }

    String statement(){
        TxtStatement txtStatement = new TxtStatement();
        return txtStatement.getStatementContent(this);
    }

    String HtmlStatement(){
        HtmlStatement htmlStatement = new HtmlStatement();
        return htmlStatement.getStatementContent(this);
    }

    Vector<Rental> getRentals() {
        return rentals;
    }
}
