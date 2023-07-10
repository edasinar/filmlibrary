public class FavoriteFilm {
    private String username;
    private FilmDetails film;

    FavoriteFilm() { }
    FavoriteFilm(String username, FilmDetails film) {
        this.username = username;
        this.film = film;
    }

    public String getUsername() {
        return username;
    }
    public FilmDetails getFilm() {
        return film;
    }

    @Override
    public String toString() {
        return "username=" + username + "    /-/    " +
                "film=" + film.getFilmName() + '\n';
    }
}
