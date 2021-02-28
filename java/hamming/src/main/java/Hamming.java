import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

public class Hamming {

    private final String leftStrand;

    private final String rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        this.createMessageValidationIfInputsIsNotValid(leftStrand, rightStrand)
                .ifPresent(message -> { throw new IllegalArgumentException(message);});
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    public int getHammingDistance() {
        final int lengthDnas = leftStrand.length();
        final long hammingDistance = IntStream.range(0, lengthDnas)
                .filter(index -> rightStrand.charAt(index) != leftStrand.charAt(index))
                .count();
        return (int) hammingDistance;
    }

    private Optional<String> createMessageValidationIfInputsIsNotValid(String leftStrand, String rightStrand) {
        if(Objects.isNull(leftStrand) || Objects.isNull(rightStrand)) {
            return Optional.of("Inputs cannot be null");
        }
        if(leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            return Optional.of("left strand must not be empty.");
        }
        if(rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            return Optional.of("right strand must not be empty.");
        }
        if(leftStrand.length() != rightStrand.length()) {
            return Optional.of("leftStrand and rightStrand must be of equal length.");
        }
        return Optional.empty();
    }
}
