import java.util.Objects;

class Scrabble {

    private final String word;

    Scrabble(String word) {
        Objects.requireNonNull(word);
        this.word = word;
    }

    int getScore() {
        return word.chars()
                .mapToObj(c -> CharacterPoints.getPointOrDefault((char) c))
                .reduce(Integer::sum)
                .orElse(0);
    }

}
