import java.util.Comparator;

public class Textil extends Producte implements Comparable<Textil> {
    String composicio;

    public Textil(String nom, String codiBarres, int preu, String composicio) {
        super(nom, codiBarres, preu);
        this.composicio = composicio;
    }

    @Override
    public String getNom() {return this.nom;}
    @Override
    public String getCodiBarres() {return this.codiBarres;}
    @Override
    public int getPreu() {return this.preu;}
    @Override
    public int setPreu(int preu) {return this.preu = preu;}

    //Comparable per composició
    @Override
    public int compareTo(Textil o) {
        // Ordenar per ordre alfabetic la composició
        return this.composicio.compareTo(o.composicio);
    }

    @Override
    public String toString() {
        return "Textil{" +
                "nom='" + nom + '\'' +
                ", codiBarres='" + codiBarres + '\'' +
                ", preu=" + preu +
                ", composicio='" + composicio + '\'' +
                '}';
    }
}
