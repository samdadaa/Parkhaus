import java.util.ArrayList;


public class Etage {
    //Member
    private final ArrayList<Fahrzeug> parkendeFahrzeugListe;
    private int anzahlDerParkpleatze;
    static ArrayList<Etage> etagenListe = new ArrayList<>();

    // Getter Methoden
    public  ArrayList<Fahrzeug> getParkendeFahrzeugListe() {
        return parkendeFahrzeugListe;}

    public int getAnzahlDerParkpleatze() {return anzahlDerParkpleatze;}

    //Konstruktor
    public Etage(int anzahlDerParkpleatze) {
        this.anzahlDerParkpleatze=anzahlDerParkpleatze;
        parkendeFahrzeugListe = new ArrayList<>();
        etagenListe.add(this);
    }
    // sucht den eingegebenen Nummer schild in der Etage-parkendeFahrzeugListe , wenn nicht gefunden, fügt das neue Fahrzeug in die Liste
    // und gibt infos über das Fahrzeug (Etagen nummer, Parkplatznummer ) aus
    public void feugeFahrzeugzumPark(Fahrzeug fahrzeug)
    {
        int i=0;
        int parkplatznummer;
        int etagenummer;
         for (Etage etage: etagenListe)
         {
             for (Fahrzeug fahr : etage.getParkendeFahrzeugListe())
             {
                 if (fahr.getNummerSchild().equalsIgnoreCase(fahrzeug.getNummerSchild()))
                     i++;
             }
         }

        if (i==0)
        {
            parkendeFahrzeugListe.add(fahrzeug);
            parkplatznummer = getParkendeFahrzeugListe().indexOf(fahrzeug)+ 1;
            etagenummer = etagenListe.indexOf(this) +1;
            System.out.println("Vielen Dank ! ");
            System.out.println("Ihr parkplatz befindet sich in: ");
            System.out.println(this.getClass().getSimpleName()+": "+etagenummer);
            System.out.println("Parkplatz-Nummer: "+parkplatznummer);
            System.out.println("__________________________________");
        } else
        {
            System.out.println("Dieses Fahrzeug befindet sich noch im Parkhaus !");
        }

    }
    //Berechnet die freie Parkplätze in der parkendeFahrzeugListe
    public  int freiePleatze()
    {
        int anzahlFreiePleatze = 0;
        for (Fahrzeug f : parkendeFahrzeugListe)
        {anzahlFreiePleatze++;}
        anzahlFreiePleatze=anzahlDerParkpleatze-anzahlFreiePleatze;
        return anzahlFreiePleatze;
    }


}

