import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class Gigasecond {

    private static final Integer  GIGASECONDS = 100_000_000_0;

    private LocalDate date;

    private LocalDateTime dateTime;

    public Gigasecond(LocalDate date) {
        this.date = date;
    }

    public Gigasecond(LocalDateTime date) {
        this.dateTime = date;
    }

    public LocalDateTime getDateTime() {
        return Optional.ofNullable(dateTime)
                .orElseGet(() -> date.atTime(0, 0, 0))
                .plusSeconds(GIGASECONDS);
    }
}
