import java.util.Scanner;
//Kleines Parkhaus-Programm
// Name: Samer Dadah

//Klasse-Main Methoden
// 0. start
// 1. kundenMenu
// 2. mitarbeiterMenu
// 3. switchCase für Mitarbeiter Menu
// 4. sucheFahrzeug
// 5. parkHausVerlassen
public class Main {

        public static  Scanner scanner = new Scanner(System.in);
        //Member
        public static String kennzeichen;
        public static String fahrzeugArt;
        public static String zuruck ="nein";
        public static String wiederholen;
       public static boolean check= false;

    public static void main(String[] args) throws InterruptedException {

        //Initialisieren Auto-Objekte:
        Fahrzeug auto1= new Fahrzeug("Auto","BM-KL4320");
        Fahrzeug auto2= new Fahrzeug("Motorrad","BM-MW512");
        Fahrzeug auto3= new Fahrzeug("Auto","BM-ES2020");
        Fahrzeug auto4= new Fahrzeug("Auto","BM-XS3030");
        Fahrzeug auto5= new Fahrzeug("Auto","BM-KL44520");
        Fahrzeug auto6= new Fahrzeug("Motorrad","BM-MW572");
        Fahrzeug auto7= new Fahrzeug("Auto","BM-ES2022");
        Fahrzeug auto8= new Fahrzeug("Auto","BM-XS3033");
        Fahrzeug auto9= new Fahrzeug("Auto","k-HL2013");
        Fahrzeug auto10= new Fahrzeug("Auto","k-DR775");
        //Initialisieren 3 Etagen:
        Etage ersteEtage = new Etage(5);
        Etage zweiteEtage = new Etage(5);
        Etage dritteEtage = new Etage(5);
        //Hinfügen Auto-Objekte in eine Etage-Liste
        ersteEtage.getParkendeFahrzeugListe().add(auto3);
        ersteEtage.getParkendeFahrzeugListe().add(auto1);
        ersteEtage.getParkendeFahrzeugListe().add(auto2);
        ersteEtage.getParkendeFahrzeugListe().add(auto4);

        zweiteEtage.getParkendeFahrzeugListe().add(auto5);
        zweiteEtage.getParkendeFahrzeugListe().add(auto6);
        zweiteEtage.getParkendeFahrzeugListe().add(auto7);

        dritteEtage.getParkendeFahrzeugListe().add(auto8);
        dritteEtage.getParkendeFahrzeugListe().add(auto9);
        dritteEtage.getParkendeFahrzeugListe().add(auto10);

        //Start
        start();
    }


    public static void start() throws InterruptedException {
        do {
            int auswahl;
            System.out.println("<<<( Vence Parkhaus )>>>");
            System.out.println("________________________");
            do {
                System.out.println("(1) Kunde\n(2) Mitarbeiter");
                auswahl = scanner.nextInt();
                if (auswahl==1)
                {
                    kundenMenu();
                }
                else if(auswahl==2)
                {
                    mitarbeiterMenu();
                }else
                {
                    System.out.println("Bitte geben Sie 1 oder 2 ein !");
                }
            }while (auswahl!=1 && auswahl !=2);
            System.out.println("Zurück zum Hauptmenü oder beenden? ja/nein");
            wiederholen= scanner.nextLine();
        }while (wiederholen.equalsIgnoreCase("ja"));
    }
    // Parkhaus-Verlassen Methode, sucht das Fahrzeug und löscht Das Fahrzeug aus der ParkendeFahrzeugListe
    public static void parkHausVerlassen(String kennzeichen) throws InterruptedException {
        int parkplatznummer;
        int etagenummer;
        boolean check=false;
        for (Etage etage: Etage.etagenListe)
        {
            for (Fahrzeug fahrzeug: etage.getParkendeFahrzeugListe())
            {
                if (fahrzeug.getNummerSchild().equalsIgnoreCase(kennzeichen)) {
                    parkplatznummer = etage.getParkendeFahrzeugListe().indexOf(fahrzeug) + 1;
                    etagenummer = etage.etagenListe.indexOf(etage) + 1;

                    etage.getParkendeFahrzeugListe().remove(fahrzeug);

                    System.out.println("Vielen Dank ! ");
                    Thread.sleep(500);
                    System.out.println("Ihr Fahrzeug mit dem Nummer-schild: " + kennzeichen.toUpperCase());
                    Thread.sleep(500);
                    System.out.println("befindet sich in: ");
                    Thread.sleep(500);
                    System.out.println("Etage: "+etagenummer);
                    System.out.println("Parkplatz-Nummer: " + parkplatznummer);
                    Thread.sleep(500);
                    System.out.println("Sie haben 10 Minuten, um das Parkhaus zu verlassen ");
                    Thread.sleep(500);
                    System.out.println("Gute Fahrt ! Auf wiedersehen :)");
                    check=true;
                    break;
                }
            }
        }
        if (!check)
        {
            System.out.println("Es gibt kein Fahrzeug mit dem Nummer-Schild: "+kennzeichen.toUpperCase()+" !!");
        }
    }
    // Fahrzeug-Suchen Methode in allen Etagen-Listen für Main Methode
    public static void sucheFahrzeug(String kennzeichen)
    {
        int parkplatznummer;
        int etagenummer;
        boolean check=false;
        for (Etage etage: Etage.etagenListe)
        {
            for (Fahrzeug fahrzeug: etage.getParkendeFahrzeugListe())
            {
                if (fahrzeug.getNummerSchild().equalsIgnoreCase(kennzeichen)) {
                    parkplatznummer = etage.getParkendeFahrzeugListe().indexOf(fahrzeug) + 1;
                    etagenummer = etage.etagenListe.indexOf(etage) + 1;

                    System.out.println("Das suchende Fahrzeug mit dem Nummer-schild: " + kennzeichen.toUpperCase());
                    System.out.println("befindet sich in: ");
                    System.out.println("Etage: "+etagenummer);
                    System.out.println("Parkplatz-Nummer: " + parkplatznummer);
                    check=true;
                    break;
                }
            }
        }
        if (!check)
        {
            System.out.println("Es gibt kein Fahrzeug mit dem Nummer-Schild: "+kennzeichen.toUpperCase()+" !!");
        }
    }

    public static void switchCase(int option)
    {
        switch (option)
        {
            case 1:
                System.out.println("Geben Sie Ihr Kennzeichen ein:");

                kennzeichen= scanner.nextLine();
                sucheFahrzeug(kennzeichen);
                check=true;
                break;
            case 2:
                int anzahlDerPleatze=0;
                for (Etage etage: Etage.etagenListe)
                {
                    anzahlDerPleatze= anzahlDerPleatze+ etage.freiePleatze();
                }
                System.out.println("Anzahl der Freien Plätze in Allen Etagen:  "+anzahlDerPleatze);
                check=true;
                break;
            case 3:
                int etagenummer;
                int parkplatznummer;
                for (Etage etage : Etage.etagenListe)
                {
                    etagenummer = Etage.etagenListe.indexOf(etage) +1;
                    System.out.println("Etage: "+etagenummer);
                    for (Fahrzeug fahrzeug: etage.getParkendeFahrzeugListe())
                    {
                        parkplatznummer =etage.getParkendeFahrzeugListe().indexOf(fahrzeug)+ 1;
                        System.out.println("Fahrzeug-Art: "+fahrzeug.getFahrzeugArt()+" || Nummer-Schild: "+fahrzeug.getNummerSchild()+" || Parkplatz-Nr: "+parkplatznummer);

                    }
                    System.out.println("_______________________________________");
                    check=true;
                }
                break;
            case 4:
                int i=0;
                for (Fahrzeug fahrzeug : Fahrzeug.alleFahrzeugListe)
                {
                    i++;
                    System.out.println(fahrzeug.getClass().getSimpleName()+": "+i+" [ Fahrzeug-Art: "+fahrzeug.getFahrzeugArt()+" | Nummer-Schild: "+fahrzeug.getNummerSchild()+" ]");
                }
                check=true;
                break;
            default:
                System.out.println("Falsche Eingabe !! ");
        }
    }

    public static void kundenMenu() throws InterruptedException {
        int kundeAuswahl;
        System.out.println("_________________________________");
        System.out.println("Willkommen in unserem Parkhaus :)");
        do {
            do {
                System.out.println("(1) Parken\n(2) Verlssen");
                kundeAuswahl= scanner.nextInt();
                System.out.println("_______________________________________");
                if (kundeAuswahl==1)
                {
                    scanner.nextLine();
                    System.out.println("Bitte Fahrzeugart eingeben Auto/Motorrad:");
                    fahrzeugArt= scanner.nextLine();
                    System.out.println("Bitte Kennzeichen eingeben:");
                    kennzeichen= scanner.nextLine();

                    for (Etage etage:Etage.etagenListe)
                    {
                        if (etage.freiePleatze()>0)
                        {
                            System.out.println("___________________________");
                            etage.feugeFahrzeugzumPark(new Fahrzeug(fahrzeugArt,kennzeichen));
                            check=true;
                            break;
                        }else
                        {
                            int etageNummer= Etage.etagenListe.indexOf(etage)+1;
                            System.out.println("keine Plätze in Etage: "+etageNummer);
                            check=true;
                        }
                    }
                }else if (kundeAuswahl==2)
                {
                    System.out.println("Geben Sie Ihr Kennzeichen ein:");
                    scanner.nextLine();
                    kennzeichen= scanner.nextLine();
                    parkHausVerlassen(kennzeichen);

                    check=true;

                }else {
                    System.out.println("Bitte geben Sie 1 oder 2 ein !");
                }
                if (check)
                {
                    System.out.println("zurück zum Menü ? ja/nein");
                    zuruck = scanner.nextLine();
                }
            }while (zuruck.equalsIgnoreCase("ja"));
        }while (kundeAuswahl!=1 && kundeAuswahl!=2);
    }

    public static void mitarbeiterMenu()
    {
        System.out.println("_______________________________________");
        System.out.println("<<<( Die Verwaltung das Parkhaus )>>>");
        do {
            System.out.println("(1) Nach einem Fahrzeug suchen\n(2) Anzahl der freien Plätze abfragen");
            System.out.println("(3) Liste aller Parkenden Fahrzeuge ");
            System.out.println("(4) Liste Alle Fahrzeuge die schon mal hier geparkt haben ");
            int option;
            option= scanner.nextInt();
            scanner.nextLine();
            switchCase(option);
            System.out.println("_______________________________________");
            if (check)
            {
                System.out.println("zurück zum Menü ? ja/nein");
                zuruck = scanner.nextLine();
            }
        }while(zuruck.equalsIgnoreCase("ja"));
    }

}