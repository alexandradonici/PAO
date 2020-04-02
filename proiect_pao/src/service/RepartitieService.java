package service;

import model.Candidat;
import model.Facultate;
import model.Repartitie;
import model.Specializare;
import repository.CandidatRepository;
import repository.RepartitieRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RepartitieService
{
    private RepartitieRepository repartitieRepository = new RepartitieRepository();
    private static RepartitieService instance = null;

    public RepartitieService(){}

    public static RepartitieService getInstance()
    {
        if(instance == null)
            instance = new RepartitieService();
        return instance;
    }
    public void add(Repartitie repartitie)
    {
        repartitieRepository.add(repartitie);
    }

    public void remove(int id)
    {
        repartitieRepository.remove(id);
    }

    public ArrayList<Repartitie> getCandidatiPeSpecializari(Specializare specializare)
    {
        return repartitieRepository.getCandidatiPeSpecializari(specializare);
    }

    public ArrayList<Repartitie> getCandidatiPeFacultati(Facultate facultate)
    {
        return repartitieRepository.getCandidatiPeFacultati(facultate);
    }

    public ArrayList<Repartitie> getCandidatiMedieDescrescator(Specializare specializare)
    {
       return repartitieRepository.getCandidatiMedieDescrescator(specializare);
    }

    public ArrayList<Repartitie> getCandidatiAlfabetic(Specializare specializare)
    {
        return repartitieRepository.getCandidatiAlfabetic(specializare);
    }

    public ArrayList<Repartitie> getAdmisiBuget(Specializare specializare)
    {
       return repartitieRepository.getAdmisiBuget(specializare);

    }

    public ArrayList<Repartitie> getAdmisiTaxa(Specializare specializare)
    {
        return repartitieRepository.getAdmisiTaxa(specializare);

    }

    public ArrayList<Repartitie> getRespinsi(Specializare specializare)
    {
        return repartitieRepository.getRespinsi(specializare);

    }

    public ArrayList<Repartitie> getOptiuniCandidat(Candidat candidat)
    {
        return repartitieRepository.getOptiuniCandidat(candidat);
    }

    public int getInscrisi(Specializare specializare)
    {
        return repartitieRepository.getInscrisi(specializare);
    }

    public void updateMedieAdmitere(int id, double notaExamen)
    {
        repartitieRepository.updateMedieAdmitere(id,notaExamen);
    }

    public void AfisRepartizare()
    {
        repartitieRepository.AfisRepartizare();
    }


}
