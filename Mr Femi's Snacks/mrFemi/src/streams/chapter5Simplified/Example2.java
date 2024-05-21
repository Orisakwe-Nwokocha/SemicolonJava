package streams.chapter5Simplified;

import java.util.stream.IntStream;

import static java.lang.System.nanoTime;
import static java.lang.System.out;


public class Example2 {
    public static void main(String[] args) {
        int total = 0;
        long start = nanoTime();
        for (int number = 2; number <= 20; number += 2) total += number;
        long end = nanoTime();

        out.println("Sum with external iteration: " + total);
        out.println("Time taken: " + (end - start));


        start = nanoTime();
        total = IntStream.rangeClosed(2, 20).filter((number) -> number % 2 == 0).sum();
        end = nanoTime();
        out.println("Sum with external iteration: " + total);
        out.println("Time taken: " + (end - start));

        out.println(IntStream.rangeClosed(1, 10)
                .map((number) -> number * 2).sum());


    }
}
