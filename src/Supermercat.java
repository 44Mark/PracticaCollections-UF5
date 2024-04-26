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
        try {
            System.out.println();
            System.out.println("BENVINGUT AL SAPAMERCAT");
            System.out.println("------------");
            System.out.println("--INICI---");
            System.out.println("------------");
            System.out.println("Que vols fer?");
            System.out.println();

            System.out.println("1) Introduir producte");
            System.out.println("2) Passar per caixa");
            System.out.println("3) Mostrar carret de compra");
            System.out.println("0) Acabar");

            if(!sc.hasNextInt()){
                throw new InputMismatchException("Error, no pots posar una lletra. Torna a executar el programa.");}

            int numero = sc.nextInt();
            sc.nextLine();
            switch (numero) {
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
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    //L'user escullira quin tipus de producte vol afegir.
    public static void introduirProducte() {
        try{
            System.out.println();
            System.out.println("---------------");
            System.out.println("--PRODUCTE---");
            System.out.println("---------------");
            System.out.println("Escull un tipus de producte:");
            System.out.println();

            System.out.println("1) Alimentació");
            System.out.println("2) Tèxtil");
            System.out.println("3) Electrònica");
            System.out.println("0) Tornar");

            if(!sc.hasNextInt()){
                throw new InputMismatchException("Error, no pots posar una lletra. Torna a executar el programa.");}

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
                    menuTiquet();
                    break;
                default:
                    System.out.println("Opció no vàlida, prova un altre cop");
                    introduirProducte();
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            }
    }

    //Metode per introduir productes de tipus alimentació
    protected static void introduirAlimentacio() {
        try {
            System.out.println("Omple les següents dades: ");

            System.out.println("Nom producte: ");
            String nom = sc.nextLine();

            // Validació perque el codi de barres tingui 6 caracters
            System.out.println("Codi de barres: (6 caracters) ");
            String codiBarres = sc.nextLine();
            if (!codiBarres.matches("^\\d{6}$")) {
                throw new IllegalArgumentException("El codi de barres ha de tenir 6 caràcters.");
            }

            // Validació perque el preu no sigui negatiu o 0
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
            Alimentacio a = new Alimentacio(nom, codiBarres, preu, dataCaducitatStr);
            carreto.add(a);

        } catch (DateTimeParseException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Tornem al menu principal.");
            menuTiquet();
        }
    }

    //Metode per introduir productes de tipus textil
    protected static void introduirTextil() {
        try {
            System.out.println("Omple les següents dades: ");

            System.out.println("Nom producte: ");
            String nom = sc.nextLine();

            // Validació perque el codi de barres tingui 6 caracters
            System.out.println("Codi de barres: (6 caracters) ");
            String codiBarres = sc.nextLine();
            if (!codiBarres.matches("^\\d{6}$")) {
                throw new IllegalArgumentException("El codi de barres ha de tenir 6 caràcters.");
            }

            // Validació perque el preu no sigui negatiu o 0
            System.out.println("Preu: ");
            int preu = sc.nextInt();
            sc.nextLine();
            if (preu <= 0) {
                throw new IllegalArgumentException("El preu no pot ser negatiu o amb valor 0, torna a provar.");
            }

            System.out.println("Composició del producte: ");
            String composicio = sc.nextLine();

            // Si tot esta bé crearem l'objecte
            Textil t = new Textil(nom, codiBarres, preu, composicio);
            carreto.add(t);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Tornem al menu principal.");
            menuTiquet();
        }
    }


    //Metode per introduir productes de tipus electrònica
    protected static void introduirElectronica() {
        try {
            System.out.println("Omple les següents dades: ");

            System.out.println("Nom producte: ");
            String nom = sc.nextLine();

            // Validació perque el codi de barres tingui 6 caracters
            System.out.println("Codi de barres: (6 caracters) ");
            String codiBarres = sc.nextLine();
            if (!codiBarres.matches("^\\d{6}$")) {
                throw new IllegalArgumentException("El codi de barres ha de tenir 6 caràcters.");
            }

            // Validació perque el preu no sigui negatiu o 0
            System.out.println("Preu: ");
            int preu = sc.nextInt();
            sc.nextLine();
            if (preu <= 0) {
                throw new IllegalArgumentException("El preu no pot ser negatiu o amb valor 0, torna a provar.");
            }

            // Validació per la garantia no sigui negativa o 0
            System.out.println("Garantia(dies): ");
            int garantia = sc.nextInt();
            sc.nextLine();
            if (garantia <= 0) {
                throw new IllegalArgumentException("La garantia no pot ser negativa o amb valor 0, torna a provar.");
            }

            // Si tot esta bé crearem l'objecte
            Electronica e = new Electronica(nom, codiBarres, preu, garantia);
            carreto.add(e);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Tornem al menu principal.");
            menuTiquet();
        }
    }

    //Opcio2. L'usuari passa per caixa i dona el tiquet.
    public static void passarCaixa() {
        System.out.println();
        System.out.println("---------------");
        System.out.println("SAPAMERCAT");
        System.out.println("---------------");
        System.out.println("Data: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        System.out.println("---------------");
        System.out.println();

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

        // Mostrar els productes i la quantitat amb lambda
        System.out.println("Carreto de la compra: ");
        carret.forEach((p, q) -> {
            System.out.println(p.getNom() + " -> " + q);
        });
    }
}
