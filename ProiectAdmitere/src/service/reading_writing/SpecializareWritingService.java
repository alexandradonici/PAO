package service.reading_writing;

import model.Candidat;
import model.Specializare;
import repository.FacultateRepository;
import repository.SpecializareRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecializareWritingService
{
    private static SpecializareWritingService instance = null;
    private SpecializareRepository specializareRepository;

    public SpecializareWritingService(SpecializareRepository s)
    {
        specializareRepository = s;
    }

    public static SpecializareWritingService getInstance(SpecializareRepository specializareRepository)
    {
        if(instance == null)
            instance = new SpecializareWritingService(specializareRepository);

        return instance;
    }

    public Path getPath()
    {
        return Paths.get("specializari.csv");
    }

    public void writeSpecializare(Specializare specializare)
    {
        try
        {
            FileWriter writer = new FileWriter(String.valueOf(getPath()), true);
            List<String> row =  Arrays.asList(Integer.toString(specializare.getId_specializare()), specializare.getNume(),
                                Integer.toString(specializare.getFacultate().getId_facultate()), Integer.toString(specializare.getLocuri_buget()),
                                Integer.toString(specializare.getLocuri_taxa()));
            writer.append(String.join(",", row));
            writer.append("\n");
            writer.flush();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void reloadSpecializari()
    {
        try
        {
            FileWriter writer = new FileWriter(String.valueOf(getPath()), false);

            for(Specializare specializare : specializareRepository.getSpecializari())
            {
                List<String> row = Arrays.asList(Integer.toString(specializare.getId_specializare()), specializare.getNume(),
                        Integer.toString(specializare.getFacultate().getId_facultate()), Integer.toString(specializare.getLocuri_buget()),
                        Integer.toString(specializare.getLocuri_taxa()));
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
