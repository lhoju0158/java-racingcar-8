package racingcar.service.racingcargame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.mock.TestRandomNumberGenerator;
import racingcar.service.racingcargame.utils.CustomMovingDecisionMaker;

public class CustomMovingDecisionMakerTest {

    @Test
    public void 전진() {
        // given
        int movingValue = 4;

        // when
        CustomMovingDecisionMaker customMovingDecisionMaker = new CustomMovingDecisionMaker(
                new TestRandomNumberGenerator(movingValue));

        // then
        assertThat(customMovingDecisionMaker.decideToGo()).isTrue();
    }

    @Test
    public void 스톱() {
        // given
        int stopValue = 3;

        // when
        CustomMovingDecisionMaker customMovingDecisionMaker = new CustomMovingDecisionMaker(
                new TestRandomNumberGenerator(stopValue));

        // then
        assertThat(customMovingDecisionMaker.decideToGo()).isFalse();
    }
}
