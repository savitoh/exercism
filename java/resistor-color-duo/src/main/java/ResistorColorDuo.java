import java.util.Arrays;
import java.util.stream.Collectors;

class ResistorColorDuo {

    private enum ResistorsEnum {

        BLACK(0, "black"),
        BROWN(1, "brown"),
        RED(2, "red"),
        ORANGE(3, "orange"),
        YELLOW(4, "yellow"),
        GREEN(5, "green"),
        BLUE(6, "blue"),
        VIOLET(7, "violet"),
        GREY(8, "grey"),
        WHITE(9, "white");

        private final int code;
        private final String color;

        ResistorsEnum(int code, String color) {
            this.code = code;
            this.color = color;
        }
    }

    private int getCodeByCollor(final String color) {
        return Arrays.stream(ResistorsEnum.values())
                .filter(resistor -> resistor.color.equals(color))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .code;
    }

    int value(String[] colors) {
        int[] codes = Arrays.stream(colors).mapToInt(this::getCodeByCollor).toArray();
        String code = Arrays.stream(codes)
                .limit(2)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining());
        return Integer.parseInt(code);
    }
}
