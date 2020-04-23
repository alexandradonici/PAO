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
            {
                specializari.remove(i);
                i--;
            }
    }

    public void removeFacultate(int id_facultate)
    {
        for(int i = 0; i < specializari.size(); i++)
            if(specializari.get(i).getFacultate().getId_facultate() == id_facultate)
            {
                specializari.remove(i);
                i--;
            }
    }

    public void removeByName(String nume)
    {
        for(int i=0;i<specializari.size();i++)
            if(specializari.get(i).getNume()==nume)
            {
                specializari.remove(i);
                i--;
            }
    }

    public Specializare getSpecializareNume(String nume)
    {
        for(Specializare specializare : specializari)
            if(specializare.getNume()==nume)
                return specializare;

        return null;
    }

    public Specializare getSpecializareID(int id)
    {
        for(Specializare specializare : specializari)
            if(specializare.getId_specializare() == id)
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

    public ArrayList<Specializare> getSpecializari()
    {
        return specializari;
    }


    public void AfisSpecializari()
    {
        if(specializari.size() == 0)
            System.out.println("Nu exista specializari adaugate!");

        for(Specializare specializare:specializari)
            System.out.println(specializare);
    }


}
