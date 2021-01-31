import java.util.stream.IntStream;

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        final char[] digits = String.valueOf(numberToCheck).toCharArray();
        final double sumOfDigitsRaisedSize = IntStream.range(0, digits.length)
                .mapToObj(index -> digits[index])
                .mapToDouble(Character::getNumericValue)
                .map(digit -> Math.pow(digit, digits.length))
                .sum();
        return sumOfDigitsRaisedSize == numberToCheck;
    }

}
