package model;

public class FacultateCuAdmitere extends Facultate
{
    public FacultateCuAdmitere(String nume)
    {
        super(nume);
    }

    public double calculMedieAdmitere(MedieAdmitere medie)
    {
        double ma=medie.getAdmitere().getNotaExamen()*80/100+medie.getBac().getMedieBac()*20/100;
        return ma;
    }
}
