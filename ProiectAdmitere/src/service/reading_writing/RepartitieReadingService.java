package service.reading_writing;

import model.Candidat;
import model.MedieAdmitere;
import model.Repartitie;
import model.Specializare;
import repository.RepartitieRepository;
import service.CandidatService;
import service.MedieService;
import service.SpecializareService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class RepartitieReadingService
{
    private static RepartitieReadingService instance = null;
    SpecializareService specializari = SpecializareService.getInstance();
    CandidatService candidati = CandidatService.getInstance();
    MedieService medii = MedieService.getInstance();
    RepartitieRepository repartitieRepository;

    public RepartitieReadingService(RepartitieRepository r)
    {
        repartitieRepository = r;
    }

    public static RepartitieReadingService getInstance(RepartitieRepository repartitieRepository) {
        if (instance == null)
            instance = new RepartitieReadingService(repartitieRepository);

        return instance;
    }

    public Path getPath() {
        return Paths.get("repartizare.csv");
    }

    public void readingRepartizare ()
    {

        File file = new File(String.valueOf(getPath()));

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(getPath())));
            String row;
            while ((row = reader.readLine()) != null) {
                String[] data = row.split(",");
                repartitieRepository.add(new Repartitie(parseInt(data[0]), candidati.getCandidatID(parseInt(data[1])), specializari.getSpecializareID(parseInt(data[2])), medii.getMedieID(parseInt(data[3]))));
            }
            reader.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }

}
