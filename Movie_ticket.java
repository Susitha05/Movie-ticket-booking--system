import java.util.Scanner;
import java.io.*;

public class Movie_ticket {
    Scanner sc = new Scanner(System.in);
    String Username;
    int Password;
    public int num = 0;

    public void login() {
        // check login

        System.out.println("Please enter Username");
        Username = sc.nextLine();
        System.out.println("Please enter Password");
        Password = sc.nextInt();

        if (Username.equals("susa") && Password == 2002) {
            System.out.println("Hi Admin");
            System.out.println("1.Movie Management");
            System.out.println("2.Theater Management");
            System.out.println("3.Booking Management");
            System.out.println("Enter Key Number");
            num = sc.nextInt();
            if (num == 1) {
                movie_mana();

            } else if (num == 2) {
                theater_man();

            } else if (num == 3) {
                booking_man();

            } else {
                System.out.println("Please enter valid key number");
            }

        } else {
            System.out.println("Hi " + Username);
        

        }

    }
    Public String [] movies;
    int size =10;

    public void movie_mana() {
        movies = new string[size] ={"Movie - How to train your dragon| Time - 08.30 a.m|11.20 a.m|1.00 p.m"};
    }

    public void theater_man() {

    }

    public void booking_man() {

    }

}

class Main {
    public static void main(String[] args) {
        Movie_ticket mt = new Movie_ticket();
        mt.login();

    }
}
