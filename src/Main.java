import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static ArrayList<Users> userList;
    private static Film film;
    public static void main(String[] args) {
        fillUserList();
        fillFilmList();

    }

    public static Users signup() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("İsim Soyisim giriniz: ");
        String fullName = scanner.nextLine();
        System.out.print("Kullanıcı adı giriniz: ");
        String username = scanner.nextLine();
        System.out.print("Emailinizi giriniz: ");
        String email = scanner.nextLine();
        System.out.print("Şifrenizi giriniz: ");
        String password = scanner.nextLine();

        Users newUser = new Users(fullName, username, email, password);
        userList.add(newUser);
        return newUser;
    }
    public static Users login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kullanıcı adı: ");
        String username = scanner.nextLine();

        System.out.print("Şifre: ");
        String password = scanner.nextLine();

        for(Users u : userList) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password))
                return u;
        }
        System.out.println("kullanıcı bulunamadı");
        return null;
    }
    public static void home(int islem) {
        System.out.println("sisteme başarılı bir şekilde giriş yaptınız...");
        System.out.println("hangi işlemi yapmak istiyorsunuz?");
        System.out.println("1. kullanıcıları listele");
        System.out.println("2. filmleri listele");
        if (islem == 1) {
            print(userList);
        }
        else if(islem == 2) {
            print(film.getFilmList());
        }
        else System.out.println("yanlış işlem sistem kapatılıyor..");
    }
    private static double randRate() {
        Random random = new Random();

        double value = random.nextDouble() * 10.0;
        value = Math.round(value * 100.0) / 100.0;
        return value;

    }
    private static int selectFavFilm() {
        Random random = new Random();
        int value = random.nextInt() * 3;

        return value;
    }
    public static void rate() {
        for (Users u : userList) {
            for (FilmDetails f : film.getFilmList()) {
                u.addFilmRate(f,randRate());
            }
        }
    }
    public static void comment() {
        for (Users u : userList) {
            for (FilmDetails f : film.getFilmList()) {
                u.addFilmComment(f,"different comment" + randRate());
            }
        }
    }
    public static void favorite() {
        for (Users u : userList) {
            u.addFavoriteList(film.getFilmList().get(2));
            u.addFavoriteList(film.getFilmList().get(4));
        }
    }
    private static void fillUserList() {
        userList = new ArrayList<>();
        userList.add(new Users("Dua Lipa", "dualipa", "dualipa@filmlib.com","Asdf1234"));
        userList.add(new Users("Fatma Aydin", "fatmaydin", "fatmaaydin@filmlib.com","Asdf1234"));
        userList.add(new Users("Ali Seker", "aliseker", "aliseker@filmlib.com","Asdf1234"));
        userList.add(new Users("Mavi Cam", "mavicam", "mavicam@filmlib.com","Asdf1234"));
        userList.add(new Users("Teoman Akkas", "teomanakkas", "teomanakkas@filmlib.com","Asdf1234"));
        userList.add(new Users("Sebnem Ferah", "sebnemferah", "sebnemferah@filmlib.com","Asdf1234"));
        userList.add(new Users("Sezen Aksu", "minikserce", "sezenaksu@filmlib.com","Asdf1234"));
        userList.add(new Users("Baris Manco", "barismanco", "barismanco@filmlib.com","Asdf1234"));

    }
    private static void fillFilmList() {
        film = new Film();
        film.addFilm(new FilmDetails("La La Land",
                new ArrayList<>(Arrays.asList("Unlu Kadin 1", "Unlu erkek 1")),
                "this is summary 1",
                new ArrayList<>(Arrays.asList("musical", "romantic")),
                "2018", "2023", 135));

        film.addFilm(new FilmDetails("Midnight in Paris",
                new ArrayList<>(Arrays.asList("Unlu Kadin 2", "Unlu erkek 2")),
                "this is summary 2",
                new ArrayList<>(Arrays.asList("dram", "romantic")),
                "2016", "2023", 201));

        film.addFilm(new FilmDetails("Elemental",
                new ArrayList<>(Arrays.asList("Unlu Kadin 3", "Unlu erkek 3")),
                "this is summary 3",
                new ArrayList<>(Arrays.asList("musical", "children")),
                "2007", "2023", 160));

        film.addFilm(new FilmDetails("Spiderman",
                new ArrayList<>(Arrays.asList("Unlu Kadin 4", "Unlu erkek 4")),
                "this is summary 4",
                new ArrayList<>(Arrays.asList("animation", "horror")),
                "1990", "2023", 85));

        film.addFilm(new FilmDetails("Get away from us!",
                new ArrayList<>(Arrays.asList("Unlu Kadin 5", "Unlu erkek 5")),
                "this is summary 5",
                new ArrayList<>(Arrays.asList("comedy", "psycho")),
                "2023", "2023", 147));



    }
    private static <T> void print(ArrayList<T> arr) {
        for(T item: arr) {
            System.out.println(item.toString());
        }
    }

}
