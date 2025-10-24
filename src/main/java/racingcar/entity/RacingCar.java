package racingcar.dto;

public class RacingCar {
    private String carName;
    private int movingTime;

    public RacingCar(String carName, int movingTime) {
        this.carName = carName;
        this.movingTime = movingTime;
    }

    public String getCarName() {
        return carName;
    }

    public int getMovingTime() {
        return movingTime;
    }
}
