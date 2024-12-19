import java.util.*;
public class Hotel_Reservation_System{
    
     Check_Available ca=new Check_Available();
     Reservation rs=new Reservation();
     Booking_Details book=new Booking_Details();
    //To take Choice From User
    Scanner sc= new Scanner(System.in);
    
    void hotel(){

        int choice ;
        System.out.println("\t\t \1 \1 \1 Welcome to Hotel Reservation System \1 \1 \1 \n\nHow can i help you? ");
        do{
        System.out.println("\4Press 1 to check Available Rooms\n\4Press 2 to make Reservation\n\4Press 3 to View Booking Details\n\4Press 4 to Exit ");
        choice=sc.nextInt();       
        switch (choice) {
            case 1:
                ca.isAvailable();
                break;
            case 2:
                rs.makeReservation();
                break;
            case 3:
                book.viewBookingDetails();
                break;
            case 4:
                System.out.println("Thank You ! ");
                break;
            default:
                System.out.println("Worng value! Please press valid button ");
                break;
        }
    }while(choice!=4);
    }
    public static void main(String args[]){
        Hotel_Reservation_System hrs=new Hotel_Reservation_System();
        hrs.hotel();

    }
}