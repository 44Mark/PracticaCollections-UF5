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

    //Comparable
    @Override
    public int compareTo(Textil o) {
        // Ordenar per composició
        return this.composicio.compareTo(o.composicio);
    }

    // Comparator per comparar per codi de barres
    public static class CodiBarresComparator implements Comparator<Textil> {
        @Override
        public int compare(Textil t1, Textil t2) {
            // Comparar por código de barras
            return t1.getCodiBarres().compareTo(t2.getCodiBarres());
        }
    }
}
