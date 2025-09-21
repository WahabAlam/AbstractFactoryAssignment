public class FactoryA implements AbstractFactory {
    @Override
    public Bulb createBulb() {
        return new BulbA();
    }

    @Override
    public Lock createLock() {
        return new LockA();
    }
}
