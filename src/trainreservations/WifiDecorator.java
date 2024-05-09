package trainreservations;

public class WifiDecorator extends TrainRouteDecorator {
    public WifiDecorator(TrainRoute trainRoute) {
        super(trainRoute);
    }

    public void provideWifiService() {
        System.out.println("WiFi service provided for the train route.");
    }
}