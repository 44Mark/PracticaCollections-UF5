import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class electronica extends Producte {
    int garantia;

    public electronica(String nom, String codiBarres, int preu, int garantia) {
        super(nom, codiBarres, preu);
        this.garantia = garantia;
    }

    @Override
    public String getNom() {return this.nom;}

    @Override
    public String getCodiBarres() {return this.codiBarres;}

    @Override
    public int getPreu() {return calcularPreu();}

    public int calcularPreu() {
        return (int) (this.preu + (this.preu * (this.garantia / 365) * 0.1));
    }

}