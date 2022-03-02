import java.util.regex.Pattern;

public class LogLevels {

    private static final String SPLIT_LOGLEVEL_MESSAGE_REGEX = "(\\[ERROR]: |\\[WARNING]: |\\[INFO]: )(.*)";

    private static final String NORMALIZE_MESSAGE_REGEX = "\\[|\\]|: ";

    private static final Pattern PATTERN = Pattern.compile(SPLIT_LOGLEVEL_MESSAGE_REGEX);


    public static String message(String logLine) {
        return PATTERN.matcher(logLine)
                .results()
                .map(mr -> mr.group(2))
                .findFirst()
                .orElse("")
                .trim();
    }

    public static String logLevel(String logLine) {
        return PATTERN.matcher(logLine)
                .results()
                .map(mr -> mr.group(1))
                .findFirst()
                .orElse("")
                .replaceAll(NORMALIZE_MESSAGE_REGEX, "")
                .toLowerCase();
    }

    public static String reformat(String logLine) {
        final String message = message(logLine);
        final String logLevel = logLevel(logLine);
        return message + " (" + logLevel + ")";
    }
}
