package racingcar.service;

import java.util.List;
import racingcar.entity.RacingCarGameBoard;
import racingcar.error.ErrorMessage;
import racingcar.utils.Validator;

public class CustomRacingCarGame {
    private RacingCarGameBoard racingCarGameBoard;
    private final int CAR_NAME_MAX_VALUE = 5;
    private final int CAR_NAME_LIST_MAX_SIZE = 100;
    private final int CAR_COUNT_MAX_VALUE = 10;

    public CustomRacingCarGame(List<String> carNameList, int carCount) {
        
    }


    public void play() {

    }

    // validate

    private void validate(List<String> carNames, int carCount) {
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
        if (carCount > CAR_COUNT_MAX_VALUE || carCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_COUNT.getMessage(CAR_COUNT_MAX_VALUE));
        }
    }


}
