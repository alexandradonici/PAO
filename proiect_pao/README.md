Tema nr. 6 – Admitere
Clase:
1.	Candidat – conține numele și prenumele unui candidat, cât și un id al acestuia
2.	Bacalaureat – conține notele la cele 3 probe și calculează media de la bacalaureat
3.	Examen Admitere - conține nota de la examenul de admitere și sala în care este repartizat candidatul
4.	MedieAdmitere – conține informații despre bacalaureat si examenul de admitere și un câmp medie_admitere care va primi nota finală de admitere (calculată în funcție de tipul facultății – cu sau fără admitere)
5.	Facultate – clasa abstractă ce conține numele facultății, un id și o metodă abstractă de calcul medie de admitere
6.	FacultateFărăAdmitere – media de admitere este egală cu media de bacalaureat
7.	FacultateCuAdmitere – media de admitere se calculează ca medie ponderată între media de la bacalaureat și nota de examen
8.	Specializare – conține facultatea din care face parte, număr de locuri la buget, număr de locuri la taxă și un id al specializării
9.	Repartiție – conține aplicația unui candidat și anume păstrează informații despre candidat, media de admitere, specializarea la care s-a înscris și un id al aplicației

Astfel în proiectul meu voi avea obiecte din toate clasele de mai sus, exceptând clasa abstractă Facultate.

Acțiuni și interogări:
1.	Get

•	În clasa CandidatRepository
  -	getCandidatNume (returnează candidatul cu numele respectiv)

•	În clasa FacultateRepository: 
  -	getFacultateNume (preia facultățile după nume)
  -	getFacultatiCuAdmitere (preia facultățile cu examen de admitere)
  -	getFacultățiFărăAdmitere (preia facultățile care nu au examen de admitere)

•	În clasa SpecializareRepository
   -	getSpecializareNume (preia specializările după nume)
   -	getSpecializareFacultate (preia toate specializările unei facultăți)

•	În clasa RepertitieRepository 
  -	getCandidatiPeSpecializari (candidații care au aplicat la o anumită specializare)
  -	getCandidatiPeFacultati (candidații care au aplicat la o anumită facultate)
  -	getCandidatiMedieDescrescator (candidații de la o anumită specializare în ordine descrescătoare
  -	getCandidatiAlfabetic (candidații de la o anumită specializare în ordine alfabetică)
  -	getAdmisiBuget (candidații de la o anumită specializare admiși la buget)
  -	getAdmisiTaxa (candidații de la o anumită specializare admiși la taxă)
  -	getRespinsi (candidații respinși de la o anumită specializare)
  -	getOptiuniCandidat(opțiunile unui anumit candidat)
  -	getInscrisi (toate opțiunile pe toate specializările)

2.	Add: în toate clasele Repository există opțiunea de a adăuga un obiect nou
3.	Remove: în toate clasele Repository există opțiunea de a șterge un obiect 
4.	Update: se poate modifica nota examenului de admitere (implicit și media de admitere); notele candidaților vor fi adăugate ulterior



