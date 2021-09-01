import java.util.stream.IntStream;

class IsbnVerifier {

    private static final String ISBN_10_REGEX =
            "(?=[0-9X]{10}$|(?=(?:[0-9]+[-\\ ]){3})[-\\ 0-9X]{13}$)[0-9]{1,5}[-\\ ]?[0-9]+[-\\ ]?[0-9]+[-\\ ]?[0-9X]";

    private static final String SEPARATOR_DELIMITER = "-";

    boolean isValid(String stringToVerify) {
        if (stringToVerify.matches(ISBN_10_REGEX)) {
            final String isbnWithoutSeparatorDelimiter = this.isbnWithoutSeparatorDelimiter(stringToVerify);
            final char checkDigit = isbnWithoutSeparatorDelimiter.charAt(isbnWithoutSeparatorDelimiter.length() - 1);
            final int checkDigitCalculated = calculateCheckDigit(checkDigit);
            final int sumOfDigits = IntStream.range(0, isbnWithoutSeparatorDelimiter.length() - 1)
                    .map(index -> Character.getNumericValue(isbnWithoutSeparatorDelimiter.charAt(index)) * (10 - index))
                    .sum() + checkDigitCalculated;
            return sumOfDigits % 11 == 0;
        }
        return false;
    }

    private String isbnWithoutSeparatorDelimiter(final String isbn) {
        return isbn.replace(SEPARATOR_DELIMITER, "");
    }

    private int calculateCheckDigit(final char lastDigit) {
        if (lastDigit == 'X') {
            return 10;
        }
        return Character.getNumericValue(lastDigit);
    }

}
