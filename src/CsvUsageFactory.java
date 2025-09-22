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
    // map to hold the usage values, key is "brand|product"
    private final Map<String, Integer> table = new HashMap<>();

    public CsvUsageFactory(String csvPath) {
        // read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String line;
            // skip header and empty lines
            while ((line = br.readLine()) != null) {
                line = line.trim();
                // skip empty lines and header
                if (line.isEmpty() || line.toLowerCase().startsWith("brand,product,value")) continue;
                // split line into parts
                String[] parts = line.split(",");
                // ensure we have exactly 3 parts
                if (parts.length != 3) continue;
                // parse brand, product, and value
                String brand   = parts[0].trim().toLowerCase();
                String product = parts[1].trim().toLowerCase();
                int value = Integer.parseInt(parts[2].trim());
                // store in the map with key "brand|product"
                table.put(brand + "|" + product, value);
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
    }
    // this method looks up the usage value for the given brand and product
    @Override
    public int load(String brand, String product) {
        // key is a combination of brand and product in lowercase
        String key = brand.toLowerCase() + "|" + product.toLowerCase();
        // look up the value in the table
        return table.getOrDefault(key, -1); // returns -1 if not found
    }
}
