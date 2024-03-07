package logisticsServices;

public class LogisticsServices {
    private static final int BASE_PAY = 5000;

    public static int calculateRidersWage(int successfulDeliveries) {
        if (successfulDeliveries <= 0) return 0;
        else if (successfulDeliveries < 50) return (successfulDeliveries * 160) + BASE_PAY;
        else if (successfulDeliveries <= 59) return (successfulDeliveries * 200) + BASE_PAY;
        else if (successfulDeliveries <= 69) return (successfulDeliveries * 250) + BASE_PAY;
        else return (successfulDeliveries * 500) + BASE_PAY;
    }
}
