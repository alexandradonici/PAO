package service.reading_writing;

import model.Candidat;
import repository.CandidatRepository;
import service.CandidatService;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class CandidatReadingService
{
    private static CandidatReadingService instance = null;
    private CandidatRepository candidatRepository;
    public CandidatReadingService(){}

    public static CandidatReadingService getInstance(CandidatRepository candidatRepository)
    {
        if(instance == null)
            instance = new CandidatReadingService(candidatRepository);

        return instance;
    }
    private CandidatReadingService(CandidatRepository c) {

        candidatRepository = c;
    }

    public Path getPath()
    {
        return Paths.get("candidati.csv");
    }

    public void readingCandidati ()
    {

        File file = new File(String.valueOf(getPath()));

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(getPath())));
            String row;

            while ((row = reader.readLine()) != null) {
                String[] data = row.split(",");
                candidatRepository.add(new Candidat(parseInt(data[0]),data[1], data[2]));
            }
            reader.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}
