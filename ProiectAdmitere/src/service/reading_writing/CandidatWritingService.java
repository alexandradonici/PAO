package service.reading_writing;

import model.Candidat;
import repository.CandidatRepository;
import service.CandidatService;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CandidatWritingService
{
    private static CandidatWritingService instance = null;
    private CandidatRepository candidatRepository;


    private CandidatWritingService(CandidatRepository c) {

        candidatRepository = c;
    }

    public static CandidatWritingService getInstance(CandidatRepository candidatRepository)
    {
        if(instance == null)
            instance = new CandidatWritingService(candidatRepository);

        return instance;
    }

    public Path getPath()
    {
        return Paths.get("candidati.csv");
    }

    public void writeCandidat(Candidat candidat)
    {
        try
        {
            FileWriter writer = new FileWriter(String.valueOf(getPath()), true);
            List<String> row =  Arrays.asList(Integer.toString(candidat.getId_candidat()), candidat.getNume(), candidat.getPrenume());
            writer.append(String.join(",", row));
            writer.append("\n");
            writer.flush();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void reloadCandidati()
    {
        try
        {
            FileWriter writer = new FileWriter(String.valueOf(getPath()), false);

            for(Candidat candidat: candidatRepository.getCandidati() )
            {
                List<String> row =  Arrays.asList(Integer.toString(candidat.getId_candidat()), candidat.getNume(), candidat.getPrenume());
                writer.append(String.join(",", row));
                writer.append("\n");
                writer.flush();

            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
