package Scoala;

public class Catalog
{
    private String grupa;
    Student s1,s2,s3,s4,s5;

    Catalog(String gr, Student s1,Student s2,Student s3,Student s4,Student s5)
    {
        this.grupa=gr;
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        this.s4=s4;
        this.s5=s5;
    }

    public double  getMedieClasa()
    {
        return (s1.getMedieAn1()+s2.getMedieAn1()+s3.getMedieAn1()+s4.getMedieAn1()+s5.getMedieAn1())/5;
    }

    public String toString()
    {
        String print="GRUPA "+grupa+s1+s2+s3+s4+s5;
        return print;
    }

    public static void main(String[] args)
    {
        Catalog c= new Catalog("244", new Student("Ion",9.4,9.6), new Student("Mihai",6.4,7.8),new Student("Caatalin",10,9.9),new Student("Mihaela",8.2,7.5), new Student("Raul",10,10));
        System.out.println(c);
        System.out.println(c.getMedieClasa());
    }

}
