public class FactoryB implements AbstractFactory {
    private final UsageFactory usage;

    public FactoryB(UsageFactory usage) {
        this.usage = usage;
    }

    @Override
    public Bulb createBulb() {
        Bulb b = new BulbB();
        b.setPowerUsage(usage.load(getBrand(), "Bulb"));
        return b;
    }

    @Override
    public Lock createLock() {
        Lock l = new LockB();
        l.setBatteryConsumption(usage.load(getBrand(), "Lock"));
        return l;
    }

    @Override
    public String getBrand() { return "BrandB"; }
}
