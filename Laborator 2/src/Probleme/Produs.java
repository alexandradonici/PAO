package Probleme;

public class Produs
{
    private String nume;
    private double pret;
    private int cantitate;

    Produs()
    {
        this("Default",0,0);
    }

    Produs(String n, double p, int c)
    {
        this.nume=n;
        this.pret=p;
        this.cantitate=c;
    }

    public String toString()
    {
        String print="";
        print+= "Produs: "+ this.nume+" pret: " + this.pret + " cantitate: "+ this.cantitate;
        return print;
    }

    public double getTotalProdus()
    {
        double pret_total=0.0;
        pret_total=this.pret*this.cantitate;
        return pret_total;
    }

}
