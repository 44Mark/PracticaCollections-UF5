import java.util.*;

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
    public int setPreu(int preu) {this.preu = preu;
        return preu;
    }

    //El metode equals i hashcode serveix per comparar dos objectes de la mateixa classe
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

}