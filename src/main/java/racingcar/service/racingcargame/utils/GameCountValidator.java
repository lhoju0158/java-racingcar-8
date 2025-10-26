package racingcar.service.racingcargame.utils;

import java.util.List;
import racingcar.error.ErrorMessage;

public class InputValidator {
    private static final int GAME_COUNT_MAX_VALUE = 10;
    private static final int CAR_NAME_MAX_VALUE = 5;
    private static final int CAR_NAME_LIST_MAX_SIZE = 100;

    public static void validate(int gameCount, List<String> carNameList) {
        validateGameCount(gameCount);
        validateCarNameList(carNameList);
    }

    private static void validateGameCount(int gameCount) {
        if (gameCount > GAME_COUNT_MAX_VALUE || gameCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_COUNT.getMessage(GAME_COUNT_MAX_VALUE));
        }
    }

    private static void validateCarNameList(List<String> carNameList) {
        if (carNameList.size() > CAR_NAME_LIST_MAX_SIZE || carNameList.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessage.OUTRAGE_RACING_CAR_COUNT.getMessage(CAR_NAME_LIST_MAX_SIZE));
        }
        for (String carName : carNameList) {
            if (carName.length() > CAR_NAME_MAX_VALUE || carName.isEmpty()) {
                throw new IllegalArgumentException(
                        ErrorMessage.INVALID_RACING_CAR_NAME.getMessage(CAR_NAME_MAX_VALUE));
            }
        }
    }
}
