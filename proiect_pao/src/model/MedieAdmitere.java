package model;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MedieAdmitere
{
    private ExamenAdmitere admitere;
    private Bacalaureat bac;
    private double medie_admitere;

    public MedieAdmitere(Bacalaureat bac,ExamenAdmitere admitere)
    {
        this.admitere = admitere;
        this.bac = bac;
        this.medie_admitere = 0;
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
