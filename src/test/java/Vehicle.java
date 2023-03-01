public class Vehicle {
    private String type;
    private int fuelConsumption;
    private int tankCapacity;

    public boolean canReachDestination(Route route) {
        return tankCapacity > route.getDistance() * fuelConsumption / 100;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
