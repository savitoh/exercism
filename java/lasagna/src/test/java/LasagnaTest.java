import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LasagnaTest {

    @Test
    public void expected_minutes_in_oven() {
        assertThat(new Lasagna().expectedMinutesInOven()).isEqualTo(40);
    }

    @Test
    public void remaining_minutes_in_oven() {
        assertThat(new Lasagna().remainingMinutesInOven(25)).isEqualTo(15);
    }

    @Test
    public void preparation_time_in_minutes_for_one_layer() {
        assertThat(new Lasagna().preparationTimeInMinutes(1)).isEqualTo(2);
    }

    @Test
    public void preparation_time_in_minutes_for_multiple_layers() {
        assertThat(new Lasagna().preparationTimeInMinutes(4)).isEqualTo(8);
    }

    @Test
    public void total_time_in_minutes_for_one_layer() {
        assertThat(new Lasagna().totalTimeInMinutes(1, 30)).isEqualTo(32);
    }

    @Test
    public void total_time_in_minutes_for_multiple_layers() {
        assertThat(new Lasagna().totalTimeInMinutes(4, 8)).isEqualTo(16);
    }
}
