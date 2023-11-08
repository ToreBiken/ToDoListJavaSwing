import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchActor {
    String URL = "jdbc:postgresql://localhost:5432/film";
    public void searchActor(String actorName) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(URL, "postgres", "6566Shaikhan");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select a.name as Actor,f2.title\n" +
                    "from actors a\n" +
                    "join filmactors f on a.id = f.actor_id\n" +
                    "join films f2 on f.film_id = f2.id\n" +
                    "where name like '"+actorName+"%'");
            while (rs.next()) {
                String title = rs.getString("title");
                String actor = rs.getString("Actor");
                System.out.println(title + " | " + actor);
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid actor name");
        }
    }
}
