package service;

import model.Facultate;
import model.Specializare;
import repository.CandidatRepository;
import repository.SpecializareRepository;
import service.reading_writing.*;

import java.util.ArrayList;

public class SpecializareService
{
    private SpecializareRepository specializareRepository = new SpecializareRepository();
    private static SpecializareService instance = null;
    private SpecializareWritingService specializareWritingService = SpecializareWritingService.getInstance(specializareRepository);
    private SpecializareReadingService specializareReadingService = SpecializareReadingService.getInstance(specializareRepository);
    private AuditService auditService = AuditService.getInstance();

    public SpecializareService(){}

    public static SpecializareService getInstance()
    {
        if(instance == null)
            instance = new SpecializareService();

        return instance;
    }

    public void add(Specializare specializare)
    {
        auditService.writeActiune("Adaugare specializare noua", auditService.getTimestamp());
        specializareRepository.add(specializare);
        specializareWritingService.writeSpecializare(specializare);
    }

    public void remove(int id)
    {
        auditService.writeActiune("Stergere specializare dupa ID", auditService.getTimestamp());
        specializareRepository.remove(id);
        storeSpecializari();
    }

    public void removeFacultate(int id_facultate)
    {
        auditService.writeActiune("Stergere specializare dupa facultate", auditService.getTimestamp());
        specializareRepository.removeFacultate(id_facultate);
        storeSpecializari();
    }

    public void removeByName(String nume)
    {
        auditService.writeActiune("Stergere specializare dupa nume", auditService.getTimestamp());
        specializareRepository.removeByName(nume);
        storeSpecializari();
    }

    public Specializare getSpecializareNume(String nume)
{
    auditService.writeActiune("Selectare specializare dupa nume", auditService.getTimestamp());
    return specializareRepository.getSpecializareNume(nume);
}

    public Specializare getSpecializareID(int id)
    {
        auditService.writeActiune("Selectare specializare dupa ID", auditService.getTimestamp());
        return specializareRepository.getSpecializareID(id);
    }

    public ArrayList<Specializare> getSpecializareFacultate(Facultate facultate)
    {
        auditService.writeActiune("Selectare specializare dupa facultate", auditService.getTimestamp());
        return specializareRepository.getSpecializareFacultate(facultate);
    }

    public ArrayList<Specializare> getSpecializari()
    {
        auditService.writeActiune("Selectare specializari", auditService.getTimestamp());
        return specializareRepository.getSpecializari();
    }

    public void AfisSpecializari()
    {
        auditService.writeActiune("Afisare specializari", auditService.getTimestamp());
        specializareRepository.AfisSpecializari();
    }

    public void loadSpecializari()
    {
        auditService.writeActiune("Incarcare specializari din csv", auditService.getTimestamp());
        specializareReadingService.readingSpecializari();
    }

    public void storeSpecializari()
    {
        auditService.writeActiune("Incarcare specializari in csv", auditService.getTimestamp());
        specializareWritingService.reloadSpecializari();

    }
}
