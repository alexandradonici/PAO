package model;

public class FacultateCuAdmitere extends Facultate
{
    public FacultateCuAdmitere(String nume)
    {
        super(nume);
    }

    public FacultateCuAdmitere(int id_facultate, String nume)
    {
        super(id_facultate, nume);
    }

    public double calculMedieAdmitere(Bacalaureat bacalaureat, ExamenAdmitere examenAdmitere)
    {
        double ma=examenAdmitere.getNotaExamen()*80/100+bacalaureat.getMedieBac()*20/100;
        return ma;
    }
}
