package racingcar.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.error.ErrorMessage;

public class GameCountTest {

    @Test
    public void 옳은_입력() {
        // given
        int gameCount = 1;
        // when, then
        GameCount.of(gameCount);
    }

    @Test
    public void 범위_이상_입력() {
        // given
        int gameCount = 101;
        int max = 100;

        // when, then
        assertThatThrownBy(() -> GameCount.of(gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_GAME_COUNT_VALUE.getMessage(max));
    }

    @Test
    public void 범위_이하_입력() {
        // given
        int gameCount = 0;
        int max = 100;

        // when, then
        assertThatThrownBy(() -> GameCount.of(gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_GAME_COUNT_VALUE.getMessage(max));
    }
}
