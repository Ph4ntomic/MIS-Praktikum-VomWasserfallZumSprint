package de.cyzetlc.hsbi.msi;

import com.google.gson.JsonObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final JsonFile file = new JsonFile("./export.json");

    public static void main(String[] args) {
        printHelp();

        while (true) {
            String input = sc.next();

            switch (input) {
                case "0":
                    System.exit(0);
                    break;

                case "1":
                    addEntry();
                    break;

                case "2":
                    showEntries();
                    break;

                case "3":
                    editQuantity();
                    break;

                case "4":
                    editName();
                    break;

                case "5":
                    deleteEntry();
                    break;

                case "6":
                    exportJson();
                    break;

                default:
                    System.out.println("Wähle eine passende Option!");
            }

            printHelp();
        }
    }

    private static void addEntry() {
        Entry entry = new Entry();

        System.out.print("» ID: ");
        entry.setId(sc.next());

        System.out.print("» Name: ");
        String name = sc.next();
        entry.setName(name);

        System.out.print("» Quantity: ");
        entry.setValue(readNumber());

        System.out.print("» Minimum: ");
        entry.setMin(readNumber());

        System.out.print("» Price: ");
        entry.setPrice(readNumber());

        JsonObject obj = file.getObject();
        obj.add(name, file.getGson().toJsonTree(entry));
        file.save(obj);

        System.out.println("\nAngelegt!");
    }

    private static void showEntries() {
        JsonObject obj = file.getObject();

        for (String key : obj.keySet()) {
            Entry entry = JsonFile.loadFromElement(obj.get(key), Entry.class);

            System.out.println("ID » " + entry.getId());
            System.out.println("Name » " + entry.getName());
            System.out.println("Value » " + entry.getValue());
            System.out.println("Min » " + entry.getMin());
            System.out.println("Price » " + entry.getPrice() + "€");
            System.out.println("-----------------------------------------");
        }
    }

    private static void editQuantity() {
        System.out.print("» Name des zu bearbeitenden Elements: ");
        String name = sc.next();

        if (!file.getObject().has(name)) {
            System.out.println("Es wurde kein Element mit diesem Namen gefunden!");
            return;
        }

        JsonObject obj = file.getObject();
        Entry entry = file.getGson().fromJson(obj.get(name), Entry.class);

        System.out.print("» Neue Quantität: ");
        entry.setValue(readNumber());
        obj.remove(name);
        obj.add(name, file.getGson().toJsonTree(entry));
        file.save(obj);

        System.out.println("Element " + name + " wurde erfolgreich bearbeitet!");
    }

    private static void editName() {
        System.out.print("» Name des zu bearbeitenden Elements: ");
        String oldName = sc.next();

        if (!file.getObject().has(oldName)) {
            System.out.println("Es wurde kein Element mit diesem Namen gefunden!");
            return;
        }

        JsonObject obj = file.getObject();
        Entry entry = file.getGson().fromJson(obj.get(oldName), Entry.class);

        System.out.print("» Neuer Name: ");
        String newName = sc.next();

        entry.setName(newName);
        obj.remove(oldName);
        obj.add(newName, file.getGson().toJsonTree(entry));
        file.save(obj);

        System.out.println("Element " + oldName + " wurde erfolgreich bearbeitet!");
    }

    private static void deleteEntry() {
        System.out.print("» Name des zu löschenden Elements: ");
        String name = sc.next();

        if (!file.getObject().has(name)) {
            System.out.println("Es wurde kein Element mit diesem Namen gefunden!");
            return;
        }

        JsonObject obj = file.getObject();
        obj.remove(name);
        file.save(obj);

        System.out.println("Element " + name + " wurde erfolgreich gelöscht!");
    }

    private static void exportJson() {
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        File exportFile =
                new File(file.getPath() + "_"
                        + format.format(new Date()) + ".json");

        try {
            exportFile.createNewFile();

            JsonFile exportJson =
                    new JsonFile(exportFile.getAbsolutePath());
            exportJson.save(file.getObject());

            System.out.println("Gespeichert unter: "
                    + exportFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println(
                    "Fehler beim Erstellen der Datei: "
                            + e.getMessage()
            );
        }
    }

    private static int readNumber() {
        while (true) {
            String input = sc.next();

            if (checkNmbr(input)) {
                return Integer.parseInt(input);
            }

            System.out.println("Bitte gebe eine Nummer ein!");
        }
    }

    public static void printHelp() {
        System.out.println(
                "\n1 Add | 2 Show | 3 Quantität ändern | "
                        + "4 Name ändern | 5 Löschen | "
                        + "6 Export JSON | 0 Exit"
        );
    }

    public static boolean checkNmbr(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}