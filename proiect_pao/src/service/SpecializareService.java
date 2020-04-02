package service;

import model.Facultate;
import model.Specializare;
import repository.CandidatRepository;
import repository.SpecializareRepository;

import java.util.ArrayList;

public class SpecializareService
{
    private SpecializareRepository specializareRepository = new SpecializareRepository();
    private static SpecializareService instance = null;

    public SpecializareService(){}

    public static SpecializareService getInstance()
    {
        if(instance == null)
            instance = new SpecializareService();

        return instance;
    }

    public void add(Specializare specializare)
    {
        specializareRepository.add(specializare);
    }

    public void remove(int id)
    {
        specializareRepository.remove(id);
    }

    public void removeByName(String nume)
    {
        specializareRepository.removeByName(nume);
    }

    public Specializare getSpecializareNume(String nume)
    {
        return specializareRepository.getSpecializareNume(nume);
    }

    public ArrayList<Specializare> getSpecializareFacultate(Facultate facultate)
    {
        return specializareRepository.getSpecializareFacultate(facultate);
    }
    public void AfisSpecializari()
    {
        specializareRepository.AfisSpecializari();
    }
}
