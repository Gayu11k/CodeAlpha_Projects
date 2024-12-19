
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Check_Available{
    //This Function Returns The Available Room From DB
public void isAvailable(){

    System.out.println("Available Rooms Are: ");
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation_sys","root","Myuser@30");
        Statement smt = con.createStatement();
        ResultSet rs= smt.executeQuery("SELECT room_no,ac_nonac,price FROM rooms WHERE availability= 'available' ");

        System.out.println(" Room Number \tAC/Non-Ac \tPrice");
        while(rs.next()){
            //next move the curser from one row to next
           int roomno =rs.getInt(1);
           String ac=rs.getString(2);
           int price =rs.getInt(3);
           
           System.out.print("\t"+roomno);
           System.out.print("\t "+ac);
           System.out.print("\t\t"+price);
           System.out.println();
        }
        System.out.println();
        con.close();
    }
    catch(Exception e)
    {
        System.out.println("Something went wrong please try again");
    }
}
}