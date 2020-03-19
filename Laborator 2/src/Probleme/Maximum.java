package Probleme;

public class Maximum
{

    int nr;
    Maximum()
    {
        this.nr=0;
    }

    Maximum(int x)
    {
        this.nr=x;
    }

    public int maxim(int a)
    {
        if(nr>a)
            return nr;
        else
            return a;
    }



    public int maxim(int a, int b)
    {
        int max;
        Maximum m=new Maximum();
        m.nr=a;
        max=m.maxim(b);
        return maxim(max);
    }

    public int maxim(int a, int b, int c)
    {
        int max;
        Maximum m=new Maximum();
        m.nr=a;
        max=m.maxim(b);
        m.nr=max;
        max=m.maxim(c);
        return maxim(max);
    }

    public int maxim(int a, int b, int c, int d)
    {
        int max;
        Maximum m=new Maximum();
        m.nr=a;
        max=m.maxim(b);
        m.nr=max;
        max=m.maxim(c);
        m.nr=max;
        max=m.maxim(d);
        return maxim(max);
    }



    public static void main(String[] args) {

    Maximum m = new Maximum(1);
    int x=5, y=12, z=15, t=2;

    int max=m.maxim(x);
    System.out.println(max);

    max=m.maxim(x,y);
    System.out.println(max);

    max=m.maxim(x,y,z);
    System.out.println(max);

    max=m.maxim(x,y,z,t);
    System.out.println(max);
    }
}
