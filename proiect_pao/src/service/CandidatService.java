package service;

import model.Candidat;
import repository.CandidatRepository;

public class CandidatService
{
    private CandidatRepository candidatRepository = new CandidatRepository();
    private static CandidatService instance = null;

    public CandidatService(){}

    public static CandidatService getInstance()
    {
        if(instance == null)
            instance = new CandidatService();

        return instance;
    }
    public Candidat getCandidatNume(String nume, String prenume)
    {
        return candidatRepository.getCandidatNume(nume, prenume);

    }

    public void add(Candidat candidat)
    {
        candidatRepository.add(candidat);
    }

    public void remove(int id)
    {
        candidatRepository.remove(id);
    }

    public void AfisCandidati()
    {
        candidatRepository.AfisCandidati();
    }
}
