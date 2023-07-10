public class FilmComment {
    private String username;
    private FilmDetails film;
    private String comment;

    FilmComment() { }
    FilmComment(String username, FilmDetails film, String comment) {
        this.username = username;
        this.film = film;
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }
    public FilmDetails getFilm() {
        return film;
    }
    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "username=" + username + "    /-/    " +
                "film= " + film.getFilmName() +
                "    /-/    comment=" + comment + '\n';
    }
}
