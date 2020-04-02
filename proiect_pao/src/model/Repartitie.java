package model;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Repartitie
{
    private static int id=0;
    private int id_repartitie;
    private Candidat candidat;
    private Specializare specializare;
    private MedieAdmitere medie_admitere;

    public Repartitie(Candidat candidat, Specializare specializare, MedieAdmitere medie_admitere)
    {
        this.candidat = candidat;
        this.specializare = specializare;
        this.medie_admitere=medie_admitere;
        this.id_repartitie=++id;
    }

    public Candidat getCandidat()
    {
        return candidat;
    }

    public Specializare getSpecializare()
    {
        return specializare;
    }

    public MedieAdmitere getMedie_admitere()
    {
        return medie_admitere;
    }

    public int getId_repartitie()
    {
        return id_repartitie;
    }

    public void setCandidat(Candidat candidat)
    {
        this.candidat = candidat;
    }

    public void setSpecializare(Specializare specializare)
    {
        this.specializare = specializare;
    }

    public void setMedie_admitere(MedieAdmitere medie_admitere)
    {
        this.medie_admitere = medie_admitere;
    }

    @Override
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);
        String ma = df.format(medie_admitere.getMedie_admitere());
        return "Repartitie{" +
                "id_repartitie=" + id_repartitie +
                ", candidat=" + candidat +
                ", specializare=" + specializare.getNume() +
                ", medie_admitere=" + ma +
                '}';
    }
}
