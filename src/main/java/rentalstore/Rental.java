package rentalstore;

public class Rental {
    private Movie movie;
    private int dayRented;

    public Rental(Movie movie, int dayRented) {
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDayRented() {
        return dayRented;
    }

    double getAmount(double thisAmount, Rental each) {
        switch (each.getMovie().getPriceCode()){
            case Movie.REGULAR:
                Regular regular = new Regular();
                thisAmount += regular.getAmount(thisAmount,each);
                break;
            case Movie.NEW_RELEASE:
                NewRelease newRelease = new NewRelease();
                thisAmount += newRelease.getAmount(thisAmount,each);
                break;
            case Movie.CHILDRENS:
                Childrens childrens = new Childrens();
                thisAmount += childrens.getAmount(thisAmount,each);
                break;
        }
        return thisAmount;
    }
}
