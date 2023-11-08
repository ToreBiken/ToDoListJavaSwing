import java.sql.*;
import java.util.Scanner;

public class Login {

    private static final String URL = "jdbc:postgresql://localhost:5432/film";

    public void login() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, "postgres", "6566Shaikhan");
            stmt = conn.prepareStatement("SELECT username FROM login WHERE password = '"+password+"' AND username = '"+username+"';");

            rs = stmt.executeQuery();

            if (rs.next()) {
                String foundUsername = rs.getString("username");
                System.out.println("Hello " + foundUsername);
            } else {
                System.out.println("Invalid username or password");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(URL, "postgres", "6566Shaikhan");
            Statement stmt1 = con.createStatement();
            ResultSet rs1= stmt1.executeQuery("select login.sub\n" +
                    "    from  login\n" +
                    "where id=(select id\n" +
                    "          from login l\n" +
                    "          where l.username='"+username+"');");

            rs1.next();
           boolean sub= rs1.getBoolean(4);

            if(!sub){

            }
        }catch (Exception e){
            System.out.println("у вас нету его ");
    } }


    public void registerLogin() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, "postgres", "6566Shaikhan");
            stmt = conn.prepareStatement("SELECT * FROM login WHERE username = '"+username+"';");

            rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Username already exists");
                return;
            }
            stmt = conn.prepareStatement("INSERT INTO login (username, password, sub) VALUES ('"+username+"','"+password+"','0')");

            stmt.executeUpdate();
            System.out.println("Registration successful");
        } catch (SQLException e) {
            System.out.println("Registration failed: " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}

