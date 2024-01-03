import java.util.Arrays;

public class StudentPoll {
    public static void main(String[] args) {
        int[] responses = {1, 2, 5, 4, 3, 5, 2, 1, 3, 3, 1, 4, 3, 3, 3, 2, 3, 3, 2, 14};
        int[] frequency = new int[6];
        int count1 = 0;
        int count3 = 0;

        for (int answer = 0; answer < responses.length; answer++) {
            try {
                if (responses[answer] == 1) {
                    count1++;
                }
                if (responses[answer] == 3) {
                    count3++;
                }
                frequency[responses[answer]]++;
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
                System.out.printf("\t\tresponses[%d] = %d%n", answer, responses[answer]);
            }
        }

        System.out.println(Arrays.toString(frequency));

        System.out.println("The occurences of answer 1 is " + count1);
        System.out.println("The occurences of answer 3 is " + count3);
    }
}
