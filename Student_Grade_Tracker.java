import java.util.*;

public class Student_Grade_Tracker{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int std_count,i,grade;
        System.out.println("Enter sudent count");
        std_count=sc.nextInt();

        double grades[]=new double[std_count];
       
        for( i=0;i<std_count;i++ ){

            System.out.println("Enter student "+(i+1)+" grades");
            grade=sc.nextInt();
            if(grade <0 || grade >100){
                System.out.println("Invalid Grade");
                break;
            }
            else
            {
            grades[i]=grade; 
            } 
            sc.close();
        }
        
        double total=0,heighest=grades[0],lowest=grades[0],average ;

        for(int j=0;j<grades.length;j++){

            total=total+grades[j];

            if(grades[j] < lowest){
                lowest=grades[j];
            }
            if(grades[j]  >  heighest){
                heighest=grades[j];
            }
        }
        

        average=total/std_count;

        System.out.println("\nTotal= "+total);
        System.out.println("Average= "+average);
        System.out.println("Heighest Grade= "+heighest);
        System.out.println("Lowest Grade= "+lowest);
        
       
    }
}