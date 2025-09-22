public interface AbstractFactory {
    Bulb createBulb();
    Lock createLock();
    String getBrand();
}
