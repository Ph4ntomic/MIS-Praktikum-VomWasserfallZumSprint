import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExportJson {

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