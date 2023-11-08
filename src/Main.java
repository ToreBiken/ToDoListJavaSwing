import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Login l=new Login();
        User u= new OrdinaryUser();
        ShowAll sa=new ShowAll();
        Premiers p=new Premiers();
        SearchFilm s2=new SearchFilm();
       s2.films();


       System.out.println("Уже имеете Аккаунт или же Хотите создать новый?");
        System.out.println("1 - Войти в аккаунт\n" +
                "2 - Создать новый");
        Scanner str1=new Scanner(System.in);
        String выбор=str1.nextLine();
        if(выбор.equals("1")){
            l.login();
        } else if(выбор.equals("2")){
            l.registerLogin();
        }

        sa.ShowALL();

    System.out.println("введите id-фильма ");
        Scanner id= new Scanner(System.in);
         int id1= id.nextInt();
        System.out.println("напишите свою рецензию");
         Scanner review=new Scanner(System.in);
     u.writeReview();

        //Искать актера
      System.out.println("Введите  имя Актера");
      Scanner act=new Scanner(System.in);
        String  act1=act.nextLine();
        u.readReview();

        //Искать фильм
       u.films();
        //Премьеры
        p.ShowPremiers();
        // Рейтинг
      u.rate();
        //watchlist*/


    }}