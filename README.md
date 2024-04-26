# SAPAMERCAT
Aquest projecte consisteix en la implementació d'un sistema de gestió per al supermercat SAPAMERCAT. Es tracta d'un programa en Java que permet als usuaris afegir productes al carret de la compra, generar tiquets de compra, gestionar el carret i més.


## Classe Producte
La classe `Producte` és la classe pare de tot el projecte. És abstracta i no s'utilitza per crear objectes directament, sinó que serveix com a plantilla per a les subclasses `Alimentacio`, `Textil` i `Electronica`.
### Atributs comuns
```java
String nom;
String codiBarres;
int preu;
```
### Mètodes:
* Getters: Permeten accedir a la informació des de les subclasses.
* Setters: Permeten actualitzar la informació des de les subclasses.
* Equals() i HashCode(): Permeten comparar si dos objectes són iguals pel codi de barres i el preu.


# Subclasse Alimentacio
Atribut de la subclasse;
```java
    String dataCaducitat;
```
### Mètodes:
* Getters: Permeten accedir a la informació del producte.
* Setters: Nom, codi de barres i data de caducitat són invariables. Només es pot actualitzar el preu.
* calcularPreu(): Calcula el preu del producte segons la data de caducitat.
  * Agafara la data de caducitat, la formatara a Date i fara la resta entre "avui" i la data de caducitat per aplicar un descompte o un altre.


# Subclasse Electronica
Atribut de la subclasse;
```java
    int garantia;
```
### Mètodes:
* Getters: Permeten accedir a la informació del producte.
* Setters: Nom, codi de barres i data de caducitat són invariables. Només es pot actualitzar el preu.
* Comparator per poder ordenar els productes per la seva garantia.
* calcularPreu(): Calcula el preu del producte segons el període de garantia.
  * Agafara la garantia, si es superior a 2 anys aplicara un descompte del 10% al preu del producte.
  * Si es inferior a 2 anys aplicara un descompte del 5% al preu del producte.
  * Si es inferior a 1 any no aplicara cap descompte.


# Subclasse Textil
Atribut de la subclasse;
```java
    String composicio;
```
### Mètodes:
* Getters: Permeten accedir a la informació del producte.
* Setters: Nom, codi de barres i data de caducitat són invariables. Només es pot actualitzar el preu.
* Comparable per ordenar per composició


# Classe Supermercat
Classe Supermercat on estaran tots els mètodes per poder afegir productes, eliminar-los, mostrar-los, calcular el preu total de la compra, etc.

Primer de tot tindrem un ArrayList de Productes on guardarem tots els productes que anem afegint amb un maxim de 100.
### 1 Mètode menuTiquet:
Aquest mètode mostrara 4 opcions: 
1. introduirProducte(); -> Obrira un altre menu per escollir quin tipus de producte vols.
2. passarCaixa(); -> Creara un tiquet amb tots els productes afegits i el preu total.
3. mostrarCarret(); -> Mostra els productes del carreto.
4. Sortir -> Sortira del programa.


### 1.1 Mètode introduirProducte:
Aquest mètode mostrara 4 opcions per introduir productes:
1. introduirAlimentacio(); -> Creara un producte de tipus alimentacio.
2. introduirTextil(); -> Creara un producte de tipus textil.
3. introduirElectronica(); -> Creara un producte de tipus electronica.
4. Sortir -> Sortira al menu normal.


### 1.1.1 introduirAlimentacio:
Mètode que demanara el nom, el codi de barres, el preu i la data de caducitat del producte, finalment afegira el producte al ArrayList.

Tindra control d'errors per posar el codi de barres com a maxim 15 caracters, el preu no pot ser negatiu i la data de caducitat haura de ser superior a la data actual.


### 1.1.2 introduirTextil:
Mètode que demanara el nom, el codi de barres, el preu i la composicio del producte, finalment afegira el producte al ArrayList.

Tindra control d'errors per posar el codi de barres com a maxim 15 caracters i el preu no pot ser negatiu.


### 1.1.3 introduirElectronica:
Mètode que demanara el nom, el codi de barres, el preu i els dies de garantia del producte, finalment afegira el producte al ArrayList.

Tindra control d'errors per posar el codi de barres com a maxim 15 caracters i el preu i els dies de garantia no poden ser negatius.


### 1.2 Mètode passarCaixa:
Metode que utilitzara HashMap per mostrar el tiquet amb el nom del producte, la quantitat del producte afegit, el preu per unitat i el preu total del producte, finalment el total de tots els productes.


### 2.1 Mètode comprobarArxiuUpdate:
Metode que s'utilitza per comprobar si la carpeta update i l'arxiu UpdateTextilPrice.dat existeixen, sino els creara tant la carpeta com el .dat.


### 2.2 Mètode comprobarArxiuUpdate:
Metode que s'utilitza per comprobar si la carpeta logs i l'arxiu Exceptions.dat existeixen, sino els creara tant la carpeta com el .dat.


### 3 Mètode comprovarPreuTextil:
Metode que agafara l'arxiu UpdateTextilPrice.dat i comprovara el codi de barres passat amb els codis de barres de l'arxiu, si coincideix i el preu es diferent fara un update del preu del producte.


### 1.3 Mètode mostrarCarret:
Metode que mostrara tots els productes afegits al carreto, donara el nom i la quantitat de cada producte amb lambda.


### 4 Mètode escriureExcepcions:
Metode que selecciona l'arxiu Exceptions.dat dins de la carpeta logs per poder afegir tots els missatges dels catch.