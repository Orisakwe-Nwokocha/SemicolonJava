package mrFemi.tasks;

import java.util.ArrayList;
import java.util.List;

public class HugeInteger {
    private final List<Integer> digits = new ArrayList<>();;

    public HugeInteger parse(String numbers) {
        validate(numbers);
        digits.clear();

        int start = 0;
        boolean isNegative = numbers.charAt(0) == '-';
        if (isNegative) {
            int digit = numbers.charAt(1) - '0';
            digits.add(-digit);
            start = 2;
        }

        for (int index = start; index < numbers.length(); index++) {
            int digit = numbers.charAt(index) - '0';
            digits.add(digit);
        }
        return this;
    }

    public HugeInteger add(HugeInteger other) {
        if (other.digits.getFirst() < 0) return parse(privateSubtract(other, true, false));
        else if (digits.getFirst() < 0) return parse("-" + privateSubtract(other, false, true));
        return getHugeIntegerAfterAdding(other);
    }


    public HugeInteger subtract(HugeInteger other) {
        if (other.digits.getFirst() < 0) return parse(privateAdd(other, true, false));
        else if (digits.getFirst() < 0) return parse("-" + privateAdd(other, false, true));

        return getHugeIntegerAfterSubtracting(other);
    }

    public boolean isEqualTo(HugeInteger hugeInteger) {
        return this.toString().equals(hugeInteger.toString());
    }

    public boolean isNotEqualTo(HugeInteger hugeInteger) {
        return !this.toString().equals(hugeInteger.toString());
    }

    public boolean isGreaterThan(HugeInteger hugeInteger) {
        return this.toString().compareTo(hugeInteger.toString()) > 0;
    }

    public boolean isLessThan(HugeInteger hugeInteger) {
        return this.toString().compareTo(hugeInteger.toString()) < 0;
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger hugeInteger) {
        return this.toString().compareTo(hugeInteger.toString()) >= 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int digit : digits) result.append(digit);

        return result.toString();
    }

    private static void validate(String numbers) {
        if (numbers == null) throw new IllegalArgumentException("number should not null");
        String regex = "\\d|((-?[1-9]|[1-9])\\d*)";
        if (!numbers.matches(regex)) throw new IllegalArgumentException("invalid data");
    }

    private void privateParse(String numbers) {
        digits.clear();

        for (int index = 0; index < numbers.length(); index++) {
            int digit = numbers.charAt(index) - '0';
            digits.add(digit);
        }
    }

    private String privateAdd(HugeInteger other, boolean otherFlag, boolean thisFlag) {
        if (otherFlag) other.parse(other.toString().substring(1));
        else if (thisFlag) parse(toString().substring(1));

        return getHugeIntegerAfterAdding(other).toString();
    }

    private HugeInteger getHugeIntegerAfterAdding(HugeInteger other) {
        StringBuilder result = new StringBuilder();

        if (other.toString().length() < toString().length()) other.privateParse("0" + other.toString());
        else if (toString().length() < other.toString().length()) privateParse("0" + toString());

        int extra = 0;
        for (int i = digits.size() - 1; i >= 0; i--) {
            int sum = digits.get(i) + other.digits.get(i) + extra;
            result.append(sum % 10);
            extra = sum / 10;
        }

        if (extra > 0) result.append(extra);

        return parse(result.reverse().toString());
    }

    private String privateSubtract(HugeInteger other, boolean otherFlag, boolean thisFlag) {
        if (otherFlag) other.parse(other.toString().substring(1));
        else if (thisFlag) parse(toString().substring(1));

        return getHugeIntegerAfterSubtracting(other).toString();
    }

    private HugeInteger getHugeIntegerAfterSubtracting(HugeInteger other) {
        StringBuilder result = new StringBuilder();

        if (other.toString().length() < toString().length()) other.privateParse("0" + other.toString());
        else if (toString().length() < other.toString().length()) privateParse("0" + toString());

        int borrow = 0;
        boolean isLessThan = isLessThan(other);

        for (int i = digits.size() - 1; i >= 0; i--) {
            int swapped = other.digits.get(i) - digits.get(i);
            int normal = digits.get(i) - other.digits.get(i);

            int difference = isLessThan ? swapped - borrow : normal - borrow;

            if (difference < 0) {
                difference += 10;
                borrow = 1;
                result.append(difference);
                continue;
            }

            result.append(difference);
            borrow = 0;
        }

        while (result.length() > 1 && result.charAt(result.length() - 1) == '0')
            result.deleteCharAt(result.length() - 1);

        if (isLessThan) result.append("-");

        return parse(result.reverse().toString());
    }

}
