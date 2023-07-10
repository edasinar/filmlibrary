public class FilmRate {
    private String username;
    private FilmDetails film;
    private double rate;

    FilmRate() { }
    FilmRate(String username, FilmDetails film, double rate) {
        this.username = username;
        this.film = film;
        this.rate = rate;
    }
    public String getUsername() {
        return username;
    }
    public FilmDetails getFilm() {
        return film;
    }
    public double getRate() {
        return rate;
    }
}
