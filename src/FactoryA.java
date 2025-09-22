public class FactoryA implements AbstractFactory {
    private final UsageFactory usage;

    public FactoryA(UsageFactory usage) {
        this.usage = usage;
    }

    @Override
    public Bulb createBulb() {
        Bulb b = new BulbA(); // created first
        b.setPowerUsage(usage.load(getBrand(), "Bulb")); // set after creation
        return b;
    }

    @Override
    public Lock createLock() {
        Lock l = new LockA();
        l.setBatteryConsumption(usage.load(getBrand(), "Lock")); // set after creation
        return l;
    }

    @Override
    public String getBrand() { return "BrandA"; }
}
