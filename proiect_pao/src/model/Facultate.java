package model;

public abstract class Facultate
{
    private String nume;
    private static int id = 0;
    private int id_facultate;

    public Facultate(String nume)
    {
        this.nume = nume;
        this.id_facultate = ++id;
    }

    public String getNume()
    {
        return nume;
    }

    public abstract double calculMedieAdmitere(MedieAdmitere medie);

    public int getId_facultate()
    {
        return id_facultate;
    }

    public void setNume(String nume)
    {
        this.nume = nume;
    }

    @Override
    public String toString()
    {
        return "Facultate{" +
                "nume='" + nume + '\'' +
                ", id_facultate=" + id_facultate +
                '}';
    }
}
