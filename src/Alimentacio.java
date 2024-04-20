import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

class alimentacio extends Producte {

    String dataCaducitat;

    public alimentacio(String nom, String codiBarres, int preu, String dataCaducitat) {
        super(nom, codiBarres, preu);
        this.dataCaducitat = dataCaducitat;
    }

    @Override
    public String getNom() {return this.nom;}

    @Override
    public String getCodiBarres() {return this.codiBarres;}

    @Override
    public int getPreu() {return calcularPreu();}

    public int calcularPreu() {
        DateTimeFormatter formetacio = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataCaducitatDate = LocalDate.parse(this.dataCaducitat, formetacio);
        LocalDate dataActual = LocalDate.now();
        long diff = ChronoUnit.DAYS.between(dataActual, dataCaducitatDate);
        return (int) (this.preu - (this.preu * (1 / (diff + 1))) + (this.preu * 0.1));
    }


}