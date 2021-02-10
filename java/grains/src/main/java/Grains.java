import java.math.BigInteger;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

class Grains {

    private final BinaryOperator<BigInteger> progressionFunction =
            (subtotal, element) -> subtotal.equals(BigInteger.ZERO)? BigInteger.ONE : subtotal.multiply(BigInteger.valueOf(2));

    BigInteger grainsOnSquare(final int square) {
        if(square <= 0 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return IntStream.rangeClosed(1, square)
                .mapToObj(BigInteger::valueOf)
                .reduce(progressionFunction)
                .orElseThrow(RuntimeException::new);
    }

    BigInteger grainsOnBoard() {
        return IntStream.rangeClosed(1, 64)
                .mapToObj(this::grainsOnSquare)
                .reduce(BigInteger::add)
                .get();
    }

}
