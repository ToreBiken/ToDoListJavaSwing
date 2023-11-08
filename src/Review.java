import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Review {
    String URL = "jdbc:postgresql://localhost:5432/film";
    public void writeReview(int filmId, String reviewText) throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(this.URL, "postgres", "6566Shaikhan");
            System.out.println("Введите имя фильма");
            Scanner str1 = new Scanner(System.in);
            String str2=str1.nextLine();
            System.out.println("Напишите рецензию");
            Scanner str3 = new Scanner(System.in);
            String str4=str1.nextLine();

            PreparedStatement stmt = conn.prepareStatement("Update  film set review = '" + str4 + "' where film_id=" + str2 + ";");
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Review added successfully.");
            } else {
                System.out.println("Error adding review.");
            }

            stmt.close();
            conn.close();
        } catch (SQLException var6) {
            System.out.println("SQL error: " + var6.getMessage());
        }

    }
}