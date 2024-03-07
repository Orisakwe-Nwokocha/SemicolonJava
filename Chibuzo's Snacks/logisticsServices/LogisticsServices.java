package logisticsServices;

public class LogisticsServices {
    private static final int BASE_PAY = 5000;

    public static int calculateRidersWage(int successfulDeliveries) {
        validate(successfulDeliveries);

        if (successfulDeliveries < 50) return (successfulDeliveries * 160) + BASE_PAY;
        else if (successfulDeliveries <= 59) return (successfulDeliveries * 200) + BASE_PAY;
        else if (successfulDeliveries <= 69) return (successfulDeliveries * 250) + BASE_PAY;
        else return (successfulDeliveries * 500) + BASE_PAY;
    }

    private static void validate(int successfulDeliveries) {
        if (successfulDeliveries <= 0)
            throw new IllegalArgumentException("Successful deliveries cannot be zero or negative");

        else if (successfulDeliveries > 100)
            throw new IllegalArgumentException("Successful deliveries cannot be greater than 100");
    }
}
