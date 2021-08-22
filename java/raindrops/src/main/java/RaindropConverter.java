import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

class RaindropConverter {

    private static final Map<Integer, String> factorMap = new HashMap<>();

    static {
        factorMap.put(3, "Pling");
        factorMap.put(5, "Plang");
        factorMap.put(7, "Plong");
    }

    String convert(int number) {
        return IntStream.rangeClosed(1, number)
                .filter(x -> number % x == 0)
                .boxed()
                .map(factorMap::get)
                .filter(Objects::nonNull)
                .reduce((partialString, element) -> partialString + element)
                .orElse(String.valueOf(number));
    }

}
