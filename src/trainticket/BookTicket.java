
package trainticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BookTicket extends Datas
{
    Scanner sc=new Scanner(System.in);
    public int count(int[] l)
    {
        int ct=0; 
        for(int i:l)
        {
            if(i==1)
                ct+=1;
        }
        return ct;
    }
   
    public void booking(ArrayList<ArrayList> train,int[] chart,ArrayList<ArrayList> waiting,ArrayList<Integer> waitchart,ArrayList pas)
    {
        int seatNo;
        System.out.println("Occupied Chart\n"+Arrays.toString(chart));
        if(count(chart)!=8)
        {
         
            System.out.println("Book the Seat No");
            seatNo=Integer.parseInt(sc.nextLine());
            while((seatNo<=0 || seatNo>8) || (seatNo<9 && seatNo>0 && chart[seatNo-1]!=0))
            {
                if(seatNo<=0 || seatNo>8)
                    System.out.println("Seat Number is Only 1 to 8");
                else
                    System.out.println("Seat Occupied");
                seatNo=Integer.parseInt(sc.nextLine());
            }
            pas.add(seatNo);
            pas.add("Confirm");
            chart[seatNo-1]=1;
            train.add(pas);
        }
        else
        {
            if(waitchart.size()<2)
            {
                pas.add(0);
                pas.add("Waiting");
                waiting.add(pas); 
                waitchart.add(1);
            }
            else
            {
                System.out.println("Tickets Not Available");
            }
        }
    }

    public void bookTicket()
    {
        ArrayList<Object> pas;
        String From,To,Name;
        int count,tr1=0,tr2=0;
        
        System.out.println("Entered how many tickets are you want to book");
        count =Integer.parseInt(sc.nextLine());
        Datas.tc+=1;
        
        System.out.println("From Location");
        From = sc.nextLine();
        System.out.println("To Location");
        To = sc.nextLine(); 
        
        if(From.length()==0 || To.length()==0)
        {
            System.out.println("You doesn't mension your boarding point or destination point");
        }
        else 
        {
            int f=0;
            if(From.equals(To))
            {
                System.out.println("Route is not Available");tc-=1;
                f=1;
            }
            if("ABCD".contains(From) && "BCDE".contains(To) && count>(8-train1.size())+(2-waiting1.size()))
            {
                System.out.println("Ticket is Not Available");f=1;
            }
            
            if("XY".contains(From) && ("DE").contains(To) && (count>(8-train1.size())+(2-waiting1.size()) || count>(8-train2.size())+(2-waiting2.size())))
            {
                System.out.println("Ticket is Not Available");f=1;
            }
            
            if("XY".contains(From) && ("YC").contains(To) && count>(8-train2.size())+(2-waiting2.size()))
            {
                System.out.println("Ticket is Not Available");f=1;
            }
            
            if(f==0)
            {
                for(int i=0;i<count;i++)
                {
                    pas=new ArrayList<>();
                    pas.add(tc);
                    System.out.println("Passanger Name");
                    Name =sc.nextLine();
                    if("ABCD".contains(From) && "BCDE".contains(To))
                    {
                        pas.add(1);
                        pas.add(From);
                        pas.add(To);
                        pas.add(Name);
                        System.out.println("\nEnter SeatNo in Train1");
                        booking(train1,chart1,waiting1,waitchart1,pas);
                        tr1=1; 
                    }
                    else if("XY".contains(From))
                    { 
                        if("YCDE".contains(To))
                        {
                            pas.add(2);
                            pas.add(From);
                            if(To.equals("Y"))
                                pas.add(To);
                            else 
                                pas.add("C");
                            pas.add(Name);
                            System.out.println("\nEnter SeatNo in Train2");
                            booking(train2,chart2,waiting2,waitchart2,pas);   
                            tr2=1;
                        }
                        if("DE".contains(To))
                        {
                            pas=new ArrayList<>();
                            pas.add(tc);
                            pas.add(1);
                            pas.add("C");
                            pas.add(To);
                            pas.add(Name);
                            System.out.println("\nEnter SeatNo in Train1");
                            booking(train1,chart1,waiting1,waitchart1,pas);
                            tr1=1;
                        }
                    }
                    
                    else
                    {
                        System.out.println("Route is not Available");tc-=1;
                        break;
                    }
                }
            }
        }
        //System.out.printf("%d %d",tr1,tr2);
        if(tr1!=0 || tr2!=0)
        {
            System.out.println("\nBookTicket Successfully\n");
        }
        if(tr1==1)
        {
            View.printTicket(tc,train1,waiting1);
        }
        if(tr2==1)
        {
            View.printTicket(tc,train2,waiting2);
        }
    }
}
