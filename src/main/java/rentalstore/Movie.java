package rentalstore;

public class Movie {

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    int getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }
}
