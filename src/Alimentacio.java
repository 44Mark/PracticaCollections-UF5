import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

class Alimentacio extends Producte {
    String dataCaducitat;

    public Alimentacio(String nom, String codiBarres, int preu, String dataCaducitat) {
        super(nom, codiBarres, preu);
        this.dataCaducitat = dataCaducitat;
    }

    @Override
    public String getNom() {
        return this.nom;
    }
    @Override
    public String getCodiBarres() {
        return this.codiBarres;
    }
    @Override
    public int getPreu() {
        return calcularPreu();
    }
    @Override
    public int setPreu(int preu) {return this.preu = preu;}

    public int calcularPreu() {
        // Li donem format a la data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //Agafa la variable dataCaducitat i li dona format Date
        LocalDate dataCaducitatt = LocalDate.parse(this.dataCaducitat, formatter);
        // Agafem el dia d'avui
        LocalDate hoy = LocalDate.now();
        // Calculem la diferencia de dies entre la data de caducitat i la data d'avui
        long diff = ChronoUnit.DAYS.between(hoy, dataCaducitatt);
        return (int) (this.preu - (this.preu * (1 / (diff + 1))) + (this.preu * 0.1));
    }
}