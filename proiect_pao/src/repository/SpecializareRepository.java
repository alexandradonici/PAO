package repository;

import model.Facultate;
import model.Specializare;

import java.util.ArrayList;

public class SpecializareRepository
{
    private ArrayList<Specializare> specializari;

    public SpecializareRepository()
    {
        specializari= new ArrayList<>();
    }

    public void add(Specializare specializare)
    {
        specializari.add(specializare);
    }

    public void remove(int id)
    {
        for(int i=0;i<specializari.size();i++)
            if(specializari.get(i).getId_specializare()==id)
                specializari.remove(i);
    }

    public void removeByName(String nume)
    {
        for(int i=0;i<specializari.size();i++)
            if(specializari.get(i).getNume()==nume)
                specializari.remove(i);
    }

    public Specializare getSpecializareNume(String nume)
    {
        for(Specializare specializare : specializari)
            if(specializare.getNume()==nume)
                return specializare;

        return null;
    }

    public ArrayList<Specializare> getSpecializareFacultate(Facultate facultate)
    {
        ArrayList<Specializare> specializariFac=new ArrayList<Specializare>();

        for(Specializare specializare : specializari)
            if(specializare.getFacultate()==facultate)
                specializariFac.add(specializare);

        return specializariFac;
    }



    public void AfisSpecializari()
    {
        for(Specializare specializare:specializari)
            System.out.println(specializare);
    }


}
