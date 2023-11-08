import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Premiers  {
    String URL = "jdbc:postgresql://localhost:5432/film";
    public void  ShowPremiers ()throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection(URL,"postgres","6566Shaikhan");
        Statement stmt= con.createStatement();
        System.out.println("Film | Genre | Date of Premier | Country ");
        ResultSet rs=stmt.executeQuery("select * from Premieres");
                while(rs.next()){
                    System.out.println(rs.getString(2)+"         | "+rs.getString(3)+"           | "+rs.getDate(4)+"         | "+rs.getString(5));

                }

        }
    }


