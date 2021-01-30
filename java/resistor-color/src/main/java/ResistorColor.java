import java.util.LinkedHashMap;
import java.util.Map;

class ResistorColor {


    private static final Map<String, Integer> RESISTORS_MAP = new LinkedHashMap<>(10);

    public ResistorColor() {
        RESISTORS_MAP.put("black", 0);
        RESISTORS_MAP.put("brown", 1);
        RESISTORS_MAP.put("red", 2);
        RESISTORS_MAP.put("orange", 3);
        RESISTORS_MAP.put("yellow", 4);
        RESISTORS_MAP.put("green", 5);
        RESISTORS_MAP.put("blue", 6);
        RESISTORS_MAP.put("violet", 7);
        RESISTORS_MAP.put("grey",  8);
        RESISTORS_MAP.put("white", 9);
    }

    int colorCode(String color) {
        return RESISTORS_MAP.get(color);
    }

    String[] colors() {
        final String[] arr = new String[RESISTORS_MAP.size()];
        RESISTORS_MAP.keySet().toArray(arr);
        return arr;
    }
}
