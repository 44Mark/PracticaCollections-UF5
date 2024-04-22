import java.text.SimpleDateFormat;
import java.util.*;

class Supermercat {
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
                passarCaixa();
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

    //Opcio2. L'usuari passa per caixa i dona el tiquet.
    public static void passarCaixa() {
        System.out.println("---------------");
        System.out.println("SAPAMERCAT");
        System.out.println("---------------");
        System.out.println("Data: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        System.out.println("---------------");

        //Creem un hashmap anomenat carret per contar quantes vegades surt un producte en el carreto. String es el codi de barres
        // i int es el nombre de vegades que surt.
        HashMap<String, Integer> carret = new HashMap<String, Integer>();
        //Bucle on revisa el codi de barres dels producte, si el codi esta guardat al carret sumara 1, sino el crea.
        for (Producte producte : carreto) {
            if (carret.containsKey(producte.getCodiBarres())) {
                carret.put(producte.getCodiBarres(), carret.get(producte.getCodiBarres()) + 1);
            } else {
                carret.put(producte.getCodiBarres(), 1);
            }
        }
        //Bucle on recorre el hashmap, per cada producte del hasmap el comparara amb cada producte del carreto(ArrayList), si el codi de barres
        // del producte del hashmap es igual al codi de barres d'un producte del carreto, mostrara el nom del producte, el nombre de vegades que surt,
        // el preu per unitat i el preu total per aquest producte. Finalment enteja la llista
        int total = 0;
        for (Map.Entry<String, Integer> entry : carret.entrySet()) {
            for (Producte producte : carreto) {
                if (producte.getCodiBarres().equals(entry.getKey())) {
                    System.out.println(producte.getNom() + " -> " + entry.getValue() + " unitat/s -> " + producte.getPreu() + "€/unitat -> " + producte.getPreu() * entry.getValue() + "€");
                    total += producte.getPreu() * entry.getValue();
                }
            }
        }
        System.out.println("---------------");
        System.out.println("Total: " + total + "€");

        //Netejem Arraylist carreto i hashmap carret.
        carreto.clear();
        carret.clear();
        menuTiquet();
    }
}