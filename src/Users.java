import java.util.ArrayList;

public class Users {
    private String fullName;
    private String username;
    private String email;
    private String password;
    private ArrayList<FavoriteFilm> favoriteFilmList;
    private ArrayList<FilmComment> filmCommentList;
    private ArrayList<FilmRate> filmRateList;

    Users(String fullName, String username, String email, String password) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        favoriteFilmList = new ArrayList<>();
        filmCommentList = new ArrayList<>();
        filmRateList = new ArrayList<>();
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFullName() {
        return fullName;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public ArrayList<FavoriteFilm> getFavoriteFilmList() {
        return favoriteFilmList;
    }
    public ArrayList<FilmComment> getFilmCommentList() {
        return filmCommentList;
    }
    public ArrayList<FilmRate> getFilmRateList() {
        return filmRateList;
    }
    public void addFavoriteList(FilmDetails film) {
        favoriteFilmList.add(new FavoriteFilm(getUsername(), film));
    }
    public void deleteFromFavoriteList(FilmDetails film) {
        FavoriteFilm favoriteFilm = new FavoriteFilm(getUsername(), film);
        favoriteFilmList.remove(favoriteFilm);
    }
    public void addFilmComment(FilmDetails film, String comment) {
        filmCommentList.add(new FilmComment(getUsername(), film, comment));
    }
    public void addFilmRate(FilmDetails film, double rate) {
       filmRateList.add(new FilmRate(getUsername(), film, rate));
    }

    @Override
    public String toString() {
        return "Users{" +
                "fullName='" + fullName + '\n' +
                "username='" + username + '\n' +
                "email='" + email + '\n' +
                '}';
    }
}
