class SpaceAge {

    private final double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double onEarth() {
        return this.seconds/OrbitalPeriodsEarthYearsConstants.EARTH;
    }

    double onMercury() {
        return this.seconds/OrbitalPeriodsEarthYearsConstants.MERCURY;
    }

    double onVenus() {
        return this.seconds/OrbitalPeriodsEarthYearsConstants.VENUS;
    }

    double onMars() {
        return this.seconds/OrbitalPeriodsEarthYearsConstants.MARS;
    }

    double onJupiter() {
        return this.seconds/OrbitalPeriodsEarthYearsConstants.JUPITER;
    }

    double onSaturn() {
        return this.seconds/OrbitalPeriodsEarthYearsConstants.SATURN;
    }

    double onUranus() {
        return this.seconds/OrbitalPeriodsEarthYearsConstants.URANUS;
    }

    double onNeptune() {
        return this.seconds/OrbitalPeriodsEarthYearsConstants.NEPTUNE;
    }

}
