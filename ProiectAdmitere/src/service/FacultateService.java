package service;

import model.*;

import repository.FacultateRepository;
import service.reading_writing.*;

import java.util.ArrayList;

public class FacultateService
{
    private FacultateRepository facultateRepository = new FacultateRepository();
    private static FacultateService instance = null;
    private FacultateWritingService facultateWritingService = FacultateWritingService.getInstance(facultateRepository);
    private FacultateReadingService facultateReadingService = FacultateReadingService.getInstance(facultateRepository);
    private AuditService auditService = AuditService.getInstance();

    public FacultateService(){}

    public static FacultateService getInstance()
    {
        if(instance == null)
            instance = new FacultateService();

        return instance;
    }

    public void add(Facultate facultate)
    {
        auditService.writeActiune("Adaugare facultate noua", auditService.getTimestamp());
        facultateRepository.add(facultate);
        facultateWritingService.writeFacultate(facultate);
    }

    public void remove(int id)
    {
        auditService.writeActiune("Stergere facultate dupa ID", auditService.getTimestamp());
       facultateRepository.remove(id);

       SpecializareService specializareService = SpecializareService.getInstance();
       ArrayList<Specializare> specializari = specializareService.getSpecializari();

       specializareService.removeFacultate(id);
       specializareService.storeSpecializari();
       storeFacultati();
    }

    public void removeByName(String nume)
    {
        auditService.writeActiune("Stergere facultate dupa nume", auditService.getTimestamp());
        facultateRepository.removeByName(nume);

        SpecializareService specializareService = SpecializareService.getInstance();
        ArrayList<Specializare> specializari = specializareService.getSpecializari();

        for(Specializare specializare : specializari )
            if(specializare.getFacultate().getNume() == nume)
            {
                int id_specializare = specializare.getId_specializare();
                specializareService.remove(id_specializare);
            }

        specializareService.storeSpecializari();
        storeFacultati();
    }

    public Facultate getFacultateNume(String nume)
    {
        auditService.writeActiune("Selectare facultate dupa nume", auditService.getTimestamp());
        return facultateRepository.getFacultateNume(nume);
    }

    public Facultate getFacultateID(int id)
    {
        auditService.writeActiune("Selectare facultate dupa ID", auditService.getTimestamp());
        return facultateRepository.getFacultateID(id);
    }

    public ArrayList<FacultateCuAdmitere> getFacultatiCuAdmitere()
    {
        auditService.writeActiune("Selectare facultati cu admitere", auditService.getTimestamp());
        return  facultateRepository.getFacultatiCuAdmitere();
    }

    public ArrayList<FacultateFaraAdmitere> getFacultatiFaraAdmitere()
    {
        auditService.writeActiune("Selectare facultati fara admitere", auditService.getTimestamp());
        return facultateRepository.getFacultatiFaraAdmitere();
    }

    public ArrayList<Facultate> getFacultati()
    {
        auditService.writeActiune("Selectare facultati", auditService.getTimestamp());
        return facultateRepository.getFacultati();
    }

    public void AfisFacultati()
    {
        auditService.writeActiune("Afisare facultati", auditService.getTimestamp());
        facultateRepository.AfisFacultati();
    }

    public void AfisFacultatiCuAdmitere()
    {
        auditService.writeActiune("Afisare facultati cu admitere", auditService.getTimestamp());
        facultateRepository.AfisFacultatiCuAdmitere();
    }

    public void AfisFacultatiFaraAdmitere()
    {
        auditService.writeActiune("Afisare facultati fara admitere", auditService.getTimestamp());
        facultateRepository.AfisFacultatiFaraAdmitere();
    }

    public void loadFacultati()
    {
        auditService.writeActiune("Incarcare facultati din csv", auditService.getTimestamp());
        facultateReadingService.readingFacultati();
    }

    public void storeFacultati()
    {
        auditService.writeActiune("Incarcare facultati in csv", auditService.getTimestamp());
        facultateWritingService.reloadFacultati();

    }
}
