package sevenSegmentDisplay;

import sevenSegmentDisplay.exceptions.NonBinaryNumberException;
import sevenSegmentDisplay.exceptions.NonDigitNumberException;


public class SevenSegmentDisplay {
    private boolean isOn;

    public String displaySegment(String digits) {
        validate(digits);
        changeStatus(digits);

        if (!isOn) return "";

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
            default -> displaySegment(digits.toCharArray());
        };
    }

    public String displaySegment(char... digits) {
        StringBuilder output = new StringBuilder();

        output.append(digits[0] == '1' ? "# # # #" : "       ").append("\n");
        output.append(digits[5] == '1' ? "#    " : "     ");
        output.append(digits[1] == '1' ? " #" : "  ").append("\n");
        output.append(digits[6] == '1' ? "# # # #" : "       ").append("\n");
        output.append(digits[4] == '1' ? "#  " : "   ");
        output.append(digits[2] == '1' ? "   #" : "   ").append("\n");
        output.append(digits[3] == '1' ? "# # # #" : "       ").append("\n");

        return output.toString();
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
        isOn = digits.charAt(7) == '1';
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
