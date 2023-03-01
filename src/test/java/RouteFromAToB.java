import org.junit.jupiter.api.Test;

public class RouteFromAToB {
    @Test
    public void createObjects() {
        Vehicle car = new Vehicle();
        Vehicle train = new Vehicle();
        Vehicle plane = new Vehicle();

        car.setType("Car");
        train.setType("Train");
        plane.setType("Plane");

        car.setFuelConsumption(10);
        train.setFuelConsumption(300);
        plane.setFuelConsumption(300);

        car.setTankCapacity(60);
        train.setTankCapacity(131000);
        plane.setTankCapacity(4500);

        Route fromWarsawToBerlin = new Route();
        Route fromJakartaToSurabaya = new Route();
        Route fromIstanbulToPlovdiv = new Route();

        fromWarsawToBerlin.setDeparture("Warsaw");
        fromWarsawToBerlin.setDestination("Berlin");
        fromWarsawToBerlin.setDistance(517);

        print(car, fromWarsawToBerlin);

        print(train, fromWarsawToBerlin);

        print(plane, fromWarsawToBerlin);

        fromJakartaToSurabaya.setDeparture("Jakarta");
        fromJakartaToSurabaya.setDestination("Surabaya");
        fromJakartaToSurabaya.setDistance(827);

        print(car, fromJakartaToSurabaya);

        print(train, fromJakartaToSurabaya);

        print(plane, fromJakartaToSurabaya);

        fromIstanbulToPlovdiv.setDeparture("Istanbul");
        fromIstanbulToPlovdiv.setDestination("Plovdiv");
        fromIstanbulToPlovdiv.setDistance(422);

        print(car, fromIstanbulToPlovdiv);

        print(train, fromIstanbulToPlovdiv);

        print(plane, fromIstanbulToPlovdiv);

    }

    private static void print(Vehicle car, Route fromWarsawToBerlin) {
        System.out.println("From " + fromWarsawToBerlin.getDeparture() + " to " + fromWarsawToBerlin.getDestination());
        System.out.println(car.getType() + " : " + car.getTankCapacity());
        System.out.println(car.canReachDestination(fromWarsawToBerlin));
    }


}
