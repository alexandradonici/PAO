package Probleme;

public class Magazin
{
    private String nume;
    private Produs p1,p2,p3;

    Magazin(String n, Produs p1, Produs p2, Produs p3)
    {
        this.nume=n;
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
    }

    public String toString()
    {
     String print= "Magazin: "+ this.nume+"\n"+p1+"\n"+p2+"\n"+p3;
     return print;

    }

    public double getTotalMagazin()
    {
        double sum=p1.getTotalProdus()+p2.getTotalProdus()+p3.getTotalProdus();
        return sum;
    }

    public static void main(String[] args) {
        Magazin magazin = new Magazin("Aprozar",new Produs("Mere",3,100),new Produs("Portocale",5,150),new Produs("Kiwi",10,30));
        System.out.println(magazin);
        System.out.println(magazin.getTotalMagazin());
    }

}
