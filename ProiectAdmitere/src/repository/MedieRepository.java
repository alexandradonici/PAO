package repository;

import model.Candidat;
import model.MedieAdmitere;

import java.util.ArrayList;

public class MedieRepository
{
    private ArrayList< MedieAdmitere> medii;

    public MedieRepository()
    {
        medii = new ArrayList<>();
    }

    public void add(MedieAdmitere medieAdmitere)
    {
        medii.add(medieAdmitere);
    }

    public void remove(int id)
    {
        for(int i=0;i<medii.size();i++)
            if(medii.get(i).getId_medie() == id)
                medii.remove(i);
    }

    public MedieAdmitere getMedieID(int id)
    {
        for(MedieAdmitere medie : medii)
            if(medie.getId_medie() == id)
                return medie;
        return null;
    }

    public ArrayList<MedieAdmitere> getMedii()
    {
        ArrayList<MedieAdmitere> m = new ArrayList<>();
        for(MedieAdmitere medie : medii)
            m.add(medie);

        return m;
    }

}
