public class LockA implements Lock {
    private int batteryConsumption;

    @Override
    public void setBatteryConsumption(int percent) {
        this.batteryConsumption = percent;
    }

    @Override
    public void showSpecs() {
        System.out.println("Brand A Lock - Battery consumption: " + batteryConsumption + "%");
    }
}
