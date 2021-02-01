import java.util.stream.Collectors;
import java.util.stream.IntStream;

class RnaTranscription {

    private enum DNA_NUCLEOTIDE {
        G('C'),
        C('G'),
        T('A'),
        A('U');

        private final char rnaComplement;

        DNA_NUCLEOTIDE(char rnaComplement) {
            this.rnaComplement = rnaComplement;
        }


    }

    String transcribe(String dnaStrand) {
        final char[] dna = dnaStrand.toCharArray();
        return IntStream.range(0, dna.length)
                .mapToObj(index -> String.valueOf(dna[index]))
                .map(nucleotide -> DNA_NUCLEOTIDE.valueOf(nucleotide).rnaComplement)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}
