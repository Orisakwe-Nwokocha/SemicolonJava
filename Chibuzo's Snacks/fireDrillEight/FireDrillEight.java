package fireDrillEight;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class FireDrillEight {
    public static int calculateAge(String dob) {
        String[] splitDOB = dob.split("/");
        int dayOfBirth = Integer.parseInt(splitDOB[0]);
        int monthOfBirth = Integer.parseInt(splitDOB[1]);
        int yearOfBirth = Integer.parseInt(splitDOB[2]);

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String currentDate = localDate.format(dateTimeFormatter);

        String[] splitCurrentDate = currentDate.split("/");
        int currentDay = Integer.parseInt(splitCurrentDate[0]);
        int currentMonth = Integer.parseInt(splitCurrentDate[1]);
        int currentYear = Integer.parseInt(splitCurrentDate[2]);

        boolean birthDayIsWithinRange = currentDay >= dayOfBirth;
        boolean birthMonthIsWithinRange = currentMonth >= monthOfBirth;
        boolean dateIsWithinRange = birthDayIsWithinRange && birthMonthIsWithinRange;

        if (dateIsWithinRange) return currentYear - yearOfBirth;

        return (currentYear - yearOfBirth) - 1;
    }

    public static int secondTry(String dob) {
        LocalDate dateOfBirth = LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

}
