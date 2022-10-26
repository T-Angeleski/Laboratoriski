package Labs1;

import java.util.Scanner;

class RabotnaNedela {

    private int[] casovi;
    private int brNedela;

    public RabotnaNedela(int[] casovi, int brNedela) {
        super();
        this.casovi = casovi;
        this.brNedela = brNedela;
    }

    public int getBrojCasovi() {
        return casovi.length;
    }

    public int getVkupnoCasovi() {
        int sum = 0;
        for (int i = 0; i < getBrojCasovi(); i++) {
            sum += casovi[i];
        }
        return sum;
    }

}

class Rabotnik {

    private String ime;
    private RabotnaNedela[] nedeli;

    public Rabotnik(String ime, RabotnaNedela[] nedeli) {
        super();
        this.ime = ime;
        this.nedeli = nedeli;
    }

    public RabotnaNedela[] getNedeli() {
        return nedeli;
    }

    public RabotnaNedela getNedela(int index) {
        return nedeli[index];
    }

    public String getIme() {
        return ime;
    }

}

public class Main {

    public static int sumNedeli(Rabotnik r) {
        int sum = 0;
        for (int i = 0; i < r.getNedeli().length; i++) {
            sum += r.getNedeli()[i].getVkupnoCasovi();
        }
        return sum;
    }

    public static Rabotnik najvreden_rabotnik(Rabotnik[] niza) {
        int max = sumNedeli(niza[0]);
        int maxIndex = 0;
        for (int i = 0; i < niza.length; i++) {
            if (sumNedeli(niza[i]) > max) {
                max = sumNedeli(niza[i]);
                maxIndex = i;
            }
        }
        return niza[maxIndex];
    }

    public static void table(Rabotnik[] niza) {
        System.out.println("Rab   1   2   3   4   Vkupno");
        for (int i = 0; i < niza.length; i++) {
            System.out.print(niza[i].getIme() + "   ");
            for (int j = 0; j < niza[j].getNedeli().length; j++) {
                System.out.print(niza[i].getNedela(j).getVkupnoCasovi() + "   ");
            }
            System.out.println(sumNedeli(niza[i]));
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        Rabotnik[] niza = new Rabotnik[n];
        for (int i = 0; i < n; i++) {
            String ime;
            input.nextLine();
            ime = input.nextLine();
            RabotnaNedela[] rabotniNedeli = new RabotnaNedela[4];

            for (int j = 0; j < 4; j++) {
                int[] casovi = new int[5];

                for (int k = 0; k < 5; k++) {
                    casovi[k] = input.nextInt();
                }
                rabotniNedeli[j] = new RabotnaNedela(casovi, j + 1);
            }
            niza[i] = new Rabotnik(ime, rabotniNedeli);
        }

        table(niza);
        System.out.println("NAJVREDEN RABOTNIK: " + najvreden_rabotnik(niza).getIme());

    }
}


