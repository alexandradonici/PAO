package service;

import model.Candidat;
import model.Facultate;
import model.Repartitie;
import model.Specializare;
import repository.CandidatRepository;
import repository.RepartitieRepository;
import service.reading_writing.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RepartitieService
{
    private RepartitieRepository repartitieRepository = new RepartitieRepository();
    private static RepartitieService instance = null;
    private RepartitieWritingService repartitieWritingService = RepartitieWritingService.getInstance(repartitieRepository);
    private RepartitieReadingService repartitieReadingService = RepartitieReadingService.getInstance(repartitieRepository);
    private AuditService auditService = AuditService.getInstance();

    public RepartitieService(){}

    public static RepartitieService getInstance()
    {
        if(instance == null)
            instance = new RepartitieService();
        return instance;
    }
    public void add(Repartitie repartitie)
    {
        auditService.writeActiune("Adaugare optiune noua", auditService.getTimestamp());
        repartitieRepository.add(repartitie);
        repartitieWritingService.writeRepartitie(repartitie);
    }

    public void remove(int id)
    {
        auditService.writeActiune("Stergere optiune dupa ID", auditService.getTimestamp());
        repartitieRepository.remove(id);
        storeRepartizare();
    }

    public void removeCandidat(int id_candidat)
    {
        auditService.writeActiune("Stergere optiune dupa candidat", auditService.getTimestamp());
        repartitieRepository.removeCandidat(id_candidat);
        storeRepartizare();
    }

    public ArrayList<Repartitie> getCandidatiPeSpecializari(Specializare specializare)
    {
        auditService.writeActiune("Selectare optiuni dupa specializare", auditService.getTimestamp());
        return repartitieRepository.getCandidatiPeSpecializari(specializare);
    }

    public ArrayList<Repartitie> getCandidatiPeFacultati(Facultate facultate)
    {
        auditService.writeActiune("Selectare optiuni dupa facultate", auditService.getTimestamp());
        return repartitieRepository.getCandidatiPeFacultati(facultate);
    }

    public ArrayList<Repartitie> getCandidatiMedieDescrescator(Specializare specializare)
    {
        auditService.writeActiune("Selectare candidati in ordinea descrescatoare a mediilor dupa specializare", auditService.getTimestamp());
       return repartitieRepository.getCandidatiMedieDescrescator(specializare);
    }

    public ArrayList<Repartitie> getCandidatiAlfabetic(Specializare specializare)
    {
        auditService.writeActiune("Selectare candidati in ordinea alfabetica dupa specializare", auditService.getTimestamp());
        return repartitieRepository.getCandidatiAlfabetic(specializare);
    }

    public ArrayList<Repartitie> getAdmisiBuget(Specializare specializare)
    {
        auditService.writeActiune("Selectare candidati admisi la buget dupa specializare", auditService.getTimestamp());
        return repartitieRepository.getAdmisiBuget(specializare);

    }

    public ArrayList<Repartitie> getAdmisiTaxa(Specializare specializare)
    {
        auditService.writeActiune("Selectare candidati admisi la taxa dupa specializare", auditService.getTimestamp());
        return repartitieRepository.getAdmisiTaxa(specializare);

    }

    public ArrayList<Repartitie> getRespinsi(Specializare specializare)
    {
        auditService.writeActiune("Selectare candidati respinsi dupa specializare", auditService.getTimestamp());
        return repartitieRepository.getRespinsi(specializare);

    }

    public ArrayList<Repartitie> getOptiuniCandidat(Candidat candidat)
    {
        auditService.writeActiune("Selectare optiuni dupa candidat", auditService.getTimestamp());
        return repartitieRepository.getOptiuniCandidat(candidat);
    }


    public void updateMedieAdmitere(int id, double notaExamen)
    {
        auditService.writeActiune("Update medie admitere", auditService.getTimestamp());
        repartitieRepository.updateMedieAdmitere(id,notaExamen);
        MedieService medieService = MedieService.getInstance();
        medieService.storeMedii();
        storeRepartizare();
    }

    public void AfisRepartizare()
    {
        auditService.writeActiune("Afisare optiuni", auditService.getTimestamp());
        repartitieRepository.AfisRepartizare();
    }

    public ArrayList<Repartitie> getRepartizare()
    {
        auditService.writeActiune("Selectare optiuni", auditService.getTimestamp());
        return repartitieRepository.getRepartizare();
    }

    public void loadRepartizare()
    {
        auditService.writeActiune("Incarcare repartizare din csv", auditService.getTimestamp());
        repartitieReadingService.readingRepartizare();
    }

    public void storeRepartizare()
    {
        auditService.writeActiune("Incarcare repartizare in csv", auditService.getTimestamp());
        repartitieWritingService.reloadRepartizare();

    }

}
