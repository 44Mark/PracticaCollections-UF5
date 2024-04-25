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
    public int setPreu(int preu) {this.preu = preu;return preu;}

    //El metode equals i hashcode serveix per comparar dos objectes de la mateixa classe
    @Override
    public boolean equals(Object obj) {
        //Si compara l'objecte amb el mateix que estas passant donara true.
        if (this == obj) return true;
        //Si l'objecte i el que estas passant es null o no son de la mateixa classe donara false
        if (obj == null || getClass() != obj.getClass()) return false;
        //Converteix l'bjecte a la classe producte
        Producte p = (Producte) obj;
        //Compara el codi de barres i el preu de l'objecte amb els de la classe
        return Objects.equals(codiBarres, p.codiBarres) &&
                preu == p.preu;
    }

    //Agafa el codi de barres i el preu i els converteix en un uinc codi de hash per emmagatzemar dades mes tard
    @Override
    public int hashCode() {
        return Objects.hash(codiBarres, preu);
    }
}