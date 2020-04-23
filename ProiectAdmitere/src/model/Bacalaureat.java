package model;

public class Bacalaureat
{
    private double notaP1;
    private double notaP2;
    private double notaP3;
    private double medieBac;

    public Bacalaureat(double notaP1, double notaP2, double notaP3)
    {
        this.notaP1 = notaP1;
        this.notaP2 = notaP2;
        this.notaP3 = notaP3;
        this.medieBac = (notaP1+notaP2+notaP3)/3;
    }

    public double getNotaP1()
    {
        return notaP1;
    }

    public double getNotaP2()
    {
        return notaP2;
    }

    public double getNotaP3()
    {
        return notaP3;
    }

    public double getMedieBac()
    {
        return medieBac;
    }

    public void setNotaP1(double notaP1)
    {
        this.notaP1 = notaP1;
    }

    public void setNotaP2(double notaP2)
    {
        this.notaP2 = notaP2;
    }

    public void setNotaP3(double notaP3)
    {
        this.notaP3 = notaP3;
    }

    public void setMedieBac(double medieBac)
    {
        this.medieBac = (notaP1+notaP2+notaP3)/3;
    }

    @Override
    public String toString()
    {
        return "Bacalaureat{" +
                "notaP1=" + notaP1 +
                ", notaP2=" + notaP2 +
                ", notaP3=" + notaP3 +
                ", medieBac=" + medieBac +
                '}';
    }
}
