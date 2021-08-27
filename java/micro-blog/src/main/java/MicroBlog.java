import java.util.stream.Collectors;

class MicroBlog {

    private static final long LIMIT_TRUNCATE = 5;

    public String truncate(String input) {
        return input.codePoints()
                .limit(LIMIT_TRUNCATE)
                .mapToObj(Character::toChars)
                .map(String::new)
                .collect(Collectors.joining());
    }
}
