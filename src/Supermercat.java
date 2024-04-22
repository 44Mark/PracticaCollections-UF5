import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


class Supermercat {
    static Scanner sc = new Scanner(System.in);

    //Arraylist on guardarem els productes amb un maxim de 100.
    static ArrayList<Producte> carreto = new ArrayList<Producte>(100);
    public void exclusioArray(String ca) throws Exception {
        if (carreto.size() >= 100) {
            throw new Exception("No pots afegir més de 100 productes al carreto.");
        }
    }

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
                mostrarCarret();
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

        //Validacio perque el codi de barres ha de tenir 6 caracters.
        System.out.println("Codi de barres: (6 caracters) ");
        String codiBarres = sc.nextLine();
        while (codiBarres.length() != 6) {
            System.out.println("El codi de barres ha de tenir 6 caràcters.");
            System.out.println("Codi de barres: (6 caracters) ");
            codiBarres = sc.nextLine();
        }

        //Validacio perque el preu no pot ser negatiu
        System.out.println("Preu: ");
        int preu = sc.nextInt();
        sc.nextLine();
        while (preu <= 0) {
            System.out.println("El preu no pot ser negatiu o amb valor 0, torna a provar.");
            System.out.println("Preu: ");
            preu = sc.nextInt();

            sc.nextLine();
        }

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

        //Validacio perque el codi de barres ha de tenir 6 caracters.
        System.out.println("Codi de barres: (6 caracters) ");
        String codiBarres = sc.nextLine();
        while (codiBarres.length() != 6) {
            System.out.println("El codi de barres ha de tenir 6 caràcters.");
            System.out.println("Codi de barres: (6 caracters) ");
            codiBarres = sc.nextLine();
        }

        //Validacio perque el preu no pot ser negatiu
        System.out.println("Preu: ");
        int preu = sc.nextInt();
        sc.nextLine();
        while (preu <= 0) {
            System.out.println("El preu no pot ser negatiu o amb valor 0, torna a provar.");
            System.out.println("Preu: ");
            preu = sc.nextInt();

            sc.nextLine();
        }

        //Validacio perque la data de caducitat no pot ser avui o anterior.
        System.out.println("Data de caducitat (dd/MM/yyyy): ");
        String dataCaducitatStr = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataCaducitat = LocalDate.parse(dataCaducitatStr, formatter);

        LocalDate avui = LocalDate.now();
        while (!dataCaducitat.isAfter(avui)) {
            System.out.println("La data de caducitat no pot ser avui o anterior a avui.");
            System.out.println("Data de caducitat (dd/MM/yyyy): ");
            dataCaducitatStr = sc.nextLine();
            dataCaducitat = LocalDate.parse(dataCaducitatStr, formatter);
        }

        alimentacio a = new alimentacio(nom, codiBarres, preu, dataCaducitatStr);
        carreto.add(a);
        menuTiquet();
    }

    //Metode per introduir productes de tipus electrònica
    protected static void introduirElectronica() {
        System.out.println("Afegint electrònica: ");
        System.out.println("Omple les següents dades: ");

        System.out.println("Nom producte: ");
        String nom = sc.nextLine();

        //Validacio perque el codi de barres ha de tenir 6 caracters.
        System.out.println("Codi de barres: (6 caracters) ");
        String codiBarres = sc.nextLine();
        while (codiBarres.length() != 6) {
            System.out.println("El codi de barres ha de tenir 6 caràcters.");
            System.out.println("Codi de barres: (6 caracters) ");
            codiBarres = sc.nextLine();
        }

        //Validacio perque el preu no pot ser negatiu
        System.out.println("Preu: ");
        int preu = sc.nextInt();
        sc.nextLine();
        while (preu <= 0) {
            System.out.println("El preu no pot ser negatiu o amb valor 0, torna a provar.");
            System.out.println("Preu: ");
            preu = sc.nextInt();

            sc.nextLine();
        }

        //Validacio perque la garantia no pot ser negativa
        System.out.println("Garantia(dies): ");
        int garantia = sc.nextInt();
        sc.nextLine();
        while (garantia <= 0) {
            System.out.println("La garantia no pot ser negativa o amb valor 0, torna a provar.");
            System.out.println("Garantia(dies): ");
            garantia = sc.nextInt();
            sc.nextLine();
        }

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

        // Creem un hashmap anomenat carret per contar quantes vegades surt un producte en el carreto.
        HashMap<Producte, Integer> carret = new HashMap<>();

        // Bucle per trobar el producte en l'ArrayList i actualitzar el carret.
        for (Producte producte : carreto) {
            if (carret.containsKey(producte)) {
                // Si el producte esta en el carret, sumem 1
                carret.put(producte, carret.get(producte) + 1);
            } else {
                // Si no esta l'afegim a 1.
                carret.put(producte, 1);
            }
        }

        int total = 0;

        // Bucle per llegir el HashMap i mostrar els detalls del producte.
        for (Map.Entry<Producte, Integer> entry : carret.entrySet()) {
            Producte producte = entry.getKey();
            int quantitat = entry.getValue();

            System.out.println(producte.getNom() + " -> " + quantitat + " unitat/s -> " + producte.getPreu() + "€/unitat -> " + producte.getPreu() * quantitat + "€");
            total += producte.getPreu() * quantitat;
        }

        System.out.println("---------------");
        System.out.println("Total: " + total + "€");

        //Netejem Arraylist carreto i hashmap carret.
        carreto.clear();
        carret.clear();

        //Tornem al menu principal.
        menuTiquet();
    }

    //Opció3 Mostrar carret de la compra
    public static void mostrarCarret() {
        HashMap<Producte, Integer> carret = new HashMap<>();

        // Agafem la llista de productes i actualitzem el carret
        for (Producte producte : carreto) {
            if (carret.containsKey(producte)) {
                carret.put(producte, carret.get(producte) + 1);
            } else {
                carret.put(producte, 1);
            }
        }

        // Mostrar els productes i la quantitat
        System.out.println("Carret: ");
        for (Map.Entry<Producte, Integer> entry : carret.entrySet()) {
            Producte producte = entry.getKey();
            int quantitat = entry.getValue();
            System.out.println(producte.getNom() + " -> " + quantitat);
        }
    }
}
