import java.util.Scanner;

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

class theater {
    Scanner sc = new Scanner(System.in);
    int size = 5;
    String[] Theater = new String[size];
    String[] times = new String[] { "10.30AM", "12.00PM", "3.00PM", "5.00PM" };

    public theater(){
        Theater[0] = "SCOPE Cinema";
        Theater[1] = "PVR Cinema";
        Theater[2] = "Climax Cinema";
    }
    public void backwards() {
        System.out.println("1.ADD Theaters");
        System.out.println("2.View Theaters");
        int EXNb = sc.nextInt();
        if (EXNb == 1) {
            add_theater();
        } else if (EXNb == 2) {
            View();
        }
    }

    public void add_theater() {

            System.out.println("Enter Theater Name");
            String th = sc.next();
            int arrlength = Theater.length-1;
            Theater[arrlength] = th;
        backwards();
    }

    public void View() {
        for (int t = 0; t < Theater.length; t++) {
            if(Theater[t]!= null){
            System.out.println(t + "." + Theater[t]);
        }
        }
        Movie_ticket mk = new Movie_ticket();
        mk.menus();
    }
}

class Movie_ticket extends theater {
    Scanner sc = new Scanner(System.in);
    String Username;
    int Password;
    public int num = 0;
    public String[] movies = new String[]{"Batman   |   PVR Cinemas   |   10.00AM ","Avengers   |   Scope Cinemas   |   12.45PM ","Madam Web   |   Climax Cinema   |   1.00PM ","Hulk   |   PVR Cinemas   |   10.30AM "};
    int size = 10;
    String m_name;

    public void menus() {
        System.out.println("\n1.Movie Management");
        System.out.println("2.Theater Management");
        System.out.println("3.Booking Management");
        System.out.println("\nEnter Key Number");
        num = sc.nextInt();
        if (num == 1) {
            movie_mana();
        } else if (num == 2) {
            theater the = new theater();
            the.backwards();
        } else if (num == 3) {
            booking book = new booking();
        } else {
            System.out.println("Please enter valid key number");
        }
    }

    public void login() {
        System.out.println("Please enter Username");
        Username = sc.next();
        System.out.println("Please enter Password");
        Password = sc.nextInt();

        if (Username.equals("susa") && Password == 2002) {
            System.out.println("Hi Admin");
            menus();
        } else {
            User ur = new User();
            ur.movie_list();
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

    public void movie_insert() {
        int i = 0;
        while (i < size) {
            System.out.println("Enter Movie Name or type 'end' to stop adding movies:");
            m_name = sc.next();
            if (m_name.equals("end"))
                break;
            System.out.println("Available Theaters:");
            for (int p = 0; p < Theater.length; p++) {
                if (Theater[p] != null) {
                    System.out.println(p + ". " + Theater[p]);
                }
            }
            System.out.println("Select the Theater ");
            int y = sc.nextInt();
            String t_hall = Theater[y];
            for (int ti = 0; ti < times.length; ti++) {
                System.out.println("\n" + ti + "." + times[ti]);
            }
            System.out.println("Pick the Time");
            int tme = sc.nextInt();
            String timo = times[tme];
            movies[movies.length-1] = "Movie - " + m_name + " Theater - " + t_hall + " | Time - " + timo;
            System.out.println("Movie added Sucessfully");
        }
        movie_mana();
    }

    public void mo_delete() {
        System.out.println("enter Movie Listing Number");
        int mdel = sc.nextInt();
        movies[mdel] = null;
        System.out.println("Delete Successful");
        movie_mana();
    }

    public void mo_view() {
        for (int x = 0; x < movies.length; x++) {
            if(movies[x]!=null)
            System.out.println(x + ". " + movies[x]);
        }      
        System.out.println("\nPress 0 to Main menu");
        Scanner sc1 = new Scanner(System.in);
        int exit = Integer.parseInt(sc1.nextLine());
        if(exit == 0){
            menus();
        }
        else {
            login();
        }
    }
}

class booking {
}

class Map {
    public void dijkstra(int graph[][], int src) {
        int dist[] = new int[4];
        Boolean b[] = new Boolean[4];
        for (int i = 0; i < 4; i++) {
            dist[i] = Integer.MAX_VALUE;
            b[i] = false;
        }
        dist[0] = 0;
        for (int count = 0; count < 4; count++) {
            int u = minDistance(dist, b);
            b[u] = true;
            for (int x = 0; x < 4; x++) {
                if (!b[x] && graph[u][x] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][x] < dist[x]) {
                    dist[x] = dist[u] + graph[u][x];
                }
            }
            printGraph(dist, 4);
        }
    }

    public int minDistance(int dist[], Boolean b[]) {
        int min = Integer.MIN_VALUE, index = 0;
        for (int x = 0; x < 4; x++) {
            if (!b[x] && dist[x] <= min) {
                min = dist[x];
                index = x;
            }
        }
        return index;
    }

    public int[][] locations() {
        int graph[][] = new int[][] { { 0, 3, 5, 4 }, { 2, 3, 0, 5 }, { 0, 4, 5, 7 }, { 0, 3, 5, 2 } };
        return graph;
    }

    public void printGraph(int dist[], int x) {
        System.out.println("Distance from source to location is");
        for (int i = 0; i < 4; i++) {
            System.out.println(i + "-----" + dist[i]);
        }
    }
}

class User extends Movie_ticket {
    Seat head;
    Seat tail;


    public User() {
        for (int i = 0; i <= 50; i++) {
            addSeat(i);
        }
    }

    public void movie_list() {
        int booked[] = new int[50];
        int Booked_seats[] = new int[10];
        booked[0]=1;
        booked[10]=10;
        booked[40]=40;
        int persons = 0;
        double sum = 0;
        double tk_price = 850.0;



        for (int x = 0; x < movies.length; x++) {
            if(movies[x]!=null)
            System.out.println(x + ". " + movies[x]); 
        }
      
        System.out.println("Enter Movie Number ");
         int mv_no = sc.nextInt();
        
         System.out.println("For many Persons");
         persons = sc.nextInt();

         System.out.println("Already Booked Seats ");
         for(int g =0;g<booked.length;g++)
         {
            if(booked[g]!=0)
            {
                System.out.print(booked[g]);
                System.out.print(",");
            }
         
         }
         for(int i=0; i<persons; i++ ){
            System.out.println("\nSelect Your Seat Number");
            int seat_num = sc.nextInt();
            Booked_seats[i] = seat_num;
            Seat seat = new Seat(seat_num);
            booking(seat.seatNumber);
            sum = sum + tk_price;
         }

         System.out.println("\nYour Booking Summery :\n");
         System.out.println("Movie Details");
         System.out.println(movies[mv_no]);
         System.out.println("\nBooked Seats : ");
        for(int f=0; f<persons; f++){
            System.out.print(Booked_seats[f]);
            System.out.print(",");
        }
        System.out.println("\n\nTotal Cost : ");
        System.out.println("RS "+sum);

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
                return ;
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