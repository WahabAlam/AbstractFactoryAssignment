public class BulbB implements Bulb {
    private int powerUsage;

    @Override
    public void setPowerUsage(int watts) {
        this.powerUsage = watts;
    }

    @Override
    public void showSpecs() {
        System.out.println("Brand B Bulb - Power usage: " + powerUsage + "W");
    }
}
