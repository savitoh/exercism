import java.math.BigInteger;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

class Grains {

    private static final int MAX_NUMBER_FIELDS = 64;

    private static final int MIN_NUMBER_FIELDS = 1;

    private final BinaryOperator<BigInteger> progressionFunction =
            (subtotal, element) -> subtotal.equals(BigInteger.ZERO)? BigInteger.ONE : subtotal.multiply(BigInteger.valueOf(2));

    BigInteger grainsOnSquare(final int square) {
        if(square < MIN_NUMBER_FIELDS || square > MAX_NUMBER_FIELDS) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return IntStream.rangeClosed(MIN_NUMBER_FIELDS, square)
                .mapToObj(BigInteger::valueOf)
                .reduce(progressionFunction)
                .orElseThrow(RuntimeException::new);
    }

    BigInteger grainsOnBoard() {
        return IntStream.rangeClosed(MIN_NUMBER_FIELDS, MAX_NUMBER_FIELDS)
                .mapToObj(this::grainsOnSquare)
                .reduce(BigInteger::add)
                .get();
    }

}
