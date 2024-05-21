package streams.chapter5Simplified;

import java.util.stream.IntStream;

public class Example3 {
    public static void main(String[] args) {
        System.out.printf(
                "Sum of the triples of the even ints from 2 through 10 is: %d%n",
                IntStream.rangeClosed(1, 10).filter(number -> number % 2 == 0)
                        .map(number -> number * 3)
                        .sum());

        System.out.printf(
                "Sum of the triples of the even ints from 2 through 10 is: %d%n",
                IntStream.rangeClosed(1, 10)
                        .map((number) -> number % 2 == 0 ? number * 3 : 0)
                        .sum());
    }
}
