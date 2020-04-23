package model;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MedieAdmitere
{
    private ExamenAdmitere admitere;
    private Bacalaureat bac;
    private static int id = 0;
    private double medie_admitere;
    private int id_medie;
    private Facultate facultate;

    public MedieAdmitere(Bacalaureat bac,ExamenAdmitere admitere,Facultate facultate)
    {
        this.facultate = facultate;
        this.admitere = admitere;
        this.bac = bac;
        if(admitere.getNotaExamen()!=0)
        this.medie_admitere = facultate.calculMedieAdmitere(bac, admitere);
        else
            this.medie_admitere = 0;
        this.id_medie = ++id;
    }

    public MedieAdmitere(int id_medie, Bacalaureat bac,ExamenAdmitere admitere,Facultate facultate)
    {
        this.facultate = facultate;
        this.admitere = admitere;
        this.bac = bac;
        if(admitere.getNotaExamen()!=0)
            this.medie_admitere = facultate.calculMedieAdmitere(bac, admitere);
        else
            this.medie_admitere = 0;
        this.id_medie = id_medie;

        if(id_medie > id)
            id = id_medie;
    }

    public ExamenAdmitere getAdmitere()
    {
        return admitere;
    }

    public Bacalaureat getBac()
    {
        return bac;
    }

    public double getMedie_admitere()
    {
        return medie_admitere;
    }

    public void setAdmitere(ExamenAdmitere admitere)
    {
        this.admitere = admitere;
    }

    public void setBac(Bacalaureat bac)
    {
        this.bac = bac;
    }

    public void setMedie_admitere(double medie_admitere)
    {
        this.medie_admitere = medie_admitere;
    }

    public Facultate getFacultate() {
        return facultate;
    }

    public void setFacultate(Facultate facultate) {
        this.facultate = facultate;
    }

    public int getId_medie() {
        return id_medie;
    }

    public void setId_medie(int id_medie) {
        this.id_medie = id_medie;
    }

    @Override
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);
        String ma = df.format(medie_admitere);
        return "MedieAdmitere{" +
                "admitere=" + admitere +
                ", bac=" + bac +
                ", medie_admitere=" + ma +
                '}';
    }
}
