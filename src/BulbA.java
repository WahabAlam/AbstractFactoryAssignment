public class BulbA implements Bulb {
    private int powerUsage;

    @Override
    public void setPowerUsage(int watts) {
        this.powerUsage = watts;
    }

    @Override
    public void showSpecs() {
        System.out.println("Brand A Bulb - Power usage: " + powerUsage + "W");
    }
}
