package service;

import model.Facultate;
import model.MedieAdmitere;
import repository.FacultateRepository;
import repository.MedieRepository;
import service.reading_writing.*;

import java.util.ArrayList;

public class MedieService
{
    private MedieRepository medieRepository = new MedieRepository();
    private static MedieService instance = null;
    private MedieWritingService medieWritingService = MedieWritingService.getInstance(medieRepository);
    private MedieReadingService medieReadingService = MedieReadingService.getInstance(medieRepository);
    private AuditService auditService = AuditService.getInstance();

    public MedieService(){}

    public static MedieService getInstance()
    {
        if(instance == null)
            instance = new MedieService();

        return instance;
    }
    public void add(MedieAdmitere medieAdmitere)
    {
        auditService.writeActiune("Adaugare medie noua", auditService.getTimestamp());
        medieRepository.add(medieAdmitere);
        medieWritingService.writeMedie(medieAdmitere);
    }

    public void remove(int id)
    {
        auditService.writeActiune("Stergere medie dupa ID", auditService.getTimestamp());
       medieRepository.remove(id);
       storeMedii();
    }

    public MedieAdmitere getMedieID(int id)
    {
        auditService.writeActiune("Selectare medie dupa ID", auditService.getTimestamp());
        return medieRepository.getMedieID(id);
    }
    public ArrayList<MedieAdmitere> getMedii()
    {
        auditService.writeActiune("Selectare medii", auditService.getTimestamp());
        return medieRepository.getMedii();
    }

    public void loadMedii()
    {
        auditService.writeActiune("Incarcare facultati din csv", auditService.getTimestamp());
        medieReadingService.readingMedii();
    }

    public void storeMedii()
    {
        auditService.writeActiune("Incarcare facultati in csv", auditService.getTimestamp());
       medieWritingService.reloadMedii();

    }
}
