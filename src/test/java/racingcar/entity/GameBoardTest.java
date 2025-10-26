package racingcar.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.error.ErrorMessage;

public class RacingCarGameBoardTest {

    @Test
    public void 옳은_입력() {
        // given
        List<RacingCar> carList = new ArrayList<>(
                Arrays.asList(
                        RacingCar.of("재롱"),
                        RacingCar.of("동주"),
                        RacingCar.of("우댕"),
                        RacingCar.of("만선")));

        // when, then
        RacingCarGameBoard.of(carList);
    }

    @Test
    public void 자동차_수가_많은_입력() {
        // given
        List<RacingCar> carList = new ArrayList<>();
        int max = 100;
        for (int i = 0; i < max + 1; i++) {
            carList.add(RacingCar.of("자동차"));
        }
        // when, then
        assertThatThrownBy(() -> RacingCarGameBoard.of(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUTRAGE_RACING_CAR_COUNT.getMessage(max));
    }

    @Test
    public void 빈_입력() {
        // given
        List<RacingCar> carList = new ArrayList<>();
        int max = 100;

        // when, then
        assertThatThrownBy(() -> RacingCarGameBoard.of(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUTRAGE_RACING_CAR_COUNT.getMessage(max));
    }

    @Test
    public void 보드판에_기록_하기() {
        // given
        List<RacingCar> carList = new ArrayList<>(
                Arrays.asList(
                        RacingCar.of("재롱"),
                        RacingCar.of("동주"),
                        RacingCar.of("우댕"),
                        RacingCar.of("만선")));

        for (int i = 0; i < carList.size(); i++) {
            for (int j = 0; j < i + 1; j++) {
                carList.get(i).move();
            }
        }
        RacingCarGameBoard racingCarGameBoard = RacingCarGameBoard.of(carList);
        String expected = "재롱 : -\n동주 : --\n우댕 : ---\n만선 : ----\n\n";

        // when
        racingCarGameBoard.recordToBoard();

        // then
        assertThat(racingCarGameBoard.getRecordBoard()).isEqualTo(expected);

    }
}
