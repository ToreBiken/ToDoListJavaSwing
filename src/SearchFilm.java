import java.sql.*;
import java.util.Scanner;

public class SearchFilm {

    String URL = "jdbc:postgresql://localhost:5432/film";

    public void films() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(this.URL, "postgres", "6566Shaikhan");
            Statement stmt = con.createStatement();
            System.out.println("Введите имя фильма");
            Scanner str1 = new Scanner(System.in);
            String FilmName = str1.nextLine();
            ResultSet rs = stmt.executeQuery("select distinct f.title,f.rate,f.release_date,f.description,a.name,f.genre,f.director\nfrom films f\njoin filmactors f2 on f.id = f2.id\njoin actors a on a.id = f2.actor_id\nwhere f.title like '" + FilmName + "%';");


            if (!rs.next()) {
                System.out.println("Извините, но пока что такого фильма у нас в базе нету");
            } else {

                do {
                    String title = rs.getString("title");
                    Date release_year = rs.getDate("release_date");
                    String Actor = rs.getString("name");
                    String Descr = rs.getString("description");
                    String Genre = rs.getString("genre");
                    String Pro = rs.getString("director");
                    System.out.println("Title: " + title);
                    System.out.println("Description: " + Descr);
                    System.out.println("Release year: " + release_year);
                    System.out.println("Actor: " + Actor);
                    System.out.println("Genre: " + Genre);
                    System.out.println("Producer: " + Pro);
                } while (rs.next());
            }

            con.close();
        } catch (Exception var12) {
            System.out.println("An error occurred: " + var12.getMessage());
        }
    }
}
