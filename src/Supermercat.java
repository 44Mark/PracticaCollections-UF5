import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

    //L'user escullira quin tipus de producte vol afegir.
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
                System.out.println();
                introduirProducte();
                break;
        }
    }

    //Metode per introduir productes de tipus alimentació
    protected static void introduirAlimentacio() {
        try {
            System.out.println("Afegint alimentació: ");
            System.out.println("Omple les següents dades: ");

            System.out.println("Nom producte: ");
            String nom = sc.nextLine();

            // Validación para que el código de barras tenga 6 caracteres
            System.out.println("Codi de barres: (6 caracters) ");
            String codiBarres = sc.nextLine();
            if (!codiBarres.matches("^\\d{6}$")) {
                throw new IllegalArgumentException("El codi de barres ha de tenir 6 caràcters.");
            }

            // Validación para que el precio no sea negativo
            System.out.println("Preu: ");
            int preu = sc.nextInt();
            sc.nextLine();
            if (preu <= 0) {
                throw new IllegalArgumentException("El preu no pot ser negatiu o amb valor 0, torna a provar.");
            }

            // Validació perque la data de caducitat no sigui avui o anterior.
            System.out.println("Data de caducitat (dd/MM/yyyy): ");
            String dataCaducitatStr = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataCaducitat = LocalDate.parse(dataCaducitatStr, formatter);
            LocalDate avui = LocalDate.now();
            if (!dataCaducitat.isAfter(avui)) {
                throw new IllegalArgumentException("La data de caducitat no pot ser avui o anterior a avui.");
            }

            // Si tot esta bé crearem l'objecte
            alimentacio a = new alimentacio(nom, codiBarres, preu, dataCaducitatStr);
            carreto.add(a);

        } catch (DateTimeParseException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println();
            System.out.println("Torna a provar");
            System.out.println();

            menuTiquet();
        }
    }

    //Metode per introduir productes de tipus textil
    protected static void introduirTextil() {
        try {
            System.out.println("Afegint textil: ");
            System.out.println("Omple les següents dades: ");

            System.out.println("Nom producte: ");
            String nom = sc.nextLine();

            // Validación para que el código de barras tenga 6 caracteres
            System.out.println("Codi de barres: (6 caracters) ");
            String codiBarres = sc.nextLine();
            if (!codiBarres.matches("^\\d{6}$")) {
                throw new IllegalArgumentException("El codi de barres ha de tenir 6 caràcters.");
            }

            // Validación para que el precio no sea negativo
            System.out.println("Preu: ");
            int preu = sc.nextInt();
            sc.nextLine();
            if (preu <= 0) {
                throw new IllegalArgumentException("El preu no pot ser negatiu o amb valor 0, torna a provar.");
            }

            System.out.println("Composicio del producte: ");
            String composicio = sc.nextLine();

            // Crear el objeto 'textil' si las validaciones son exitosas
            textil t = new textil(nom, codiBarres, preu, composicio);
            carreto.add(t);

        } catch (IllegalArgumentException e) {
            // Capturar excepciones de validación
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Mostrar mensaje y volver a solicitar la entrada del producto
            System.out.println();
            System.out.println("Torna a provar");
            System.out.println();

            menuTiquet();
        }
    }


    //Metode per introduir productes de tipus electrònica
    protected static void introduirElectronica() {
        try {
            System.out.println("Afegint electrònica: ");
            System.out.println("Omple les següents dades: ");

            System.out.println("Nom producte: ");
            String nom = sc.nextLine();

            // Validación para que el código de barras tenga 6 caracteres
            System.out.println("Codi de barres: (6 caracters) ");
            String codiBarres = sc.nextLine();
            if (!codiBarres.matches("^\\d{6}$")) {
                throw new IllegalArgumentException("El codi de barres ha de tenir 6 caràcters.");
            }

            // Validación para que el precio no sea negativo
            System.out.println("Preu: ");
            int preu = sc.nextInt();
            sc.nextLine();
            if (preu <= 0) {
                throw new IllegalArgumentException("El preu no pot ser negatiu o amb valor 0, torna a provar.");
            }

            // Validación para que la garantía no sea negativa
            System.out.println("Garantia(dies): ");
            int garantia = sc.nextInt();
            sc.nextLine();
            if (garantia <= 0) {
                throw new IllegalArgumentException("La garantia no pot ser negativa o amb valor 0, torna a provar.");
            }

            // Crear el objeto 'electronica' si las validaciones son exitosas
            electronica e = new electronica(nom, codiBarres, preu, garantia);
            carreto.add(e);

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        } finally {

            System.out.println();
            System.out.println("Torna a provar");
            System.out.println();

            menuTiquet();
        }
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
