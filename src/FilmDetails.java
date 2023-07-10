import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilmDetails {
    private String filmName;
    private ArrayList<String> castList;
    private String summary;
    private double totalRate;
    private ArrayList<String> genre;
    private String releaseYear;
    private String addedYear;
    private Integer length;


    public FilmDetails(String filmName, ArrayList<String> castList, String summary, ArrayList<String> genre,
                       String releaseYear, String addedYear, Integer length) {
        this.filmName = filmName;
        this.castList = castList;
        this.summary = summary;
        this.totalRate = 0.0;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.addedYear = addedYear;
        this.length = length;
    }

    public FilmDetails() {

    }

    public String getFilmName() {
        return filmName;
    }
    public ArrayList<String> getCastList() {
        return castList;
    }
    public String getSummary() {
        return summary;
    }
    public double getTotalRate() {
        return totalRate;
    }
    public ArrayList<String> getComments(ArrayList<Users> users) {
        ArrayList<String> comments = new ArrayList<>();
        for (Users u : users) {
            for (FilmComment fc : u.getFilmCommentList()) {
                if (fc.getFilm().getFilmName().equals(getFilmName()))
                    comments.add(fc.getComment());
            }
        }

        if (comments == null)
            return null;

        return comments;
    }
    public ArrayList<String> getGenre() {
        return genre;
    }
    public String getReleaseYear() {
        return releaseYear;
    }
    public String getAddedYear() {
        return addedYear;
    }
    public int getLength() { return length; }
    protected double calculateTotalRate(ArrayList<Users> users) {
        ArrayList<FilmRate> rates = new ArrayList<>();
        for(Users u : users) {
            rates.addAll(u.getFilmRateList());
        }
        List<FilmRate> filteredRates = rates.stream()
                .filter(x -> x.getFilm().getFilmName().equals(getFilmName()))
                .collect(Collectors.toList());

        double toplam = 0.0;
        for(int i = 0; i < filteredRates.size(); i++) {
            toplam += filteredRates.get(i).getRate();
        }
        totalRate = toplam/filteredRates.size();

        return totalRate;
    }

    @Override
    public String toString() {
        return
                "filmName=" + filmName + '\n' +
                "castList=" + castList +
                "summary=" + summary + '\n' +
                "totalRate=" + totalRate + '\n' +
                "genre=" + genre + '\n' +
                "releaseYear=" + releaseYear + '\n' +
                "addedYear=" + addedYear + '\n' +
                "length=" + length;
    }
}
