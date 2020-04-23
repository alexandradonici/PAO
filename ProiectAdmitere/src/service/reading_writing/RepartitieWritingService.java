package service.reading_writing;

import model.Repartitie;
import model.Specializare;
import repository.RepartitieRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepartitieWritingService {
    private static RepartitieWritingService instance = null;
    RepartitieRepository repartitieRepository;

    public RepartitieWritingService(RepartitieRepository r)
    {
        repartitieRepository = r;
    }

    public static RepartitieWritingService getInstance(RepartitieRepository repartitieRepository) {
        if (instance == null)
            instance = new RepartitieWritingService(repartitieRepository);

        return instance;
    }

    public Path getPath() {
        return Paths.get("repartizare.csv");
    }

    public void writeRepartitie(Repartitie repartitie) {
        try {
            FileWriter writer = new FileWriter(String.valueOf(getPath()),true);
            List<String> row = Arrays.asList(Integer.toString(repartitie.getId_repartitie()),
                    Integer.toString(repartitie.getCandidat().getId_candidat()),
                    Integer.toString(repartitie.getSpecializare().getId_specializare()),
                    Integer.toString(repartitie.getMedie_admitere().getId_medie()));
            writer.append(String.join(",", row));
            writer.append("\n");
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadRepartizare() {
        try {
            FileWriter writer = new FileWriter(String.valueOf(getPath()), false);

            for(Repartitie repartitie : repartitieRepository.getRepartizare())
            {
                List<String> row = Arrays.asList(Integer.toString(repartitie.getId_repartitie()),
                        Integer.toString(repartitie.getCandidat().getId_candidat()),
                        Integer.toString(repartitie.getSpecializare().getId_specializare()),
                        Integer.toString(repartitie.getMedie_admitere().getId_medie()));
                writer.append(String.join(",", row));
                writer.append("\n");
                writer.flush();

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
