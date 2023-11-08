import java.sql.*;
import java.util.Scanner;

public abstract class User  implements subscribable{


    String URL = "jdbc:postgresql://localhost:5432/film";

    public void ShowbyActor() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(URL, "postgres", "6566Shaikhan");
            Statement stmt = con.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя актера: ");
            String actorName = scanner.nextLine();
            ResultSet rs = stmt.executeQuery("select distinct a.name as Actor, f2.release_date, f2.title " +
                    "from actors a " +
                    "join filmactors fa on a.id = fa.actor_id " +
                    "join films f2 on fa.film_id = f2.id " +
                    "where a.name like '%" + actorName + "%'");
            if (!rs.next()) {
                System.out.println("Актер " + actorName + " не найден.");
            } else {
                rs.beforeFirst();}
            while (rs.next()) {
                String title = rs.getString("title");
                String releaseDate = rs.getString("release_date");
                String actor = rs.getString("Actor");
                System.out.println("Title: " + title);
                System.out.println("Release date: " + releaseDate);
                System.out.println("Actor: " + actor + "\n");
            }
            con.close();
        } catch (Exception e) {
            System.out.println("ошибка: " + e.getMessage());
        }
    }

    public void  ShowPremiers ()throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection(URL,"postgres","6566Shaikhan");
        Statement stmt= con.createStatement();
        System.out.println("Film | Genre | Date of Premier | Country ");
        ResultSet rs=stmt.executeQuery("select * from Premieres");
        while(rs.next()){
            System.out.println(rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getDate(4)+" | "+rs.getString(5));

        }}
        public void readReview() throws Exception {
            try {
                Class.forName("org.postgresql.Driver");
                System.out.println("Введите название фильма к которому вы хотите прочитать рецезнию :");
                Scanner str1=new Scanner(System.in);
                String Nazvanie= str1.nextLine();
                Connection conn = DriverManager.getConnection(this.URL, "postgres", "6566Shaikhan");
                PreparedStatement stmt = conn.prepareStatement("SELECT reviews FROM films WHERE title = '"+ Nazvanie+"';");
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String review = rs.getString("reviews");
                    System.out.println("рецензия на фильм " + Nazvanie + ": " + review);
                } else {
                    System.out.println("нет рецензии для фильма " + Nazvanie);
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println("ощибка:" + e.getMessage());
            }
        }
     public void writeReview() throws Exception{
        try {

            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, "postgres", "6566Shaikhan");
            PreparedStatement stmt = conn.prepareStatement("Update  films set reviews = '"+reviewText+"' where id="+filmId+";");


            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("Review added successfully.");
            } else {
                System.out.println("Error adding review.");
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }
    }
    public void EditReview(int filmId, String reviewText) throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(this.URL, "postgres", "6566Shaikhan");
            System.out.println("Введите имя фильма");
            Scanner str1 = new Scanner(System.in);
            String str2 = str1.nextLine();
            System.out.println("Напишите новую рецензию");
            Scanner str3 = new Scanner(System.in);
            String str4 = str1.nextLine();

            PreparedStatement stmt = conn.prepareStatement("Update  film set review = '" + str4 + "' where film_id=" + str2 + ";");
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Review edited successfully.");
            } else {
                System.out.println("Error editing review.");
            }

            stmt.close();
            conn.close();
        } catch (SQLException var6) {
            System.out.println("SQL error: " + var6.getMessage());
        }
    }
        public void removeReview() throws Exception{
        try {
            System.out.println("Введите имя фильмя, для которого хотите удалить рецензию");
            Scanner str=new Scanner(System.in);
            String str1=str.nextLine();
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, "postgres", "6566Shaikhan");
            PreparedStatement stmt = conn.prepareStatement("Update  films set Reviews = null where id="+str1+";");


            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("Review removed successfully.");
            } else {
                System.out.println("Error removing review.");
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }

    } public void films() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection(URL,"postgres","6566Shaikhan");
            Statement stmt= con.createStatement();
            System.out.println("Введите имя фильма");
            Scanner str1= new Scanner(System.in);
            String FilmName=str1.nextLine();
            ResultSet rs=stmt.executeQuery("select distinct f.title,f.rate,f.release_date,f.description,a.name,f.genre,f.director\n" +
                    "from films f\n" +
                    "join filmactors f2 on f.id = f2.id\n" +
                    "join actors a on a.id = f2.actor_id\n" +
                    "where f.title like '"+FilmName+"%';");
            while(rs.next()){
                String title= rs.getString("title");
                Date release_year =rs.getDate("release_date");
                String Actor= rs.getString("name");
                String Descr= rs.getString("description");
                String Genre=rs.getString("genre");
                String Pro=rs.getString("director");
                System.out.println("Title: " + title);
                System.out.println("Description: " + Descr);
                System.out.println("Release year: " + release_year);
                System.out.println("Actor: " + Actor);
                System.out.println("Genre: " + Genre);
                System.out.println("Producer: " + Pro);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
        public void  rate ()throws Exception{
            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection(URL,"postgres","6566Shaikhan");
            Statement stmt= con.createStatement();
            System.out.println("Укажите топ/лимит ");
            Scanner str1= new Scanner(System.in);
            int lim=str1.nextInt();
            ResultSet rs=stmt.executeQuery("SELECT title, rate as film_rate FROM films order by film_rate desc limit "+lim+";");
            while(rs.next()){
                System.out.println(rs.getString("title")+" | "+rs.getFloat("film_rate"));
            }
        };

}
