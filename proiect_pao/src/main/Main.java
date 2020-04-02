package main;

import model.*;
import service.CandidatService;
import service.FacultateService;
import service.RepartitieService;
import service.SpecializareService;

import java.util.ArrayList;

public class Main
{
public static void main(String[] args)
{
    FacultateService facultatiService = FacultateService.getInstance();
    Facultate f1 = new FacultateCuAdmitere("FMI");
    Facultate f2 = new FacultateFaraAdmitere("Biologie");
    Facultate f3 = new FacultateCuAdmitere("Drept");

    facultatiService.add(f1);
    facultatiService.add(f2);
    facultatiService.add(f3);

    System.out.println("Toate facultatile:");
    facultatiService.AfisFacultati();
    System.out.println();
    System.out.println("Facultatile cu admitere:");
    facultatiService.AfisFacultatiCuAdmitere();
    System.out.println();
    System.out.println("Facultatile fara admitere:");
    facultatiService.AfisFacultatiFaraAdmitere();
    System.out.println();

    SpecializareService specializareService = SpecializareService.getInstance();

    specializareService.add(new Specializare("Informatica", facultatiService.getFacultateNume("FMI"), 7, 3 ));
    specializareService.add(new Specializare("Matematica", facultatiService.getFacultateNume("FMI"), 15, 5 ));
    specializareService.add(new Specializare("CTI", facultatiService.getFacultateNume("FMI"), 10, 2 ));
    specializareService.add(new Specializare("Biologie", facultatiService.getFacultateNume("Biologie"), 140, 100 ));
    specializareService.add(new Specializare("Biochimie", facultatiService.getFacultateNume("Biologie"), 7, 2 ));
    specializareService.add(new Specializare("Ecologie si protectia mediului",  facultatiService.getFacultateNume("Biologie"), 100, 50 ));
    specializareService.add(new Specializare("Drept",  facultatiService.getFacultateNume("Drept"), 200, 100 ));

    System.out.println("Toate specializarile:");
    specializareService.AfisSpecializari();

    specializareService.remove(6);
    specializareService.removeByName("Drept");

    System.out.println();
    System.out.println("Toate specializarile dupa stergeri:");
    specializareService.AfisSpecializari();
    System.out.println();

    System.out.println("Specializarile facultatii FMI");
    ArrayList<Specializare> specializari = new ArrayList<Specializare>();
    specializari = specializareService.getSpecializareFacultate(f1);
    for(Specializare specializare : specializari)
        System.out.println(specializare);
    System.out.println();

    CandidatService candidatService = CandidatService.getInstance();

     Candidat c1 = new Candidat("Dumitrache", "Adrian");
     Candidat c2 = new Candidat("Macovei", "Cosmin");
     Candidat c3 = new Candidat("Darie", "Teodor");
     Candidat c4 = new Candidat("Dumea", "Irina");
     Candidat c5 = new Candidat("Radu", "ALexandru");
     Candidat c6 = new Candidat("Ivan", "Mihai");
     Candidat c7 = new Candidat("Stancu", "Andrei");
     Candidat c8 =  new Candidat("Tanase", "Denisa");
     Candidat c9 = new Candidat("Petcu", "Cristina");
     Candidat c10 = new Candidat("Pintilie", "Leonard");
     Candidat c11 =  new Candidat("Buzau", "Mihnea");
     Candidat c12 = new Candidat("Petrachi", "Matei");
     Candidat c13 = new Candidat("Craciun", "Miruna");
     Candidat c14 = new Candidat("Boboc", "Vlad");
     Candidat c15 = new Candidat("Irimia", "Ioana");
    Candidat c16 = new Candidat("Ivan", "Petru");
    Candidat c17 = new Candidat("Aanei", "Bianca");
    Candidat c18 = new Candidat("Dornescu", "Diana");
    Candidat c19 = new Candidat("Popescu", "Ionut");
    Candidat c20 = new Candidat("Cocea", "Robert");
    Candidat c21 = new Candidat("Maftei", "Mihaela");
    Candidat c22 = new Candidat("Alexa", "Maria");
    Candidat c23 = new Candidat("Buzau", "Diana");

    candidatService.add(c1);
    candidatService.add(c2);
    candidatService.add(c3);
    candidatService.add(c4);
    candidatService.add(c5);
    candidatService.add(c6);
    candidatService.add(c7);
    candidatService.add(c8);
    candidatService.add(c9);
    candidatService.add(c10);
    candidatService.add(c11);
    candidatService.add(c12);
    candidatService.add(c13);
    candidatService.add(c14);
    candidatService.add(c15);
    candidatService.add(c16);
    candidatService.add(c17);
    candidatService.add(c18);
    candidatService.add(c19);
    candidatService.add(c20);
    candidatService.add(c21);
    candidatService.add(c22);
    candidatService.add(c23);


    System.out.println();
    System.out.println("Toti candidatii din baza de date:");
    candidatService.AfisCandidati();

    RepartitieService repartitieService = RepartitieService.getInstance();

    Bacalaureat b1 = new Bacalaureat(9.5, 10, 9.6);
    ExamenAdmitere e1 = new ExamenAdmitere("S1" );
    MedieAdmitere ma1 =  new MedieAdmitere(b1,e1);
    repartitieService.add(new Repartitie(c1,specializareService.getSpecializareNume("Informatica"),ma1 ));

    Bacalaureat b2 = new Bacalaureat(9, 9, 9.5);
    ExamenAdmitere e2 = new ExamenAdmitere("S1" );
    MedieAdmitere ma2 =  new MedieAdmitere(b2,e2);
    repartitieService.add(new Repartitie(c2,specializareService.getSpecializareNume("Informatica"),ma2 ));

    Bacalaureat b3 = new Bacalaureat(8.2, 8.3, 9);
    ExamenAdmitere e3 = new ExamenAdmitere("S1" );
    MedieAdmitere ma3 =  new MedieAdmitere(b3,e3);
    repartitieService.add(new Repartitie(c3,specializareService.getSpecializareNume("Informatica"),ma3 ));

    Bacalaureat b4 = new Bacalaureat(10, 10, 10);
    ExamenAdmitere e4 = new ExamenAdmitere("S1" );
    MedieAdmitere ma4 =  new MedieAdmitere(b4,e4);
    repartitieService.add(new Repartitie(c4,specializareService.getSpecializareNume("Informatica"),ma4 ));

    Bacalaureat b5 = new Bacalaureat(7, 10, 8.5);
    ExamenAdmitere e5 = new ExamenAdmitere("S1" );
    MedieAdmitere ma5 =  new MedieAdmitere(b5,e5);
    repartitieService.add(new Repartitie(c5,specializareService.getSpecializareNume("Informatica"),ma5 ));

    Bacalaureat b6 = new Bacalaureat(9.8, 9.9, 9.5);
    ExamenAdmitere e6 = new ExamenAdmitere("S1" );
    MedieAdmitere ma6 =  new MedieAdmitere(b6,e6);
    repartitieService.add(new Repartitie(c6,specializareService.getSpecializareNume("Informatica"),ma6 ));

    Bacalaureat b7 = new Bacalaureat(8, 10, 10);
    ExamenAdmitere e7 = new ExamenAdmitere("S1" );
    MedieAdmitere ma7 =  new MedieAdmitere(b7,e7);
    repartitieService.add(new Repartitie(c7,specializareService.getSpecializareNume("Informatica"),ma7 ));

    Bacalaureat b8 = new Bacalaureat(7, 7.4, 9);
    ExamenAdmitere e8 = new ExamenAdmitere("S1" );
    MedieAdmitere ma8 =  new MedieAdmitere(b8,e8);
    repartitieService.add(new Repartitie(c8,specializareService.getSpecializareNume("Informatica"),ma8));

    Bacalaureat b9 = new Bacalaureat(7, 10, 8.5);
    ExamenAdmitere e9 = new ExamenAdmitere("S1" );
    MedieAdmitere ma9 =  new MedieAdmitere(b9,e9);
    repartitieService.add(new Repartitie(c9,specializareService.getSpecializareNume("Informatica"),ma9 ));

    Bacalaureat b10 = new Bacalaureat(9.8, 10, 10);
    ExamenAdmitere e10 = new ExamenAdmitere("S1" );
    MedieAdmitere ma10 =  new MedieAdmitere(b10,e10);
    repartitieService.add(new Repartitie(c10,specializareService.getSpecializareNume("Informatica"),ma10 ));

    Bacalaureat b11 = new Bacalaureat(6, 7.5, 7);
    ExamenAdmitere e11 = new ExamenAdmitere("S1" );
    MedieAdmitere ma11 =  new MedieAdmitere(b11,e11);
    repartitieService.add(new Repartitie(c11,specializareService.getSpecializareNume("Informatica"),ma11 ));

    Bacalaureat b12 = new Bacalaureat(9, 10, 8.7);
    ExamenAdmitere e12 = new ExamenAdmitere("S2" );
    MedieAdmitere ma12 =  new MedieAdmitere(b12,e12);
    repartitieService.add(new Repartitie(c12,specializareService.getSpecializareNume("Informatica"),ma12 ));

    Bacalaureat b13 = new Bacalaureat(9.2, 8.4, 9.7);
    ExamenAdmitere e13 = new ExamenAdmitere("S2" );
    MedieAdmitere ma13 =  new MedieAdmitere(b13,e13);
    repartitieService.add(new Repartitie(c13,specializareService.getSpecializareNume("Informatica"),ma13 ));

    Bacalaureat b14 = new Bacalaureat(9.5, 9.5, 9.5);
    ExamenAdmitere e14 = new ExamenAdmitere("S1" );
    MedieAdmitere ma14 =  new MedieAdmitere(b14,e14);
    repartitieService.add(new Repartitie(c14,specializareService.getSpecializareNume("Informatica"),ma14 ));


    ExamenAdmitere e15 = new ExamenAdmitere("T7" );
    MedieAdmitere ma15 =  new MedieAdmitere(b14,e15);
    repartitieService.add(new Repartitie(c14,specializareService.getSpecializareNume("CTI"),ma15 ));

    ExamenAdmitere e16 = new ExamenAdmitere("-" );
    Bacalaureat b16 = new Bacalaureat(9.2, 10, 8);
    MedieAdmitere ma16 =  new MedieAdmitere(b16,e16);
    repartitieService.add(new Repartitie(c15,specializareService.getSpecializareNume("Biochimie"),ma16 ));



    repartitieService.updateMedieAdmitere(0, 9.2);
    repartitieService.updateMedieAdmitere(1, 9.5);
    repartitieService.updateMedieAdmitere(2, 10);
    repartitieService.updateMedieAdmitere(3, 8.6);
    repartitieService.updateMedieAdmitere(4, 7.2);
    repartitieService.updateMedieAdmitere(5, 9);
    repartitieService.updateMedieAdmitere(6, 8.5);
    repartitieService.updateMedieAdmitere(7, 9.2);
    repartitieService.updateMedieAdmitere(8, 9.5);
    repartitieService.updateMedieAdmitere(9, 10);
    repartitieService.updateMedieAdmitere(10, 9.9);
    repartitieService.updateMedieAdmitere(11, 6.2);
    repartitieService.updateMedieAdmitere(12, 8);
    repartitieService.updateMedieAdmitere(13, 7.5);
    repartitieService.updateMedieAdmitere(14, 9.35);
    repartitieService.updateMedieAdmitere(15, 8.85);
    repartitieService.updateMedieAdmitere(16, 0);

    System.out.println();
    System.out.println("Toate aplicatiile: ");
    repartitieService.AfisRepartizare();
    System.out.println();


    //Afisare candidati in ordine alfabetica de la o anumita specializare
    System.out.println("Candidatii inscrisi la specializarea Informatica in ordine alfabetica:  ");
    ArrayList<Repartitie> repartizatiAlfabetic = repartitieService.getCandidatiAlfabetic(specializareService.getSpecializareNume("Informatica"));
    for(Repartitie repartitie : repartizatiAlfabetic)
        System.out.println(repartitie);
    System.out.println();

    //Afisare candidati in ordine descrescatoare a mediilor de admitere de la o anumita specializare
    System.out.println("Candidatii inscrisi la specializarea Informatica in ordine descrescatoare a mediilor de admitere:  ");
    ArrayList<Repartitie> repartizatiMedie = repartitieService.getCandidatiMedieDescrescator(specializareService.getSpecializareNume("Informatica"));
    for(Repartitie repartitie : repartizatiMedie)
        System.out.println(repartitie);
    System.out.println();

    //Afisare candidati admisi pe locurile la buget la o anumita specializare
    System.out.println("Candidatii admisi pe locurile la buget la specializarea Informatica: ");
    ArrayList<Repartitie> AdmisiBuget = repartitieService.getAdmisiBuget(specializareService.getSpecializareNume("Informatica"));
    for(Repartitie repartitie : AdmisiBuget)
        System.out.println(repartitie);
    System.out.println();

    //Afisare candidati admisi pe locurile la taxa la o anumita specializare
    System.out.println("Candidatii admisi pe locurile la taxa la specializarea Informatica: ");
    ArrayList<Repartitie> AdmisiTaxa = repartitieService.getAdmisiTaxa(specializareService.getSpecializareNume("Informatica"));
    for(Repartitie repartitie : AdmisiTaxa)
        System.out.println(repartitie);
    System.out.println();

    //Afisare candidati respinsi la o anumita specializare
    System.out.println("Candidatii respinsi la specializarea Informatica: ");
    ArrayList<Repartitie> Respinsi = repartitieService.getRespinsi(specializareService.getSpecializareNume("Informatica"));
    for(Repartitie repartitie : Respinsi)
        System.out.println(repartitie);
    System.out.println();


    System.out.println("Optiunile candidatului Boboc Vlad: ");
    ArrayList<Repartitie> OptiuniCandidat = repartitieService.getOptiuniCandidat(c14);
    for(Repartitie repartitie : OptiuniCandidat)
        System.out.println(repartitie);
    System.out.println();

    //Afisare candidati inscrisi la specializarea Biochimie
    System.out.println("Candidatii inscrisi la specializarea Biochimie in ordine alfabetica:  ");
    ArrayList<Repartitie> repartizatiAlfabetic1 = repartitieService.getCandidatiAlfabetic(specializareService.getSpecializareNume("Biochimie"));
    for(Repartitie repartitie : repartizatiAlfabetic1)
        System.out.println(repartitie);
    System.out.println();

}
}
