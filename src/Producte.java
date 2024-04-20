import java.util.*;
import java.text.SimpleDateFormat;

abstract class Producte {
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

    //--------------------------------
}


class TestProducte {
    static Scanner sc = new Scanner(System.in);

    //Arraylist on guardarem els productes amb un maxim de 100.
    static ArrayList<Producte> carreto = new ArrayList<Producte>(100);

    public static void main(String[] args) {
        menuTiquet();
    }

    //Primera pregunta que es fara a l'usuari sobre que vol fer a la nostra botiga.
    public static void menuTiquet() {

        System.out.println("BENVINGUT AL SAPAMERCAT");
        System.out.println("------------");
        System.out.println("--INICI---");
        System.out.println("------------");
        System.out.println("Que vols fer?");
        System.out.println("1) Introduir producte");
        System.out.println("2) Passar per caixa");
        System.out.println("3) Mostrar carret de compra");
        System.out.println("0) Acabar");

        int inici = sc.nextInt();
        sc.nextLine();
        switch (inici) {
            case 1:
                introduirProducte();
                break;
            case 2:
                //passarCaixa();
                break;
            case 3:
                //mostrarCarret();
                break;
            case 0:
                System.out.println("Sortint");
                break;
            default:
                System.out.println("Opció no vàlida, prova un altre cop");
                menuTiquet();
        }
    }

    //L'user escull que tipus de producte vol introduir
    public static void introduirProducte() {
        System.out.println("---------------");
        System.out.println("--PRODUCTE---");
        System.out.println("---------------");
        System.out.println("1) Alimentació");
        System.out.println("2) Tèxtil");
        System.out.println("3) Electrònica");
        System.out.println("0) Tornar");

        int tipusProducte = sc.nextInt();
        sc.nextLine();
        switch (tipusProducte) {
            case 1:
                introduirAlimentacio();
                break;
            case 2:
                introduirTextil();
                break;
            case 3:
                introduirElectronica();
                break;
            case 0:
                System.out.println("Tornant...");
                System.out.println();
                menuTiquet();
                break;
            default:
                System.out.println("Opció no vàlida, prova un altre cop");
                introduirProducte();
                break;
        }
    }

    //Metode per introduir productes de tipus textil
    protected static void introduirTextil() {
        System.out.println("Afegint textil: ");
        System.out.println("Omple les següents dades: ");

        System.out.println("Nom producte: ");
        String nom = sc.nextLine();
        System.out.println("Codi de barres: ");
        String codiBarres = sc.nextLine();
        System.out.println("Preu: ");
        int preu = sc.nextInt();

        sc.nextLine();

        System.out.println("Composicio del producte: ");
        String composicio = sc.nextLine();

        textil t = new textil(nom, codiBarres, preu, composicio);
        carreto.add(t);
        menuTiquet();
    }

    //Metode per introduir productes de tipus alimentació
    protected static void introduirAlimentacio() {
        System.out.println("Afegint alimentació: ");
        System.out.println("Omple les següents dades: ");

        System.out.println("Nom producte: ");
        String nom = sc.nextLine();
        System.out.println("Codi de barres: ");
        String codiBarres = sc.nextLine();
        System.out.println("Preu: ");
        int preu = sc.nextInt();

        sc.nextLine();

        System.out.println("Data de caducitat(dd/MM/yyyy): ");
        String dataCaducitat = sc.nextLine();

        alimentacio a = new alimentacio(nom, codiBarres, preu, dataCaducitat);
        carreto.add(a);
        menuTiquet();
    }

    //Metode per introduir productes de tipus electrònica
    protected static void introduirElectronica() {
        System.out.println("Afegint electrònica: ");
        System.out.println("Omple les següents dades: ");

        System.out.println("Nom producte: ");
        String nom = sc.nextLine();
        System.out.println("Codi de barres: ");
        String codiBarres = sc.nextLine();
        System.out.println("Preu: ");
        int preu = sc.nextInt();

        sc.nextLine();

        System.out.println("Garantia(dies): ");
        int garantia = sc.nextInt();

        electronica e = new electronica(nom, codiBarres, preu, garantia);
        carreto.add(e);
        menuTiquet();
    }
}