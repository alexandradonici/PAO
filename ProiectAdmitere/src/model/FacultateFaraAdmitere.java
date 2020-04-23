package model;

public class FacultateFaraAdmitere extends  Facultate
{
    public FacultateFaraAdmitere(String nume)
    {
        super(nume);
    }

    public FacultateFaraAdmitere(int id_facultate, String nume)
    {
        super(id_facultate, nume);
    }

    public double calculMedieAdmitere(Bacalaureat bacalaureat, ExamenAdmitere examenAdmitere)
    {
        double ma=bacalaureat.getMedieBac();
        return ma;
    }
}
