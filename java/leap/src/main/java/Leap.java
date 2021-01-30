import java.util.function.IntPredicate;

class Leap {

    private static final IntPredicate isDivisibleByFour = year -> year%4==0;

    private static final IntPredicate isDivisibleByHundred = year -> year%100 == 0;

    private static final IntPredicate isDivisibleByHundredAndFourHundred = year -> year%100 == 0 && year%400 == 0;

    boolean isLeapYear(int year) {
        return isDivisibleByFour.and(isDivisibleByHundred.negate().or(isDivisibleByHundredAndFourHundred)).test(year);
    }

}
