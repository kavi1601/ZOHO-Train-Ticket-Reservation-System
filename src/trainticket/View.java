
package trainticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class View extends Datas
{
    Scanner sc=new Scanner(System.in);
    static int f;
    public static void printTicket(int pnr,ArrayList<ArrayList> train,ArrayList<ArrayList> waiting)
    {
        for(ArrayList t:train)
        {
            if((int)t.get(0)==pnr)
            {
                System.out.printf("From :%s\nTo :%s\nPNR Number is :%d\tTrain No is:%d\nPassanger Name is :%s\tSeat Number: %d\n****Status : %s****\n",t.get(2),t.get(3),t.get(0),t.get(1),t.get(4),t.get(5),t.get(6));
                f+=1;
                
            }
        }
        
        for(ArrayList t:waiting)
        {
            if((int)t.get(0)==pnr)
            {
                System.out.printf("From :%s\nTo :%s\nPNR Number is :%d\tTrain No is:%d\nPassanger Name is :%s\tSeat Number: %d\n****Status : %s****\n",t.get(2),t.get(3),t.get(0),t.get(1),t.get(4),t.get(5),t.get(6));
                
                f+=1;
            }
        }             
    }
    
    @Override
    public void method()
    {
        System.out.println("1:Occupancy Chart OR 2:Print Ticket");
        int viewOption=Integer.parseInt(sc.nextLine());
        if(viewOption==1)
        {
            System.out.println("Enter your train No");
            int trainNo=Integer.parseInt(sc.nextLine());
            System.out.printf("******* Chart Details Train No:%d *******\n",trainNo);
            if(trainNo==1)
                System.out.println("Occupancy Chart\n"+Arrays.toString(chart1)+"\nWaiting Chart\n"+waitchart1);
            else if(trainNo==2)
                System.out.println("Occupancy Chart\n"+Arrays.toString(chart2)+"\nWaiting Chart\n"+waitchart2);
            else
                System.out.println("Train is not runned");
        }
        else if(viewOption==2)
        {
            f=0;
            System.out.println("Enter Your PNR");
            int pnr=Integer.parseInt(sc.nextLine()); 
            if(pnr<=tc && tc!=0)
            {
                printTicket(pnr,train1,waiting1); 
                printTicket(pnr,train2,waiting2);
                if(f==0)
                {
                    System.out.println("Your Ticket is Cancelled");
                }
            }
            else
            {
                System.out.println("PNR is Invalid");
            }
        }
        else 
            System.out.println("Invalid Input\n'Input Only 1 OR 2'");
    }
}
