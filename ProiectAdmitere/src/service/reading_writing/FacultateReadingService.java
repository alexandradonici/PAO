package service.reading_writing;

import model.Candidat;
import model.Facultate;
import model.FacultateCuAdmitere;
import model.FacultateFaraAdmitere;
import repository.CandidatRepository;
import repository.FacultateRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FacultateReadingService
{
    private static FacultateReadingService instance = null;
    private FacultateRepository facultateRepository;

    public FacultateReadingService(){}

    private FacultateReadingService(FacultateRepository f) {

        facultateRepository = f;
    }

    public static FacultateReadingService getInstance( FacultateRepository facultateRepository)
    {
        if(instance == null)
            instance = new FacultateReadingService(facultateRepository);

        return instance;
    }



    public Path getPath()
    {
        return Paths.get("facultati.csv");
    }

    public void readingFacultati ()
    {

        File file = new File(String.valueOf(getPath()));

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(getPath())));
            String row=null;
            while ((row = reader.readLine()) != null) {
                String[] data = row.split(",");
                if(parseInt(data[2]) == 0)
                facultateRepository.add(new FacultateCuAdmitere(parseInt(data[0]), data[1]));
                else facultateRepository.add(new FacultateFaraAdmitere(parseInt(data[0]), data[1]));
            }
            reader.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
