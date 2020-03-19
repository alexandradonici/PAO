package Facultate;

public class Student
{
    private String nume, prenume;
    public static int contor=0;

    Student(String n, String p)
    {
        this.nume=n;
        this.prenume=p;
        contor++;
    }
    public String toString()
    {
        String print="Nume: "+this.nume+" Prenume: "+this.prenume;
        return print;
    }

    public static void main(String[] args)
    {
        Student[] s= new Student[5];
        s[0]=new Student("Popescu", "Ion");
        s[1]=new Student("Ionescu", "Mihai");
        s[2]=new Student("Mircea", "Ioana");
        s[3]=new Student("Aanei", "Cristina");
        s[4]=new Student("Ciocan", "Mihnea");

        for(Student i : s)
            System.out.println(i+"\n");

        System.out.println("Numar srudenti: " +Student.contor);

    }
}
