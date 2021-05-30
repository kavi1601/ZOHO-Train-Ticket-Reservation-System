
package trainticket;

import java.util.ArrayList;
import java.util.Scanner;

public class CancelTicket extends Datas
{
    Scanner sc=new Scanner(System.in);
    
    public void cancel(ArrayList<ArrayList> train,int[] chart,ArrayList<ArrayList> waiting,ArrayList waitchart,int pnr)
    {
        int ind=0,wcind=0,f=0;
        
        while(wcind<waiting.size())
        {
            
            if((int)waiting.get(wcind).get(0)==pnr)
            {
                ArrayList t=waiting.get(0);
                System.out.printf("From :%s\nTo :%s\nPNR Number is :%d\tTrain No is:%d\nPassanger Name is :%s\tSeat Number: %d\n****Status : Cancel ****\n",t.get(2),t.get(3),t.get(0),t.get(1),t.get(4),t.get(5));
                waiting.remove(0);
                f+=1;
                waitchart.remove(wcind);
                wcind--;
            }
            wcind++;
        }
        
        while(ind<train.size())
        {
            if((int)train.get(ind).get(0)==pnr)
            {
                ArrayList t=train.get(ind);
                System.out.printf("From :%s\nTo :%s\nPNR Number is :%d\tTrain No is:%d\nPassanger Name is :%s\tSeat Number: %d\n****Status : Cancel****\n",t.get(2),t.get(3),t.get(0),t.get(1),t.get(4),t.get(5));
                int index=(int)train.get(ind).get(5);
                chart[index-1]=0;
                f+=1;
                train.remove(ind);
                if(waiting.size()!=0)
                {
                    waiting.get(0).set(5, index); 
                    waiting.get(0).set(6,"Confirm");
                    train.add(ind,waiting.get(0)); 
                    waiting.remove(0); 
                    waitchart.remove(0);
                    chart[index-1]=1;
                }  
                else
                {
                    ind--;
                }
            }
            ind++;
        }
        if(f!=0) 
            System.out.println("Your Ticket Cancelled Successfully");
    }
    
    public void cancelTicket()
    {
        System.out.println("Enter your PNR");
        int pnr=sc.nextInt(); 
        if(pnr<=tc && tc!=0)
        {   
            cancel(train1,chart1,waiting1,waitchart1,pnr);
            cancel(train2,chart2,waiting2,waitchart2,pnr);

        }
        else
        {
            System.out.println("PNR is Invalid");
        }
    }
}
