package trainreservations;

public class FoodServiceDecorator extends TrainRouteDecorator {
    public FoodServiceDecorator(TrainRoute trainRoute) {
        super(trainRoute);
    }

    public void provideFoodService() {
        System.out.println("Food service provided for the train route.");
    }
}