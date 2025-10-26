package racingcar.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.error.ErrorMessage;

public class RacingCarTest {
    @Test
    public void 옳은_입력() {
        // given
        String carName = "동주";

        // when, then
        RacingCar.of(carName);
    }

    @Test
    public void 빈_입력() {
        // given
        String carName = "";
        int maxValue = 5;

        // when
        assertThatThrownBy(() -> RacingCar.of(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_RACING_CAR_NAME.getMessage(maxValue));
    }

    @Test
    public void 글자수가_큰_자동차_이름_입력() {
        // given
        String carName = "붕붕붕아주작은자동차꼬마자동차가나간다";
        int maxValue = 5;

        // when
        assertThatThrownBy(() -> RacingCar.of(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_RACING_CAR_NAME.getMessage(maxValue));
    }
}
