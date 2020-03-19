package Scoala;

public class Student
{
    private String nume;
    private double medieSem1, medieSem2;

    Student(String n, double m1, double m2)
    {
        this.nume=n;
        this.medieSem1=m1;
        this.medieSem2=m2;
    }

    public String toString()
    {
        String print="Nume: "+this.nume+" Medie semestrul 1: "+this.medieSem1+ " Medie semestrul 2: "+this.medieSem2+"\n";
        return print;

    }


    public double getMedieAn1()
    {
        return (medieSem1+medieSem2)/2;
    }
}
