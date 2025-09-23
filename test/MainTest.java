import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        UsageFactory usage = new CsvUsageFactory("data/device_usage.csv");

        // Choose brand
        System.out.print("Choose brand (A/B): ");
        String b = in.nextLine().trim();
        AbstractFactory factory = (b.equalsIgnoreCase("A"))
                ? new FactoryA(usage)
                : new FactoryB(usage);

        // Choose product
        System.out.print("Create which product (Bulb/Lock): ");
        String p = in.nextLine().trim();

        // Create; factories set usage AFTER creation using the CSV
        if (p.equalsIgnoreCase("Bulb")) {
            Bulb bulb = factory.createBulb();
            bulb.showSpecs();
        } else {
            Lock lock = factory.createLock();
            lock.showSpecs();
        }
        in.close();
    }
}
