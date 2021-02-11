import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PangramChecker {

    private final List<Character> alphabet;

    public PangramChecker() {
        alphabet = IntStream.rangeClosed('a', 'z').mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    public boolean isPangram(String input) {
        Objects.requireNonNull(input, "input cannot be null");
        final String normalizedInput = input.trim().toLowerCase();
        final Map<Character, Boolean> charsPresentInInput = normalizedInput
                .chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .collect(Collectors.toMap(c -> c, c -> Boolean.TRUE));
        return alphabet.stream().allMatch(charsPresentInInput::containsKey);
    }

}
