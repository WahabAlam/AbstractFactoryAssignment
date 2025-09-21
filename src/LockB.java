public class LockB implements Lock {
    private int batteryConsumption;

    @Override
    public void setBatteryConsumption(int percent) {
        this.batteryConsumption = percent;
    }

    @Override
    public void showSpecs() {
        System.out.println("Brand B Lock - Battery consumption: " + batteryConsumption + "%");
    }
}
