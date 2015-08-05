
import java.util.*;
import java.io.*;
class Money
{
    protected double val;
    protected boolean golden;
    protected boolean autograph;
    public Money(double v)
    {
        val=v;
    }
    public double getTrueValue()
    {
        if(golden)
        {
            return val+20;
        }
        else if(autograph)
        {
            return val+10;
        }
        else
            return val;
    }
}
class Coin extends Money
{
    Coin(double val,boolean g)
    {
        super(val);
        golden=g;
    }

}
class RealPaper extends Money
{
    RealPaper(double val,boolean real)
    {
        super(val);
        autograph=real;
    }

}
class FakePaper extends Money
{
    FakePaper(double val,boolean fake)
    {
        super(val);
        autograph=fake;
    }
    public double getTrueValue()
    {
        return 0;
    }

}
class wallet
{
    protected Money[] money;
    private int i;
    private double totalVal;
    wallet()
    {
        money=new Money[100];
        i=0;
        totalVal=0;
    }
    public void addMoney(double n,boolean p,boolean RealOrFake)
    {
        if(RealOrFake)
        {
            money[i++]=new RealPaper(n,RealOrFake);
        }
        if(!RealOrFake)
        {
            money[i++]=new FakePaper(n,RealOrFake);
        }
    }
    public void addMoney(boolean p,double n)
    {

        money[i++]=new Coin(n,p);

    }
    public double gelTotalValue()
    {
        int in;
        for(in=0; in<i; in++)
        {
            totalVal+=money[i].getTrueValue();
        }
        return totalVal;
    }

    public void printSummary()
    {
        String main;
        for(int in = 0 ; in < i; in++)
        {
            Money p = money[i];
            if(p instanceof Coin)
            {
                if(p.golden)
                {
                    main = String.format( "a %.2f dollar golden coin worth %.2f dollars.",p.val,p.getTrueValue());
                }
                else
                    main = String.format( "a %.2f dollar coin worth %.2f dollars.",p.val,p.getTrueValue());
            }
            else if(p instanceof RealPaper)
            {
                if(p.autograph)
                {
                    main = String.format("an authentic autographed %.2f dollar bill worth %.2f dollars.",p.val,p.getTrueValue());
                }
                else main = String.format("an authentic %.2f dollar bill worth %.2f dollars",p.val,p.getTrueValue());
            }
            else
            {
                if(p.autograph)
                    main = String.format("a counterfeit autographed %.2f dollar bill worth 0 dollars.",p.val,p.getTrueValue());
                else
                    main = String.format("a counterfeit %.2f dollar bill worth %.2f dollars",p.val,p.getTrueValue());
            }
            System.out.println("Object #"+(in+1)+" is "+main);
        }
    }
}


public class Assignment2
{


    public static void main(String[] args)
    {
        FileReader fp = null;
        String st,form,stype;
        double value;
        wallet wat=new wallet();
        boolean valIncre,realFake;
        try
        {
            fp = new FileReader("input.txt");
        }
        catch(Exception e)
        {
            System.out.println("input error");
        }
        Scanner ch = new Scanner(fp);
        while(ch.hasNextLine())
        {
            String p=null;
            realFake = false;
            valIncre = false;
            st = ch.nextLine();

            if(st== null)
            {
                break;
            }
            Scanner newch = new Scanner(st);
            form = newch.next();
            value = newch.nextInt();
            if(newch.hasNext())
            {
                stype = newch.next();
                if(stype.equals("autographed")||stype.equals("gold"))
                {
                    valIncre = true;
                }
                else if(stype.equals("authentic"))
                {
                    valIncre = false;
                    realFake=true;
                }
                if(newch.hasNext())
                {
                    p = newch.next();
                    if(p.equals("authentic"))
                        realFake= true;
                    else {
                        valIncre=false;
                        realFake = false;
                    }
                }

            }
            if(p!= null)
            {
                wat.addMoney(value,valIncre,realFake);
            }
            else
                wat.addMoney(valIncre,value);
        }
        wat.printSummary();
        System.out.println("Total value is "+wat.gelTotalValue());
    }
}