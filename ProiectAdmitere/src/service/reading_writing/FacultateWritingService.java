package service.reading_writing;

import model.Candidat;
import model.Facultate;
import model.FacultateCuAdmitere;
import repository.CandidatRepository;
import repository.FacultateRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class FacultateWritingService
{
    private static FacultateWritingService instance = null;
    private FacultateRepository facultateRepository;


    public FacultateWritingService(){}

    private FacultateWritingService(FacultateRepository f) {

        facultateRepository = f;
    }

    public static FacultateWritingService getInstance(FacultateRepository facultateRepository)
    {
        if(instance == null)
            instance = new FacultateWritingService(facultateRepository);

        return instance;
    }

    public Path getPath()
    {
        return Paths.get("facultati.csv");
    }

    public void writeFacultate(Facultate facultate)
    {
        try
        {
            FileWriter writer = new FileWriter(String.valueOf(getPath()), true);
            int tipFacultate ;
            if(facultate instanceof FacultateCuAdmitere)
                tipFacultate = 0;
            else
                tipFacultate = 1;
            List<String> row =  Arrays.asList(Integer.toString(facultate.getId_facultate()), facultate.getNume(), Integer.toString(tipFacultate));
            writer.append(String.join(",", row));
            writer.append("\n");
            writer.flush();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void reloadFacultati()
    {
        try
        {
            FileWriter writer = new FileWriter(String.valueOf(getPath()), false);
            int tipFacultate;
            System.out.println(facultateRepository.getFacultati().size());
            for(Facultate facultate : facultateRepository.getFacultati())
            {

                if (facultate instanceof FacultateCuAdmitere)
                    tipFacultate = 0;
                else
                    tipFacultate = 1;
                List<String> row = Arrays.asList(Integer.toString(facultate.getId_facultate()), facultate.getNume(), Integer.toString(tipFacultate));
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
