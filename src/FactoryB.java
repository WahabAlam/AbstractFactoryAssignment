public class FactoryB implements AbstractFactory {
    @Override
    public Bulb createBulb() {
        return new BulbB();
    }

    @Override
    public Lock createLock() {
        return new LockB();
    }
}
