package racingcar.entity;

public class RacingCarEntity {
    private final String carName;
    private int movingTime;

    private RacingCarEntity(String carName) {
        this.carName = carName;
        this.movingTime = 0;
    }

    public static RacingCarEntity of(String carName) {
        return new RacingCarEntity(carName);
    }

    public void move() {
        movingTime++;
    }
}
