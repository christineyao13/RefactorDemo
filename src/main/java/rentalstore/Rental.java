package rentalstore;

public class Rental {
    private Movie movie;
    private int dayRented;
    private MovieType movieType;

    public Rental(Movie movie, int dayRented,MovieType movieType) {
        this.movie = movie;
        this.dayRented = dayRented;
        this.movieType = movieType;
    }

    Movie getMovie() {
        return movie;
    }

    int getDayRented() {
        return dayRented;
    }

    double getAmount(double thisAmount, Rental each) {
        thisAmount += movieType.getAmount(thisAmount,each);
        return thisAmount;
    }
    MovieType getMovieType() {
        return movieType;
    }
}
