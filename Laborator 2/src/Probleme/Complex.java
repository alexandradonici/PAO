package Probleme;

public class Complex
{
    double reala;
    double imaginara;

    Complex(double x, double y)
    {
        this.reala=x;
        this.imaginara=y;
    }

    Complex()
    {
       this(0,0);
    }

    public Complex sum(Complex x)
    {
        Complex s=new Complex();
        s.reala=this.reala+x.reala;
        s.imaginara=this.imaginara+x.imaginara;
        return s;
    }

    public String toString()
    {
        String print="";
        print+=this.reala;
        if(this.imaginara!=0.0)
            print+=" + "+this.imaginara+"i ";
        return print;

    }

    public boolean equals(Complex x)
    {
        if(reala==x.reala && imaginara==x.imaginara)
            return true;
        return false;
    }
    public static void main(String[] args)
    {
        Complex x1 = new Complex(3,5);
        Complex x2 = new Complex(3,5);
        Complex x3 = new Complex();
        System.out.println(x1.toString()+" "+ x3);
        System.out.println(x1.equals(x2));
        System.out.println(x1.equals(x3));
        System.out.println(x1.sum(x2));
    }
}
