import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

class DnDCharacter {

    private static final short DEFAULT_HITPOINTS = (short) 10;

    private final Random random;

    private int initialHitpoints;

    private Integer strength;

    private Integer dexterity;

    private Integer constitution;

    private Integer intelligence;

    private Integer wisdom;

    private Integer charisma;

    public DnDCharacter() {
        this.random = new Random();
        final short defaultModifierConstitution = (short) 0;
        this.initialHitpoints = Math.floorDiv((defaultModifierConstitution - DEFAULT_HITPOINTS), 2);
    }

    int ability() {
        return initialHitpoints;
    }

    int modifier(int input) {
        initialHitpoints = Math.floorDiv((input - DEFAULT_HITPOINTS), 2);
        return initialHitpoints;
    }

    int getStrength() {
        if(Objects.isNull(this.strength)) {
            this.strength = this.generateAbilitiesValue();
        }
        return this.strength;
    }

    int getDexterity() {
        if(Objects.isNull(this.dexterity)) {
            this.dexterity = this.generateAbilitiesValue();
        }
        return this.dexterity;
    }

    int getConstitution() {
        if(Objects.isNull(this.constitution)) {
            this.constitution = this.generateAbilitiesValue();
        }
        return this.constitution;
    }

    int getIntelligence() {
        if(Objects.isNull(this.intelligence)) {
            this.intelligence = this.generateAbilitiesValue();
        }
        return this.intelligence;
    }

    int getWisdom() {
        if(Objects.isNull(this.wisdom)) {
            this.wisdom = this.generateAbilitiesValue();
        }
        return this.wisdom;
    }

    int getCharisma() {
        if(Objects.isNull(this.charisma)) {
            this.charisma = this.generateAbilitiesValue();
        }
        return this.charisma;
    }

    int getHitpoints() {
        return initialHitpoints;
    }

    private int generateAbilitiesValue() {
        final int [] values = this.generateFourNumbers();
        return this.sumThreeLargestValues(values);
    }

    private int sumThreeLargestValues(final int[] values) {
        return IntStream.of(values)
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .reduce(0, Integer::sum);
    }

    private int[] generateFourNumbers() {
        return random.ints(4, 1, 5).toArray();
    }

}
