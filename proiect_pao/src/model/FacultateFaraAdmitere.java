package model;

public class FacultateFaraAdmitere extends  Facultate
{
    public FacultateFaraAdmitere(String nume)
    {
        super(nume);
    }

    public double calculMedieAdmitere(MedieAdmitere medie)
    {
        double ma=medie.getBac().getMedieBac();
        return ma;
    }
}
