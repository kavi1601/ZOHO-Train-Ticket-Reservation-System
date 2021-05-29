
package trainticket;

import java.util.Scanner;

public class TicketRservationSystem 
{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) 
    {
         
        boolean end=false;
        while(!end)
        {
            System.out.println("1:BookTicket 2:CancelTicket 3:View 4:Exit\n");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1 ->new BookTicket().bookTicket(); 
                
                case 2 ->new CancelTicket().cancelTicket(); 
                
                case 3 -> new View().method();
                
                case 4 -> System.exit(0);
                
                case 5-> new Datas().method(); 
                
                default -> {break;}
            }
        }
    }
    
}
