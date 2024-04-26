import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Electronica extends Producte {
    int garantia;

    public Electronica(String nom, String codiBarres, int preu, int garantia) {
        super(nom, codiBarres, preu);
        this.garantia = garantia;
    }

    @Override
    public String getNom() {return this.nom;}
    @Override
    public String getCodiBarres() {return this.codiBarres;}
    @Override
    public int getPreu() {return calcularPreu();}
    @Override
    public int setPreu(int preu) {return this.preu = preu;}

    //Metode per calcular el preu del producte segons els dies de garantia
    public int calcularPreu() {
        return (int) (this.preu + (this.preu * (this.garantia / 365) * 0.1));
    }

}