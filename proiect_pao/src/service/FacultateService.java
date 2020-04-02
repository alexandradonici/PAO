package service;

import model.Facultate;

import model.FacultateCuAdmitere;
import model.FacultateFaraAdmitere;
import repository.FacultateRepository;

import java.util.ArrayList;

public class FacultateService
{
    private FacultateRepository facultateRepository = new FacultateRepository();
    private static FacultateService instance = null;

    public FacultateService(){}

    public static FacultateService getInstance()
    {
        if(instance == null)
            instance = new FacultateService();

        return instance;
    }

    public void add(Facultate facultate)
    {
        facultateRepository.add(facultate);
    }

    public void remove(int id)
    {
       facultateRepository.remove(id);
    }

    public void removeByName(String nume)
    {
        facultateRepository.removeByName(nume);
    }

    public Facultate getFacultateNume(String nume)
    {
        return facultateRepository.getFacultateNume(nume);
    }

    public ArrayList<FacultateCuAdmitere> getFacultatiCuAdmitere()
    {
       return  facultateRepository.getFacultatiCuAdmitere();
    }

    public ArrayList<FacultateFaraAdmitere> getFacultatiFaraAdmitere()
    {
        return facultateRepository.getFacultatiFaraAdmitere();
    }

    public ArrayList<Facultate> getFacultati()
    {
        return facultateRepository.getFacultati();
    }

    public void AfisFacultati()
    {
        facultateRepository.AfisFacultati();
    }

    public void AfisFacultatiCuAdmitere()
    {
       facultateRepository.AfisFacultatiCuAdmitere();
    }

    public void AfisFacultatiFaraAdmitere()
    {
        facultateRepository.AfisFacultatiFaraAdmitere();
    }
}
