import java.util.Optional;

public class Twofer {

    private static final String REPLACE_TARGET = "{REPLACE}";

    private static final String PHRASE_BASE = "One for " + REPLACE_TARGET + ", one for me.";

    public String twofer(String name) {
        final String defaultReplacedBy = "you";
        final String replacedBy = Optional.ofNullable(name).orElse(defaultReplacedBy);
        return PHRASE_BASE.replace(REPLACE_TARGET, replacedBy);
    }
}
