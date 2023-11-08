import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

public class CheckSub {



    String URL = "jdbc:postgresql://localhost:5432/film";

    public void films() throws Exception{
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(URL, "postgres", "6566Shaikhan");
            Statement stmt = con.createStatement();

            Scanner str1 = new Scanner(System.in);
            String login = str1.nextLine();
            ResultSet rs = stmt.executeQuery("select login.sub\n" +
                    "    from  login\n" +
                    "where id=(select id\n" +
                    "          from login l\n" +
                    "          where l.username='"+login+"');");


        }catch ( Exception e){}
    }}