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
                candidati.remove(i);
    }

    public Candidat getCandidatNume(String nume, String prenume)
    {
        for(Candidat candidat : candidati)
            if(candidat.getNume()== nume && candidat.getPrenume() == prenume)
                return candidat;
            return null;

    }

    public void AfisCandidati()
    {
        for(Candidat candidat:candidati)
            System.out.println(candidat);
    }



}
