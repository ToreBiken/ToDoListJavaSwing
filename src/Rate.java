
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Rate {


        String URL = "jdbc:postgresql://localhost:5432/film";
        public void  rate ()throws Exception{
            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection(URL,"postgres","6566Shaikhan");
            Statement stmt= con.createStatement();
            System.out.println("Укажите лимит ");
            Scanner str1= new Scanner(System.in);
            int lim=str1.nextInt();
            ResultSet rs=stmt.executeQuery("SELECT title, rate as film_rate FROM films");
            while(rs.next()){
                System.out.println(rs.getString(2)+" | "+rs.getFloat(10));
            }
        };

    }



