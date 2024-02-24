import java.util.Scanner;
import java.io.*;


// Creating Seat class
class Seat{   
    int seatNumber;
    boolean isBooked;
    Seat prev;
    Seat next;

    Seat (int seatNumber){
        this.seatNumber=seatNumber;
        isBooked=false;
        prev = Null;
        next= Null;
    }
} 

public class Movie_ticket {
    Scanner sc = new Scanner(System.in);
    String Username;
    int Password;
    public int num = 0;
    Seat head;
    Seat tail;
// creating Linked list for seats
    public Movie_ticket(){
        for(int i=o;i<=50;i++){
            addSeat(i);
        }

    }
    public void addSeat (int seatNumber){
        Seat nSeat = new Seat(seatNumber);
        if(head==null){
            head =nSeat;
            tail =nSeat;
        }else{
            tail.next= nSeat;
            nSeat.prev=tail;
            tail=nSeat;
        }

    }

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
<<<<<<< Updated upstream
            //HHI
=======
>>>>>>> Stashed changes

        }

    }

    public String[] movies;
    int size = 10;
    String m_name;

    public void movie_mana() {
        System.out.println("1.ADD Movies");
        System.out.println("2.Delete Movies");
        int dis = sc.nextInt();
        if (dis == 1) {
            movie_insert();
        } else if (dis == 2) {
            mo_delete();
        } else {
            System.out.println("Enter valid number");
        }

    }

    public void movie_insert() {// add movie
        movies = new String[size];
        movies[0] = "Movie - How to Train Your Dragon | Time - 08.30 a.m | 11.20 a.m | 1.00 p.m";
        System.out.println("enter Movie Name");
        m_name = sc.nextLine();
        for (int i = 1; m_name.equals("end"); i++) {
            movies[i++] = m_name;
            System.out.println("enter Movie Name");
            m_name = sc.nextLine();
        }
        System.out.println("1.ADD Movies");
        System.out.println("2.Delete Movies");
        int EXNb = sc.nextInt();
        if (EXNb == 1) {
            movie_insert();
        } else if (EXNb == 2) {
            mo_delete();
        } else {
            System.out.println("Enter valid number");
        }

    }

    public void mo_delete() {

    }

    public void theater_man() {

    }

    public void booking_man() {
            System.out.println();

            //Show available Seat Count
            System.out.println("Available Seat Count: ");
            Seat current = head;
            while (current != Null) {
                if (current.seatNumber == bookSeat) {
                    if (current.isBooked==false) {
                        current.isBooked=true;
                        System.out.println("Seat Count" +bookSeat+ " booked Succesfully. ");
                    

                    }else{
                        System.out.println("Seat Count" +bookSeat+ "Already Booked");
                    }
                    break;
                   
                }
                current=current.next;

            }   
            if(current==Null){
                System.out.println("invalid Seat Count");
            }
    }

}

class Main {
    public static void main(String[] args) {
        Movie_ticket mt = new Movie_ticket();
        mt.login();

    }
}
