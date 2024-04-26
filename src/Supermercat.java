import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
            System.out.println("Error: " + e.getMessage());
            escriureExcepcions("Error al metode menuTiquet() -->" + e.getMessage());
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
            System.out.println("Error: " + e.getMessage());
            escriureExcepcions("Error al metode introduirProducte() -->" + e.getMessage());
            }
    }

    //Metode per introduir productes de tipus alimentació
    protected static void introduirAlimentacio() {
        try {
            System.out.println("Omple les següents dades: ");

            System.out.println("Nom producte: ");
            String nom = sc.nextLine();

            // Validació perque el codi de barres tingui 6 caracters
            System.out.println("Codi de barres: (Maxim 15 caracters) ");
            String codiBarres = sc.nextLine();
            if (!codiBarres.matches("^\\d{1,15}$")) {
                throw new IllegalArgumentException("El codi de barres ha de tenir maxim 15 caràcters.");
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
            escriureExcepcions("Error al metode introduirAlimentacio -->" + e.getMessage());
        }
    }

    //Metode per introduir productes de tipus textil
    protected static void introduirTextil() {
        try {
            System.out.println("Omple les següents dades: ");

            System.out.println("Nom producte: ");
            String nom = sc.nextLine();

            // Validació perque el codi de barres tingui 6 caracters
            System.out.println("Codi de barres: (Maxim 15 caracters) ");
            String codiBarres = sc.nextLine();
            if (!codiBarres.matches("^\\d{1,15}$")) {
                throw new IllegalArgumentException("El codi de barres ha de tenir maxim 15 caràcters.");
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
            escriureExcepcions("Error al metode introduirTextil -->" + e.getMessage());
        }
    }

    //Metode per introduir productes de tipus electrònica
    protected static void introduirElectronica() {
        try {
            System.out.println("Omple les següents dades: ");

            System.out.println("Nom producte: ");
            String nom = sc.nextLine();

            // Validació perque el codi de barres tingui 6 caracters
            System.out.println("Codi de barres: (Maxim 15 caracters) ");
            String codiBarres = sc.nextLine();
            if (!codiBarres.matches("^\\d{1,15}$")) {
                throw new IllegalArgumentException("El codi de barres ha de tenir maxim 15 caràcters.");
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
            escriureExcepcions("Error al metode introduirElectronica -->" + e.getMessage());
        }
    }

    //Opcio2. L'usuari passa per caixa i dona el tiquet.
    String ruta = "updates/UpdateTextilPrices.dat";
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

            //Si el producte es de tipus Textil, comprovem el preu.
            if(producte instanceof Textil){
                comprovarPreuTextil(producte);
            }
            System.out.println(producte.getNom() + " -> " + quantitat + " unitat/s -> " + producte.getPreu() + "€/unitat -> " + producte.getPreu() * quantitat + "€");
            total += producte.getPreu() * quantitat;
        }

        System.out.println("---------------");
        System.out.println("Total: " + total + "€");

        //Netejem Arraylist carreto i hashmap carret.
        carreto.clear();
        carret.clear();
    }
    //Comprovar si l'arxiu UpdateTextilPrices.dat existeix
    private static void comprobarArxiu() throws IOException {
        boolean arx = true;
        boolean packkx = true;

        try {
            File arxiu = new File("updates/UpdateTextilPrices.dat");
            File pack = new File("updates");
            //Si la carpeta no esta creada doanra l'error
            if (!pack.exists()) {
                arx = false;
                throw new IllegalArgumentException("La carpeta no existeix.");
            //Si l'arxiu no esta creat donara l'error
            } if (!arxiu.exists()) {
                packkx = false;
                throw new IllegalArgumentException("L'arxiu no existeix.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            escriureExcepcions("Error al metode comprovarArxiu() -->" + e.getMessage());
        }

        //Si no existeix la carpeta ni l'arxiu, els creara
        if(packkx == false){
            File pack = new File("updates");
            pack.mkdir();
            System.out.printf("Carpeta creada amb èxit.");
        } if(arx == false){
            File arxiu = new File("updates/UpdateTextilPrices.dat");
            arxiu.createNewFile();
            System.out.printf("Arxiu creat amb èxit.");
        }
    }

    //Metode per comprovar el preu dels textils al .dat
    public static void comprovarPreuTextil(Producte p) {
        try {
            Scanner sca = new Scanner(new File("updates/UpdateTextilPrices.dat"));
            //Bucle per llegir les linies de l'arxiu
            while (sca.hasNextLine()) {
                //Agafem tota la linea
                String linia = sca.nextLine();
                //Separem la linea per les comes
                String[] parts = linia.split(",");
                //Fem les variables per guardar els valors
                String codiBarres = parts[0];
                int preu = Integer.parseInt(parts[1]);

                //Si el codi de barres del producte es igual al codi de barres de l'arxiu, actualitzem el preu
                if(codiBarres.equals(p.getCodiBarres())){
                    p.setPreu(preu);

                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            escriureExcepcions("Error al metode comprovarPreuTextil -->" + e.getMessage());
        }
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

    //Metode per escriure tots els missatges de excepcions dins del meu arxiu /logs/Exceptions.dat
    public static void escriureExcepcions(String missatge) {
        try {
            FileWriter ae = new FileWriter("logs/Exceptions.dat", true);
            ae.write(missatge + "\n");
            ae.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            escriureExcepcions("Error al metode escriureExcepcions -->" + e.getMessage());
        }
    }
}
