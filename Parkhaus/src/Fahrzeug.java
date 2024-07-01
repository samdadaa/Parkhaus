import java.util.ArrayList;

public class Fahrzeug
{
    //Member
    private final String nummerSchild;
    private final String fahrzeugArt;
    static ArrayList<Fahrzeug> alleFahrzeugListe= new ArrayList<>();

    // Getter Methoden
    public String getNummerSchild() {return nummerSchild;}
    public String getFahrzeugArt() {return fahrzeugArt;}
    public static ArrayList<Fahrzeug> getAlleFahrzeugListe() {return alleFahrzeugListe;}

    // Konstruktor
    public Fahrzeug(String fahrzeugArt,String nummerSchild) {
        this.nummerSchild = nummerSchild;
        this.fahrzeugArt = fahrzeugArt;
        alleFahrzeugListe.add(this);
    }
}
