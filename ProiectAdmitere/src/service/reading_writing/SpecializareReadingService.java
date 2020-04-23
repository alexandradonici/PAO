package service.reading_writing;

import model.Candidat;
import model.Facultate;
import model.Specializare;
import repository.FacultateRepository;
import repository.SpecializareRepository;
import service.FacultateService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class SpecializareReadingService
{
    private static SpecializareReadingService instance = null;
    FacultateService facultati = FacultateService.getInstance();
    SpecializareRepository specializareRepository;

    public SpecializareReadingService(SpecializareRepository s)
    {
        specializareRepository = s;
    }

    public static SpecializareReadingService getInstance(SpecializareRepository specializareRepository)
    {
        if(instance == null)
            instance = new SpecializareReadingService(specializareRepository);

        return instance;
    }

    public Path getPath()
    {
        return Paths.get("specializari.csv");
    }

    public void readingSpecializari ()
    {

        File file = new File(String.valueOf(getPath()));

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(getPath())));
            String row;
            while ((row = reader.readLine()) != null) {
                String[] data = row.split(",");
                specializareRepository.add(new Specializare(parseInt(data[0]), data[1], facultati.getFacultateID(parseInt(data[2])), parseInt(data[3]), parseInt(data[4])));
            }
            reader.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}
