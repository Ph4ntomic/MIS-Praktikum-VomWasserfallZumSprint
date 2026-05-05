import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LagerMini {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] id = new String[10];
        String[] name = new String[10];
        int[] quantity = new int[10];
        int[] minimum = new int[10];
        double[] price = new double[10];

        int count = 0;

        while (true) {
            System.out.println("\n1 Add | 2 Show | 3 Plus | 4 Minus | 5 Export JSON | 0 Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) {
                break;
            }

            if (choice == 1) {
                System.out.print("ID: ");
                id[count] = sc.nextLine();

                System.out.print("Name: ");
                name[count] = sc.nextLine();

                System.out.print("Quantity: ");
                quantity[count] = sc.nextInt();

                System.out.print("Minimum: ");
                minimum[count] = sc.nextInt();

                System.out.print("Price: ");
                price[count] = sc.nextDouble();
                sc.nextLine();

                count++;
            }

            if (choice == 2) {
                for (int i = 0; i < count; i++) {
                    System.out.println(
                        i + " | ID: " + id[i]
                        + " | Name: " + name[i]
                        + " | Quantity: " + quantity[i]
                        + " | Minimum: " + minimum[i]
                        + " | Price: " + price[i]
                    );
                }
            }

            if (choice == 3) {
                System.out.print("Item number: ");
                int number = sc.nextInt();

                System.out.print("Amount: ");
                int amount = sc.nextInt();

                quantity[number] = quantity[number] + amount;
            }

            if (choice == 4) {
                System.out.print("Item number: ");
                int number = sc.nextInt();

                System.out.print("Amount: ");
                int amount = sc.nextInt();

                if (quantity[number] - amount < 0) {
                    System.out.println("Error: Quantity cannot be negative.");
                } else {
                    quantity[number] = quantity[number] - amount;

                    if (quantity[number] < minimum[number]) {
                        System.out.println("Warning: Minimum quantity reached.");
                    }
                }
            }

            if (choice == 5) {
                exportJson(id, name, quantity, minimum, price, count);
            }
        }

        sc.close();
        System.out.println("Program ended.");
    }

    public static void exportJson(
            String[] id,
            String[] name,
            int[] quantity,
            int[] minimum,
            double[] price,
            int count
    ) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("warehouse.json"))) {

            writer.println("[");

            for (int i = 0; i < count; i++) {
                writer.println("  {");
                writer.println("    \"id\": \"" + id[i] + "\",");
                writer.println("    \"name\": \"" + name[i] + "\",");
                writer.println("    \"quantity\": " + quantity[i] + ",");
                writer.println("    \"minimum\": " + minimum[i] + ",");
                writer.println("    \"price\": " + price[i]);
                writer.print("  }");

                if (i < count - 1) {
                    writer.println(",");
                } else {
                    writer.println();
                }
            }

            writer.println("]");

            System.out.println("JSON export completed: warehouse.json");

        } catch (IOException e) {
            System.out.println("Error while exporting JSON.");
        }
    }
}