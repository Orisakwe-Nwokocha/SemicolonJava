package streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOperations {
    public static Map<Integer, String> mapCodePointToCharacter(List<Integer> codePoints) {
        return codePoints.stream()
                .collect(Collectors.toMap((codePoint) ->   codePoint, Character::toString, (codePoint1, codePoint2) -> codePoint2));
    }

    public static String getNumbersFormatted(List<Integer> numbers) {
        return numbers.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
    }
}
