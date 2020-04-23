package repository;

import java.util.ArrayList;
import model.Candidat;

public class CandidatRepository
{
    private ArrayList<Candidat> candidati;

    public CandidatRepository()
    {
        candidati= new ArrayList<>();
    }

    public void add(Candidat candidat)
    {
        candidati.add(candidat);
    }

    public void remove(int id)
    {
        for(int i=0;i<candidati.size();i++)
            if(candidati.get(i).getId_candidat()==id)
            {
                candidati.remove(i);
                i--;
            }
    }

    public Candidat getCandidatNume(String nume, String prenume)
    {
        for(Candidat candidat : candidati)
            if(candidat.getNume()== nume && candidat.getPrenume() == prenume)
                return candidat;
            return null;

    }

    public Candidat getCandidatID(int id)
    {
        for(Candidat candidat : candidati)
            if(candidat.getId_candidat() == id)
                return candidat;
        return null;
    }

    public ArrayList<Candidat> getCandidati()
    {
        ArrayList<Candidat> c = new ArrayList<>();
        for(Candidat candidat : candidati)
            c.add(candidat);

        return c;
    }

    public void AfisCandidati()
    {
        if(candidati.size() == 0)
            System.out.println("Nu exista candidati adaugati!");

        for(Candidat candidat:candidati)
            System.out.println(candidat);
    }



}
