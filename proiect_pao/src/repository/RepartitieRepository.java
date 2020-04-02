package repository;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RepartitieRepository
{
    private ArrayList<Repartitie> repartizari;

    public RepartitieRepository()
    {
        repartizari= new ArrayList<>();
    }

    public void add(Repartitie repartitie)
    {
        repartizari.add(repartitie);
    }

    public void remove(int id)
    {
        for(int i=0;i<repartizari.size();i++)
            if(repartizari.get(i).getId_repartitie()==id)
            {
                repartizari.remove(i);

            }
    }

    public ArrayList<Repartitie> getCandidatiPeSpecializari(Specializare specializare)
    {
        ArrayList<Repartitie> CandidatiPeSpecializari = new ArrayList<Repartitie>();

        for(Repartitie repartitie : repartizari)
        if(repartitie.getSpecializare()==specializare)
            CandidatiPeSpecializari.add(repartitie);

        return CandidatiPeSpecializari;
    }

    public ArrayList<Repartitie> getCandidatiPeFacultati(Facultate facultate)
    {
        ArrayList<Repartitie> CandidatiPeFacultati = new ArrayList<Repartitie>();

        for(Repartitie repartitie : repartizari)
            if(repartitie.getSpecializare().getFacultate()==facultate)
                CandidatiPeFacultati.add(repartitie);

        return CandidatiPeFacultati;
    }

    public static Comparator<Repartitie> NumeComparator = new Comparator<Repartitie>()
    {

        public int compare(Repartitie r1, Repartitie r2)
        {
            String Candidat1 = r1.getCandidat().getNume().toUpperCase();
            String Candidat2 = r2.getCandidat().getNume().toUpperCase();

            return Candidat1.compareTo(Candidat2);

        }
    };

    public static Comparator<Repartitie> MedieComparator = new Comparator<Repartitie>()
    {

        public int compare(Repartitie r1, Repartitie r2)
        {
            double Candidat1 = r1.getMedie_admitere().getMedie_admitere();
            double Candidat2 = r2.getMedie_admitere().getMedie_admitere();

            return Double.compare(Candidat2, Candidat1);

        }
    };


    public ArrayList<Repartitie> getCandidatiMedieDescrescator(Specializare specializare)
    {
        ArrayList<Repartitie> CandidatiPeSpecializari = new ArrayList<Repartitie>();
        CandidatiPeSpecializari = getCandidatiPeSpecializari(specializare);
         Collections.sort(CandidatiPeSpecializari, MedieComparator);

         return CandidatiPeSpecializari;
    }

    public ArrayList<Repartitie> getCandidatiAlfabetic(Specializare specializare)
    {
        ArrayList<Repartitie> candidatiPeSpecializari = new ArrayList<Repartitie>();
        candidatiPeSpecializari = getCandidatiPeSpecializari(specializare);
        Collections.sort(candidatiPeSpecializari, NumeComparator);

        return candidatiPeSpecializari;
    }

    public ArrayList<Repartitie> getAdmisiBuget(Specializare specializare)
    {
        ArrayList<Repartitie> candidatiAdmisiBuget = new ArrayList<Repartitie>();
        ArrayList<Repartitie> candidatiPeSpecializari = getCandidatiMedieDescrescator(specializare);

        int locuriBuget = specializare.getLocuri_buget();
        if(candidatiPeSpecializari.size()<locuriBuget)
            locuriBuget=candidatiPeSpecializari.size();

        for(int i=0; i<locuriBuget; i++)
            candidatiAdmisiBuget.add(candidatiPeSpecializari.get(i));

        return candidatiAdmisiBuget;

    }

    public ArrayList<Repartitie> getAdmisiTaxa(Specializare specializare)
    {
        ArrayList<Repartitie> candidatiAdmisiTaxa = new ArrayList<Repartitie>();
        ArrayList<Repartitie> candidatiPeSpecializari = getCandidatiMedieDescrescator(specializare);

        int locuriBuget = specializare.getLocuri_buget();
        int locuriTaxa = specializare.getLocuri_taxa();
        int limita=locuriBuget+locuriTaxa;

        if(locuriBuget<candidatiPeSpecializari.size())
            return candidatiAdmisiTaxa;

        if(limita>candidatiPeSpecializari.size())
            limita=candidatiPeSpecializari.size();

        for(int i=locuriBuget; i<limita; i++)
            candidatiAdmisiTaxa.add(candidatiPeSpecializari.get(i));

        return candidatiAdmisiTaxa;

    }

    public ArrayList<Repartitie> getRespinsi(Specializare specializare)
    {
        ArrayList<Repartitie> candidatiRespinsi = new ArrayList<Repartitie>();
        ArrayList<Repartitie> candidatiPeSpecializari = getCandidatiMedieDescrescator(specializare);

        int locuriBuget = specializare.getLocuri_buget();
        int locuriTaxa = specializare.getLocuri_taxa();
        int limita=locuriBuget+locuriTaxa;

        if(limita>candidatiPeSpecializari.size())
            return candidatiRespinsi;

        for(int i=limita; i<candidatiPeSpecializari.size(); i++)
            candidatiRespinsi.add(candidatiPeSpecializari.get(i));

        return candidatiRespinsi;

    }

    public ArrayList<Repartitie> getOptiuniCandidat(Candidat candidat)
    {
        ArrayList<Repartitie> optiuni = new ArrayList<Repartitie>();

        for(Repartitie repartitie : repartizari)
            if(repartitie.getCandidat()==candidat)
                optiuni.add(repartitie);

         return optiuni;
    }

    public int getInscrisi(Specializare specializare)
    {
        return specializare.getInscrisi();
    }



    public void AfisRepartizare()
    {
        for(Repartitie repartitie:repartizari)
            System.out.println(repartitie);
    }

    public void updateMedieAdmitere(int id, double notaExamen)
    {
        for(Repartitie repartitie : repartizari)
        {
            if(repartitie.getId_repartitie()==id)
            {
                repartitie.getMedie_admitere().getAdmitere().setNotaExamen(notaExamen);
                double ma= repartitie.getSpecializare().getFacultate().calculMedieAdmitere(repartitie.getMedie_admitere());
                repartitie.getMedie_admitere().setMedie_admitere(ma);
            }
        }
    }

}
