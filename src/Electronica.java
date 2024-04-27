import java.util.Comparator;


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

    //Comparator per ordenar per els dies de garantia
    public static Comparator<Electronica> comparadorGarantia = new Comparator<Electronica>() {
        @Override
        public int compare(Electronica o1, Electronica o2) {
            return o1.garantia - o2.garantia;
        }
    };

}