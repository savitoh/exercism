class Darts {

    private final double x;

    private final double y;

    Darts(final double x, final double y) {
        this.x = x;
        this.y = y;
    }


    int score() {
        final double distance = this.distance();
        if(distance > 10) {
            return 0;
        }
        if(distance > 5) {
            return 1;
        }
        if(distance > 1) {
            return 5;
        }
        return 10;
    }

    private double distance() {
        return Math.sqrt(
                this.x*this.x + this.y*this.y
        );
    }
}
