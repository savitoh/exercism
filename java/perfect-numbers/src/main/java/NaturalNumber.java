import java.util.stream.IntStream;

class NaturalNumber {

    private final int number;
    private final Classification classification;

    NaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
        this.classification = Classification.getFrom(calculateAliquotSum(), number);
    }

    public Classification getClassification() {
        return this.classification;
    }

    private int calculateAliquotSum() {
        return IntStream.range(1, this.number).filter(x -> number % x == 0).sum();
    }
}
