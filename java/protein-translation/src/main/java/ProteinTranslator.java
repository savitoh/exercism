import java.util.List;
import java.util.Optional;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        final Matcher matcher = CodonEnum.PATTERN.matcher(rnaSequence);
        return matcher.results()
                .map(MatchResult::group)
                .map(CodonEnum::getFrom)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(CodonEnum::getProtein)
                .takeWhile(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
