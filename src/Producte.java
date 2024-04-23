import java.util.*;
import java.text.SimpleDateFormat;

public abstract class Producte {
    String nom;
    String codiBarres;
    int preu;

    public Producte(String nom, String codiBarres, int preu) {
        this.nom = nom;
        this.codiBarres = codiBarres;
        this.preu = preu;
    }

    //Setters i Getters basics
    //--------------------------------
    public abstract String getNom();
    public void setNom(String nom) {this.nom = nom;}
    public abstract String getCodiBarres();
    public void setCodiBarres(String codiBarres) {this.codiBarres = codiBarres;}
    public abstract int getPreu();
    public void setPreu(int preu) {this.preu = preu;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producte producte = (Producte) obj;
        return Objects.equals(codiBarres, producte.codiBarres) &&
                preu == producte.preu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codiBarres, preu);
    }

    @Override
    public String toString() {
        return "Producte{" +
                "nom='" + nom + '\'' +
                ", codiBarres='" + codiBarres + '\'' +
                ", preu=" + preu +
                '}';
    }
}