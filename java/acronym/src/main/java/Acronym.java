import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Acronym {

    private static final String REGEX_SEPARATORS = "[ -]";

    private static final String REGEX_ONLY_ALPHABETIC = "[a-zA-Z]+";

    private static final String REGEX_NOT_ALPHABETIC = "[^a-zA-Z]";

    private static final UnaryOperator<String> normalize = x -> x.replaceAll(REGEX_NOT_ALPHABETIC, "");

    private static final Predicate<String> isOnlyAlphabetic = x -> Pattern.matches(REGEX_ONLY_ALPHABETIC, x);

    private final String phrase;

    Acronym(String phrase) {
        Objects.requireNonNull(phrase);
        this.phrase = phrase;
    }

    String get() {
        final String[] separateWords = this.phrase.trim().split(REGEX_SEPARATORS);
        return Arrays
                .stream(separateWords)
                .map(normalize)
                .filter(isOnlyAlphabetic)
                .map(word -> word.charAt(0))
                .map(String::valueOf)
                .map(String::toUpperCase)
                .collect(Collectors.joining());
    }

}
