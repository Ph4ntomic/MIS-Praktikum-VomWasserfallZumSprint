import java.util.Scanner;

public class LagerMini {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] name = new String[10];
        int[] bestand = new int[10];
        int[] minimum = new int[10];
        int anzahl = 0;

        while (true) {
            System.out.println("\n1 Anlegen | 2 Anzeigen | 3 Plus | 4 Minus | 0 Ende");
            int wahl = sc.nextInt();
            sc.nextLine();

            if (wahl == 0) {
                break;
            }

            if (wahl == 1) {
                System.out.print("Name: ");
                name[anzahl] = sc.nextLine();

                System.out.print("Bestand: ");
                bestand[anzahl] = sc.nextInt();

                System.out.print("Minimum: ");
                minimum[anzahl] = sc.nextInt();

                anzahl++;
            }

            if (wahl == 2) {
                for (int i = 0; i < anzahl; i++) {
                    System.out.println(i + " " + name[i] + " Bestand: " + bestand[i]);
                }
            }

            if (wahl == 3) {
                System.out.print("Artikelnummer: ");
                int nr = sc.nextInt();

                System.out.print("Menge: ");
                int menge = sc.nextInt();

                bestand[nr] = bestand[nr] + menge;
            }

            if (wahl == 4) {
                System.out.print("Artikelnummer: ");
                int nr = sc.nextInt();

                System.out.print("Menge: ");
                int menge = sc.nextInt();

                if (bestand[nr] - menge < 0) {
                    System.out.println("Fehler: Bestand darf nicht negativ werden.");
                } else {
                    bestand[nr] = bestand[nr] - menge;

                    if (bestand[nr] < minimum[nr]) {
                        System.out.println("Warnung: Mindestbestand unterschritten.");
                    }
                }
            }
        }

        sc.close();
        System.out.println("Programm beendet.");
    }
}