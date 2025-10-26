package racingcar.entity;

import racingcar.error.ErrorMessage;

public class GameCount {
    private int carGameCount;
    private static final int GAME_COUNT_MAX_VALUE = 100;

    private GameCount(int carGameCount) {
        this.carGameCount = carGameCount;
    }

    public static GameCount of(int carGameCount) {
        validate(carGameCount);
        return new GameCount(carGameCount);
    }

    private static void validate(int gameCount) {
        if (gameCount > GAME_COUNT_MAX_VALUE || gameCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_COUNT_VALUE.getMessage(GAME_COUNT_MAX_VALUE));
        }
    }

    public int get() {
        return carGameCount;
    }
}
