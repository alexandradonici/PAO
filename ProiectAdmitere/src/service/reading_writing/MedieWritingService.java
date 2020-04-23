package service.reading_writing;

import model.Bacalaureat;
import model.Candidat;
import model.MedieAdmitere;
import repository.MedieRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedieWritingService
{
    private static MedieWritingService instance = null;
    private MedieRepository medieRepository;

    public MedieWritingService(MedieRepository m)
    {
        medieRepository = m;
    }

    public static MedieWritingService getInstance(MedieRepository medieRepository)
    {
        if(instance == null)
            instance = new MedieWritingService(medieRepository);

        return instance;
    }

    public Path getPath()
    {
        return Paths.get("medii.csv");
    }

    public void writeMedie(MedieAdmitere medie)
    {
        try
        {
            FileWriter writer = new FileWriter(String.valueOf(getPath()),true);
            List<String> row =  Arrays.asList(Integer.toString(medie.getId_medie()), Double.toString(medie.getBac().getNotaP1()),
                    Double.toString(medie.getBac().getNotaP2()), Double.toString(medie.getBac().getNotaP3()),
                    Double.toString(medie.getAdmitere().getNotaExamen()), medie.getAdmitere().getSalaExamen(), Integer.toString(medie.getFacultate().getId_facultate()));
            writer.append(String.join(",", row));
            writer.append("\n");
            writer.flush();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void reloadMedii()
    {
        try
        {
            FileWriter writer = new FileWriter(String.valueOf(getPath()), false);

            for(MedieAdmitere medie : medieRepository.getMedii())
            {
                double medie_admitere;
                if(medie.getAdmitere().getNotaExamen()==0)
                    medie_admitere = 0;
                else
                    medie_admitere = medie.getMedie_admitere();

                List<String> row = Arrays.asList(Integer.toString(medie.getId_medie()), Double.toString(medie.getBac().getNotaP1()),
                        Double.toString(medie.getBac().getNotaP2()), Double.toString(medie.getBac().getNotaP3()),
                        Double.toString(medie.getAdmitere().getNotaExamen()), medie.getAdmitere().getSalaExamen(), Integer.toString(medie.getFacultate().getId_facultate()));
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
