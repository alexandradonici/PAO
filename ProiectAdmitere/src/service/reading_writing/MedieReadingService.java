package service.reading_writing;

import model.Bacalaureat;
import model.Candidat;
import model.ExamenAdmitere;
import model.MedieAdmitere;
import repository.MedieRepository;
import service.FacultateService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class MedieReadingService
{
    private static MedieReadingService instance = null;
    private MedieRepository medieRepository;
    FacultateService facultati = FacultateService.getInstance();

    public MedieReadingService(MedieRepository m)
    {
        medieRepository = m;
    }

    public static MedieReadingService getInstance(MedieRepository medieRepository)
    {
        if(instance == null)
            instance = new MedieReadingService(medieRepository);

        return instance;
    }

    public Path getPath()
    {
        return Paths.get("medii.csv");
    }

    public void readingMedii ()
    {

        File file = new File(String.valueOf(getPath()));

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(getPath())));
            String row;
            while ((row = reader.readLine()) != null) {
                String[] data = row.split(",");
                medieRepository.add(new MedieAdmitere(parseInt(data[0]), new Bacalaureat(parseDouble(data[1]), parseDouble(data[2]), parseDouble(data[3])), new ExamenAdmitere(data[5], parseDouble(data[4])),facultati.getFacultateID(parseInt(data[6]))));

            }
            reader.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
