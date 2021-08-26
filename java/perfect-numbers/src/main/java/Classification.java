import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiPredicate;

enum Classification {

    DEFICIENT((aliquotSum, number) -> aliquotSum < number),
    PERFECT(Objects::equals),
    ABUNDANT((aliquotSum, number) -> aliquotSum > number);

    private final BiPredicate<Integer, Integer> is;

    Classification(BiPredicate<Integer, Integer> predicate) {
        this.is = predicate;
    }

    public static Classification getFrom(int aliquotSum, int number) {
        return Arrays.stream(Classification.values())
                .filter(c -> c.is.test(aliquotSum, number))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
