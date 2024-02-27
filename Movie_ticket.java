import java.util.Scanner;
import java.io.*;

// Creating Seat class
class Seat {
    int seatNumber;
    boolean isBooked;
    Seat prev;
    Seat next;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        isBooked = false;
        prev = null;
        next = null;
    }

}

public class Movie_ticket {
    Scanner sc = new Scanner(System.in);
    String Username;
    int Password;
    public int num = 0;
    public String[] movies;
    int size = 10;
    String m_name;

    public Movie_ticket() {

    }

    public void login() {
        // check login

        System.out.println("Please enter Username");
        Username = sc.nextLine();
        System.out.println("Please enter Password");
        Password = sc.nextInt();

        if (Username.equals("susa") && Password == 2002) {
            // admin part
            System.out.println("Hi Admin");
            System.out.println("1.Movie Management");
            System.out.println("2.Theater Management");
            System.out.println("3.Booking Management");
            System.out.println("Enter Key Number");
            num = sc.nextInt();
            if (num == 1) {
                movie_mana();

            } else if (num == 2) {
                theater the = new theater();

            } else if (num == 3) {
                booking book = new booking();

            } else {
                System.out.println("Please enter valid key number");
            }

        } else {
            // user part
            System.out.println("1.Movie Management");
            System.out.println("2.Theater Management");
            System.out.println("3.Seat Booking");
            System.out.println("Enter Key Number");
            num = sc.nextInt();
            User ur = new User();

            if (num == 1) {

            } else if (num == 2) {

            } else if (num == 3) {
                System.out.println("how many Seats are you need ");
                int seat_num = sc.nextInt();
                Seat seat = new Seat(seat_num);
                ur.booking(seat.seatNumber);

            } else {
                System.out.println("Please enter valid key number");
            }

        }

    }

    public void movie_mana() {
        System.out.println("1.ADD Movies");
        System.out.println("2.Delete Movies");
        System.out.println("3.View Movies List");
        int dis = sc.nextInt();
        if (dis == 1) {
            movie_insert();
        } else if (dis == 2) {
            mo_delete();
        } else if (dis == 3) {
            mo_view();
        } else {
            System.out.println("Enter valid number");
        }

    }

    public void movie_insert() {// add movie
        movies = new String[size];
        movies[0] = "Movie - How to Train Your Dragon | Time - 08.30 a.m | 11.20 a.m | 1.00 p.m";
        System.out.println("Enter Movie Name or type 'end' to stop adding movies:");
        String m_name = sc.nextLine();
        int i = 1;
        while (!m_name.equals("end") && i < size) {
            System.out.println("Enter Time for " + m_name + ":");
            String time = sc.nextLine();
            movies[i++] = "Movie - " + m_name + " | Time - " + time;
            System.out.println("Enter Movie Name or type 'end' to stop adding movies:");
            m_name = sc.nextLine();
        }
        System.out.println("1.ADD Movies");
        System.out.println("2.Delete Movies");
        System.out.println("3.View Movies List");
        int EXNb = sc.nextInt();
        if (EXNb == 1) {
            movie_insert();
        } else if (EXNb == 2) {
            mo_delete();
        } else if (EXNb == 3) {
            mo_view();
        } else {
            System.out.println("Enter valid number");
        }

    }

    public void mo_delete() {
        System.out.println("enter Movie Listing Number");
        int mdel = sc.nextInt();
        movies[mdel] = null;
        System.out.println("Delete Successful");
        System.out.println("1.ADD Movies");
        System.out.println("2.Delete Movies");
        System.out.println("3.View Movies List");
        int EXNb = sc.nextInt();
        if (EXNb == 1) {
            movie_insert();
        } else if (EXNb == 2) {
            mo_delete();
        } else if (EXNb == 3) {
            mo_view();
        } else {
            System.out.println("Enter valid number");
        }

    }

    public void mo_view() {
        for (int x = 0; x < size; x++) {
            System.out.println(x + ". " + movies[x]);
        }
        System.out.println("1.ADD Movies");
        System.out.println("2.Delete Movies");
        System.out.println("3.View Movies List");
        int EXNb = sc.nextInt();
        if (EXNb == 1) {
            movie_insert();
        } else if (EXNb == 2) {
            mo_delete();
        } else if (EXNb == 3) {
            mo_view();
        } else {
            System.out.println("Enter valid number");
        }

    }
}

class theater
{

}

class booking
{

}

class User {
    Seat head;
    Seat tail;

    public User() {
        for (int i = 0; i <= 50; i++) {
            addSeat(i);
        }
    }

    public void addSeat(int seatNumber) {
        Seat nSeat = new Seat(seatNumber);
        if (head == null) {
            head = nSeat;
            tail = nSeat;
        } else {
            tail.next = nSeat;
            nSeat.prev = tail;
            tail = nSeat;
        }
    }

    public void booking(int seatNumber) {
        Seat current = head;
        while (current != null) {
            if (current.seatNumber == seatNumber) {
                if (!current.isBooked) {
                    current.isBooked = true;
                    System.out.println("Seat " + seatNumber + " booked successfully.");
                } else {
                    System.out.println("Seat " + seatNumber + " is already booked.");
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Invalid seat number.");
    }
}

class Main {
    public static void main(String[] args) {
        Movie_ticket mt = new Movie_ticket();
        mt.login();

    }
}
