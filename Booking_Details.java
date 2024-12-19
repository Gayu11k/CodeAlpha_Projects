import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Booking_Details{
  //To View Booking Details 
  public void viewBookingDetails(){

    System.out.println("Booking Details are as follows");
    try{
        
        Class.forName("com.mysql.cj.jdbc.Driver");//connection String to create Driver for creating connection betn SQL and  JDBC
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation_sys","root","Myuser@30");
        Statement smt=con.createStatement();
        ResultSet rs= smt.executeQuery("SELECT * FROM reservation");

        System.out.println(" Customer Name \t\tCustomer Id \tRoom Number \tDuration \t\tDate \t\tCheck-In \tCheck-Out");
        while(rs.next()){
            //next move the curser from one row to next
           String customer_name =rs.getString(1);
           int customer_id=rs.getInt(2);
           int room_number =rs.getInt(3);
           String duration=rs.getString(4);
           java.sql.Date date=rs.getDate(5);
            double checkIn=rs.getDouble(6);
            double checkOut=rs.getDouble(7);

           System.out.print("\t"+customer_name);
           System.out.print("\t\t"+customer_id);
           System.out.print("\t\t"+room_number);
           System.out.print("\t\t"+duration);
           System.out.print("\t\t\t"+date);
           System.out.print("\t"+checkIn);
           System.out.print("\t\t"+checkOut);
           System.out.println();
        }
        System.out.println();
        con.close();
    }
    catch(Exception e)
    {
        System.out.println("Somthing went wrong please try again");
    }  
}

}