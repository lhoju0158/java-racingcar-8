package racingcar.entity;

import java.util.ArrayList;
import java.util.List;
import racingcar.error.ErrorMessage;

public class RacingCarGameBoardEntity {
    private final List<RacingCarEntity> racingCarEntityList;
    private static final int CAR_NAME_MAX_VALUE = 5;
    private static final int CAR_NAME_LIST_MAX_SIZE = 100;

    public RacingCarGameBoardEntity(List<RacingCarEntity> racingCarEntityList) {
        this.racingCarEntityList = racingCarEntityList;
    }

    public static RacingCarGameBoardEntity of(List<String> carNameList) {
        validateCarList(carNameList);
        List<RacingCarEntity> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carList.add(RacingCarEntity.of(carName));
        }
        return new RacingCarGameBoardEntity(carList);
    }

    private static void validateCarList(List<String> carNames) {
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

    public List<RacingCarEntity> getRacingCarList() {
        return racingCarEntityList;
    }

}
