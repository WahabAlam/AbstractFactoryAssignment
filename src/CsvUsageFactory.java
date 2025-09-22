import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple read-only CSV lookup. No prompts, no writes.
 * CSV format:
 *   brand,product,value
 *   BrandA,Bulb,60
 *   BrandB,Lock,25
 */
public class CsvUsageFactory implements UsageFactory {
    private final Map<String, Integer> table = new HashMap<>();

    public CsvUsageFactory(String csvPath) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.toLowerCase().startsWith("brand,product,value")) continue;
                String[] parts = line.split(",");
                if (parts.length != 3) continue;

                String brand   = parts[0].trim().toLowerCase();
                String product = parts[1].trim().toLowerCase();
                int value = Integer.parseInt(parts[2].trim());

                table.put(brand + "|" + product, value);
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
    }

    @Override
    public int load(String brand, String product) {
        String key = brand.toLowerCase() + "|" + product.toLowerCase();
        return table.getOrDefault(key, -1); // returns -1 if not found
    }
}
