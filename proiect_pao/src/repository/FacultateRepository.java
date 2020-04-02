package repository;

import model.Facultate;
import model.FacultateCuAdmitere;
import model.FacultateFaraAdmitere;

import java.util.ArrayList;

public class FacultateRepository
{
    private ArrayList<Facultate> facultati;

    public FacultateRepository()
    {
        facultati= new ArrayList<>();
    }

    public void add(Facultate facultate)
    {
        facultati.add(facultate);
    }

    public void remove(int id)
    {
        for(int i=0;i<facultati.size();i++)
            if(facultati.get(i).getId_facultate()==id)
                facultati.remove(i);
    }

    public void removeByName(String nume)
    {
        for(int i=0;i<facultati.size();i++)
            if(facultati.get(i).getNume()==nume)
                facultati.remove(i);

    }

    public Facultate getFacultateNume(String nume)
    {
        for(Facultate facultate : facultati)
            if(facultate.getNume()==nume)
                return facultate;

        return null;
    }


    public ArrayList<FacultateCuAdmitere> getFacultatiCuAdmitere()
    {
        ArrayList<FacultateCuAdmitere> facultati_cu_admitere = new ArrayList<FacultateCuAdmitere>();

        for(Facultate facultate : facultati)
            if(facultate instanceof FacultateCuAdmitere)
                facultati_cu_admitere.add((FacultateCuAdmitere)facultate);

         return facultati_cu_admitere;
    }

    public ArrayList<FacultateFaraAdmitere> getFacultatiFaraAdmitere()
    {
        ArrayList<FacultateFaraAdmitere> facultati_fara_admitere = new ArrayList<FacultateFaraAdmitere>();

        for(Facultate facultate : facultati)
            if(facultate instanceof FacultateFaraAdmitere)
                facultati_fara_admitere.add((FacultateFaraAdmitere)facultate);

        return facultati_fara_admitere;
    }

    public ArrayList<Facultate> getFacultati()
    {
        return facultati;
    }

    public void AfisFacultati()
    {
        for(Facultate facultate:facultati)
            System.out.println(facultate);
    }

    public void AfisFacultatiCuAdmitere()
    {
        ArrayList<FacultateCuAdmitere> facultatiCuAdmitere=getFacultatiCuAdmitere();
        for(FacultateCuAdmitere facultate:facultatiCuAdmitere)
            System.out.println(facultate);
    }

    public void AfisFacultatiFaraAdmitere()
    {
        ArrayList<FacultateFaraAdmitere> facultatiFaraAdmitere=getFacultatiFaraAdmitere();
        for(FacultateFaraAdmitere facultate:facultatiFaraAdmitere)
            System.out.println(facultate);
    }


}
