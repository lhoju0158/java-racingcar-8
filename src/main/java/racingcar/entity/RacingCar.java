package racingcar.entity;

import racingcar.error.ErrorMessage;

public class RacingCar {
    private final String carName;
    private int movingTime;
    private static final int CAR_NAME_MAX_VALUE = 5;


    private RacingCar(String carName) {
        this.carName = carName;
        this.movingTime = 0;
    }

    public static RacingCar of(String carName) {
        validateName(carName);
        return new RacingCar(carName);
    }

    public void move() {
        movingTime++;
    }

    public int getMovingTime() {
        return movingTime;
    }

    public String getCarName() {
        return carName;
    }

    private static void validateName(String carName) {
        if (carName.length() > CAR_NAME_MAX_VALUE || carName.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_RACING_CAR_NAME.getMessage(CAR_NAME_MAX_VALUE));
        }
    }
}
