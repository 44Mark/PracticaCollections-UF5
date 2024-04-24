class textil extends Producte {

    String composicio;

    public textil(String nom, String codiBarres, int preu, String composicio) {
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

}