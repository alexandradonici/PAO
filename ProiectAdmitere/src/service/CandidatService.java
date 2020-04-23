package service;

import model.Candidat;
import model.Repartitie;
import repository.CandidatRepository;
import service.reading_writing.AuditService;
import service.reading_writing.CandidatReadingService;
import service.reading_writing.CandidatWritingService;

import java.util.ArrayList;

public class CandidatService
{
    private CandidatRepository candidatRepository = new CandidatRepository();
    private static CandidatService instance = null;
    private CandidatWritingService candidatWritingService = CandidatWritingService.getInstance(candidatRepository);
    private CandidatReadingService candidatReadingService = CandidatReadingService.getInstance(candidatRepository);
    private AuditService auditService = AuditService.getInstance();

    public CandidatService(){}

    public static CandidatService getInstance()
    {
        if(instance == null)
            instance = new CandidatService();

        return instance;
    }
    public Candidat getCandidatNume(String nume, String prenume)
    {
        auditService.writeActiune("Selectare candidat dupa nume", auditService.getTimestamp());
        return candidatRepository.getCandidatNume(nume, prenume);

    }

    public Candidat getCandidatID(int id)
    {
        auditService.writeActiune("Selectare candidat dupa ID", auditService.getTimestamp());
        return candidatRepository.getCandidatID(id);

    }

    public void add(Candidat candidat)
    {
        auditService.writeActiune("Adaugare candidat nou", auditService.getTimestamp());
        candidatRepository.add(candidat);
        candidatWritingService.writeCandidat(candidat);
    }

    public ArrayList<Candidat> getCandidati()
    {
        auditService.writeActiune("Selectare candidati", auditService.getTimestamp());
        return candidatRepository.getCandidati();
    }


    public void loadCandidati()
    {
         auditService.writeActiune("Incarcare candidati din csv", auditService.getTimestamp());
         candidatReadingService.readingCandidati();
    }

    public void storeCandidati()
    {
        auditService.writeActiune("Incarcare candidati in csv", auditService.getTimestamp());
        candidatWritingService.reloadCandidati();

    }


    public void remove(int id)
    {
        auditService.writeActiune("Stergere candidat", auditService.getTimestamp());
        candidatRepository.remove(id);

        RepartitieService repartitieService = RepartitieService.getInstance();
        ArrayList<Repartitie> repartizare = repartitieService.getRepartizare();

        repartitieService.removeCandidat(id);

        repartitieService.storeRepartizare();
        storeCandidati();
     }

    public void AfisCandidati()
    {
        auditService.writeActiune("Afisare candidati", auditService.getTimestamp());
        candidatRepository.AfisCandidati();
    }
}
