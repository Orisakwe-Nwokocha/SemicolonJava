public class AirlineBooking {
    public static void main(String[] args) {
        AirlineReservationsSystem bookTicket = new AirlineReservationsSystem();

        for (int loop = 1; loop <= 11; loop++) {
            bookTicket.airlineReservationsSystem();
        }
    }
}
