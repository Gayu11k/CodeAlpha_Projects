import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Reservation{
    Scanner sc=new Scanner(System.in);
    int res_room,avail=0;
//To book the room 
public void makeReservation(){
    try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation_sys","root","Myuser@30");
         PreparedStatement psmt=con.prepareStatement("insert into reservation values(?,?,?,?,?,?,?)");
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            
            System.out.println("Enter Customer name : ");
            String cust_name=br.readLine();
            
            System.out.println("Enter Customer Id: ");
            int cust_id =Integer.parseInt(br.readLine());
            
            System.out.println("Enter Room number: ");
            res_room=Integer.parseInt(br.readLine());
            
            isRoomAvailable();
            
            if(avail==1){
                System.out.println("Try Again");
            }
            else{
                System.out.println("Enter stay duration: ");
                String time=br.readLine();
            
                System.out.println("Enter stay date (yyyy-mm-dd): ");
                String stay_date=sc.next();
                java.sql.Date date=java.sql.Date.valueOf(stay_date);

                System.out.println("Enter Check-In time");
                double checkIn=Double.parseDouble(br.readLine());

                System.out.println("Enter Check-Out time");
                double checkOut=Double.parseDouble(br.readLine());
    
                psmt.setString(1,cust_name); 
                psmt.setInt(2,cust_id); 
                psmt.setInt(3,res_room); 
                psmt.setString(4,time);
                psmt.setDate(5,date);
                psmt.setDouble(6, checkIn);
                psmt.setDouble(7, checkOut);
        
                int count = psmt.executeUpdate();
                if(count>0){
                    System.out.println( "Room is reserved");
                }
                else{
                System.out.println("Please Try Again");
                }
                System.out.println("Do you want to insert more record (y/n)");
                String choice=br.readLine();
            
                if(choice.equalsIgnoreCase("n"))
                break;
            }
        }
    }  
       catch(Exception e){
            System.out.println("Enter valid details");
        }
}
void isRoomAvailable(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation_sys","root","Myuser@30");
        PreparedStatement psmt=con.prepareStatement("UPDATE rooms SET availability = 'unavailable' WHERE room_no=?");
        Statement smt=con.createStatement();
        ResultSet rs= smt.executeQuery("SELECT room_no FROM rooms WHERE availability= 'unavailable' ");
        while(rs.next()){

            int roomno =rs.getInt(1);
            if(res_room==roomno){
                System.out.println("Room is not Available.");
                avail=1;
                break;
            }
            else{
                psmt.setInt(1,res_room);
                psmt.executeUpdate();
            }
        }
    }
    catch(Exception e){
        System.out.println("Enter Valid Details");
    }
    }
}