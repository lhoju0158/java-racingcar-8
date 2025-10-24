package racingcar.utils;

import java.util.List;
import racingcar.error.ErrorMessage;

public class Validator {
    private final int CAR_NAME_MAX_VALUE = 5;
    private final int CAR_NAME_LIST_MAX_SIZE = 100;
    private final int CAR_COUNT_MAX_VALUE = 10;
    private static final Validator SINGLETON_CUSTOM_VALIDATOR = new Validator();

    private Validator() {
    }

    public static Validator getInstance() {
        return SINGLETON_CUSTOM_VALIDATOR;
    }

    public void validateCarList(List<String> carNames) {
        if (carNames.size() > CAR_NAME_LIST_MAX_SIZE || carNames.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessage.OUTRAGE_RACING_CAR_COUNT.getMessage(CAR_NAME_LIST_MAX_SIZE));
        }
        for (String carName : carNames) {
            if (carName.length() > CAR_NAME_MAX_VALUE || carName.isEmpty()) {
                throw new IllegalArgumentException(
                        ErrorMessage.INVALID_RACING_CAR_NAME.getMessage(CAR_NAME_MAX_VALUE));
            }
        }
    }

    public void validateCarCount(int carCount) {
        if (carCount > CAR_COUNT_MAX_VALUE || carCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_COUNT.getMessage(CAR_COUNT_MAX_VALUE));
        }
    }
}
