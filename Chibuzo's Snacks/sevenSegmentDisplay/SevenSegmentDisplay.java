package sevenSegmentDisplay;

import sevenSegmentDisplay.exceptions.NonBinaryNumberException;
import sevenSegmentDisplay.exceptions.NonDigitNumberException;

public class SevenSegmentDisplay {

    private boolean isOn;

    public String displaySegment(String digits) {
        validate(digits);
        changeStatus(digits);

        return switch (digits) {
            case "11111101" -> displayZero();
            case "01100001" -> displayOne();
            case "11011011" -> displayTwo();
            case "11110011" -> displayThree();
            case "01100111" -> displayFour();
            case "10110111" -> displayFive();
            case "10111111" -> displaySix();
            case "11100001" -> displaySeven();
            case "11111111" -> displayEight();
            case "11110111" -> displayNine();
            default -> "";
        };
    }

    private static String displayZero() {
        return """
                # # # #
                #     #
                #     #
                #     #
                # # # #
                """;
    }

    private String displayOne() {
        return """
                      #
                      #
                      #
                      #
                      #
                """;
    }

    private String displayTwo() {
        return """
                # # # #
                      #
                # # # #
                #
                # # # #
                """;
    }
    private String displayThree() {
        return """
                # # # #
                      #
                # # # #
                      #
                # # # #
                """;
    }
    private String displayFour() {
        return """
                #     #
                #     #
                # # # #
                      #
                      #
                """;
    }
    private String displayFive() {
        return """
                # # # #
                #
                # # # #
                      #
                # # # #
                """;
    }
    private String displaySix() {
        return """
                # # # #
                #
                # # # #
                #     #
                # # # #
                """;
    }
    private String displaySeven() {
        return """
                # # # #
                      #
                      #
                      #
                      #
                """;
    }
    private String displayEight() {
        return """
                # # # #
                #     #
                # # # #
                #     #
                # # # #
                """;
    }
    private String displayNine() {
        return """
                # # # #
                #     #
                # # # #
                      #
                # # # #
                """;
    }
    private void changeStatus(String digits) {
        if (digits.charAt(7) == '0') isOn = false;
        else if (digits.charAt(7) == '1') isOn = true;
    }

    private static void validate(String digits) {
        if (!digits.matches("\\d+")) throw new NonDigitNumberException("Binary number must be only digits");
        if (!digits.matches("[0-1]+")) throw new NonBinaryNumberException("Binary number must consist of only 0s and 1s");
        if (digits.length() != 8) throw new IllegalArgumentException("Binary number must be 8 digits long");
    }

    public boolean isOn() {
        return isOn;
    }
}
