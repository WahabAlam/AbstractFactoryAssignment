public class MainTest {
    public static void main(String[] args) {
        // Example 1: Brand A Bulb
        AbstractFactory factoryA = new FactoryA();
        Bulb bulbA = factoryA.createBulb();
        bulbA.setPowerUsage(60); // simulate reading from file
        bulbA.showSpecs();

        // Example 2: Brand B Lock
        AbstractFactory factoryB = new FactoryB();
        Lock lockB = factoryB.createLock();
        lockB.setBatteryConsumption(25); // simulate reading from file
        lockB.showSpecs();
    }
}
