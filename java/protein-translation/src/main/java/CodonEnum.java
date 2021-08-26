import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

public enum CodonEnum {

    AUG(ProteinEnum.Methionine),
    UUU(ProteinEnum.Phenylalanine), UUC(ProteinEnum.Phenylalanine),
    UUA(ProteinEnum.Leucine), UUG(ProteinEnum.Leucine),
    UCU(ProteinEnum.Serine), UCC(ProteinEnum.Serine), UCA(ProteinEnum.Serine), UCG(ProteinEnum.Serine),
    UAU(ProteinEnum.Tyrosine), UAC(ProteinEnum.Tyrosine),
    UGU(ProteinEnum.Cysteine), UGC(ProteinEnum.Cysteine),
    UGG(ProteinEnum.Tryptophan),
    UAA(null), UAG(null), UGA(null);

    static final Pattern PATTERN;

    static {
        final String regex = Arrays.stream(CodonEnum.values())
                .map(Enum::name)
                .reduce((partialString, currentElement) -> partialString + "|" + currentElement)
                .orElse("");
        PATTERN = Pattern.compile(regex);
    }

    private final ProteinEnum proteinEnum;

    CodonEnum(ProteinEnum proteinEnum) {
        this.proteinEnum = proteinEnum;
    }

    public Optional<String> getProtein() {
        if (Objects.isNull(this.proteinEnum)) {
            return Optional.empty();
        }
        return Optional.of(this.proteinEnum.name());
    }

    public static Optional<CodonEnum> getFrom(final String codonValue) {
        return Arrays.stream(CodonEnum.values())
                .filter(codon -> codon.name().equalsIgnoreCase(codonValue))
                .findFirst();
    }

}
