public class Lasagna {

    private static final int EXPECTED_OVEN_TIME = 40;

    private static final short LAYER_TIME_PREPARE = 2;

    public int remainingMinutesInOven(int currentMinutesInOven) {
        return EXPECTED_OVEN_TIME - currentMinutesInOven;
    }

    public int expectedMinutesInOven() {
        return EXPECTED_OVEN_TIME;
    }

    public int preparationTimeInMinutes(int layers) {
        return LAYER_TIME_PREPARE * layers;
    }

    public int totalTimeInMinutes(int layers, int currentMinutesInOven) {
        return preparationTimeInMinutes(layers) + currentMinutesInOven;
    }
}
