package model;

public class ExamenAdmitere
{
    private double notaExamen;
    private String salaExamen;

    public ExamenAdmitere( String salaExamen)
    {
        this.notaExamen = 0;
        this.salaExamen = salaExamen;
    }

    public double getNotaExamen()
    {
        return notaExamen;
    }

    public String getSalaExamen()
    {
        return salaExamen;
    }

    public void setNotaExamen(double notaExamen)
    {
        this.notaExamen = notaExamen;
    }

    public void setSalaExamen(String salaExamen)
    {
        this.salaExamen = salaExamen;
    }

    @Override
    public String toString()
    {
        return "ExamenAdmitere{" +
                "notaExamen=" + notaExamen +
                ", salaExamen='" + salaExamen + '\'' +
                '}';
    }
}
