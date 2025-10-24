package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.error.ErrorMessage;

public class ValidatorTest {
    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        validator = Validator.getInstance();
    }

    @Test
    public void 경주_자동차_옳은_입력() {
        // given
        List<String> carList = Arrays.asList(new String[]{"재롱", "동쟈", "우댕", "만선"});
        // when, then
        validator.validateCarList(carList);
    }

    @Test
    public void 경주_자동차_사이즈_큰_입력() {
        // given
        List<String> bigSizeCarList = new ArrayList<>();
        int max = 100;
        for (int i = 0; i < max + 1; i++) {
            bigSizeCarList.add("자동차");
        }

        // when, then
        assertThatThrownBy(() -> validator.validateCarList(bigSizeCarList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUTRAGE_RACING_CAR_COUNT.getMessage(max));
    }

    @Test
    public void 경주_자동차_이름_글자수_큰_입력() {
        // given
        List<String> carList = Arrays.asList(new String[]{"재롱, 동쟈, 우댕, 만선"});
        int max = 5;

        // when, then
        assertThatThrownBy(() -> validator.validateCarList(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_RACING_CAR_NAME.getMessage(max));
    }

    @Test
    public void 횟수_옳은_입력() {
        // given
        int carCount = 5;

        // when, then
        validator.validateCarCount(carCount);
    }

    @Test
    public void 횟수_큰_입력() {
        // given
        int carCount = 11;
        int max = 10;

        // when, then
        assertThatThrownBy(() -> validator.validateCarCount(carCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_GAME_COUNT.getMessage(max));
    }
}
