package geometry;

public class Punct
{
    private int x,y;

    Punct()
    {
        this.x=0;
        this.y=0;
    }

    Punct(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public int getX()
    {
        return this.x;
    }

    public void setX(int x)
    {
        this.x=x;
    }

    public int getY()
    {
        return this.y;
    }

    public void setY(int y)
    {
        this.y=y;
    }

    public String toString()
    {
        String print="";
        print+="("+this.x+","+this.y+") ";
        return print;
    }

    public double distance(int x, int y)
    {
        double dist=0;
        dist=Math.sqrt(Math.pow(this.x-x,2)+Math.pow(this.y-y,2));
        return dist;

    }

    public double distance(Punct p)
    {
        return distance(p.x, p.y);
    }
}
