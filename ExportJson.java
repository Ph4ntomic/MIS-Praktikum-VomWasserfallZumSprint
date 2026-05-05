public static void ExportJson(
        String[] id,
        String[] name,
        int[] quantity,
        int[] minimum,
        double[] price,
        int count
) {
    try (PrintWriter writer = new PrintWriter(new FileWriter("warehouse.json"))) {

        writer.println("["); // Start

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

        writer.println("]"); // Ende

        System.out.println("JSON export completed: warehouse.json");

    } catch (IOException e) {
        System.out.println("Error while exporting JSON.");
    }
}