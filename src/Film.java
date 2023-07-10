import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Film {
    private ArrayList<FilmDetails> filmList;

    Film() {
        filmList = new ArrayList<>();
    }


    public FilmDetails addFilm(FilmDetails film) {
        filmList.add(film);
        return film;
    }
    public FilmDetails editFilmDetail(String filmName, FilmDetails film) {
        FilmDetails edit = null;
        for (FilmDetails f : filmList) {
            if (f.getFilmName().equals(filmName)) {
                edit = f;
                Class<?> filmClass = FilmDetails.class;
                Field[] fields = filmClass.getDeclaredFields();

                for (Field field : fields) {
                    field.setAccessible(true);
                    try {
                        Object value = field.get(film);
                        if (value != null) {
                            field.set(edit, value);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
        }

        return edit;
    }
    public FilmDetails searchFilm(String filmName) {
        for(FilmDetails f : filmList) {
            if(f.getFilmName().equals(filmName))
                return f;
        }
        return null;
    }
    public FilmDetails deleteFilm(String filmName) {
        FilmDetails delete = searchFilm(filmName);
        filmList.remove(delete);

        return delete;
    }
    public ArrayList<FilmDetails> getFilmList() {
        return filmList;
    }
    public ArrayList<FilmDetails> getFilmList(String genre) {
        ArrayList<FilmDetails> matchingFilms = new ArrayList<>();

        for (FilmDetails film : filmList) {
            List<String> genres = film.getGenre();
            if (genres.contains(genre)) {
                matchingFilms.add(film);
            }
        }

        return matchingFilms;
    }
    public String getFilmDetail(String filmName) {
        return searchFilm(filmName).toString(); 
    }
    public int filmCount() {
        return filmList.size();
    }
    public ArrayList<String> newFilms() {

        Collections.sort(filmList, new Comparator<FilmDetails>() {
            @Override
            public int compare(FilmDetails film1, FilmDetails film2) {
                return film1.getReleaseYear().compareTo(film2.getReleaseYear());
            }
        });

        ArrayList<String> filmNames = new ArrayList<>();
        for (FilmDetails film : filmList) {
            filmNames.add(film.getFilmName());
        }
        Collections.reverse(filmNames);
        return filmNames;
    }
    public ArrayList<String> getMostRatedFilms() {
        Collections.sort(filmList, new Comparator<FilmDetails>() {
            @Override
            public int compare(FilmDetails film1, FilmDetails film2) {
                double rate1 = film1.getTotalRate();
                double rate2 = film2.getTotalRate();

                if (rate1 > rate2) {
                    return -1;
                } else if (rate1 < rate2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        ArrayList<String> filmNames = new ArrayList<>();
        for (FilmDetails film : filmList) {
            filmNames.add(film.getFilmName());
        }

        return filmNames;
    }
    public ArrayList<String> getMostLengthFilms() {

        Collections.sort(filmList, new Comparator<FilmDetails>() {
            @Override
            public int compare(FilmDetails film1, FilmDetails film2) {
                return Integer.compare(film2.getLength(), film1.getLength());
            }
        });

        ArrayList<String> filmNames = new ArrayList<>();
        for (FilmDetails film : filmList) {
            filmNames.add(film.getFilmName());
        }

        return filmNames;
    }
    public ArrayList<String> getLeastLengthFilms() {
        ArrayList<String> mostLengthFilms = getMostLengthFilms();
        Collections.reverse(mostLengthFilms);
        return mostLengthFilms;
    }
}
