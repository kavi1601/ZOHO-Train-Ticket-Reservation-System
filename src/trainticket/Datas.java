
package trainticket;

import java.util.ArrayList;

public class Datas 
{
    protected static ArrayList<ArrayList> train1=new ArrayList<ArrayList>(); 
    protected static int chart1[]={0,0,0,0,0,0,0,0};
    protected static ArrayList<ArrayList> waiting1= new ArrayList<ArrayList>(); 
    protected static ArrayList<Integer> waitchart1=new ArrayList<>();
    
    protected static ArrayList<ArrayList> train2=new ArrayList<ArrayList>();
    protected static int chart2[]={0,0,0,0,0,0,0,0};
    protected static ArrayList<ArrayList> waiting2= new ArrayList<ArrayList>();
    protected static ArrayList<Integer> waitchart2=new ArrayList<>();
  
    protected static int tc=0;

    public void method()
    {
        for(ArrayList t:train1)
            System.out.println(t);
        for(ArrayList t:waiting1)
            System.out.println("Waiting List Details "+t);
        for(ArrayList t:train2)
            System.out.println(t);
        for(ArrayList t:waiting2)
            System.out.println("Details"+t);
    }
    
}
