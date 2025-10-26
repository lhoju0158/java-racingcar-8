package racingcar.entity;

import java.util.List;
import racingcar.error.ErrorMessage;

public class GameBoard {
    private final List<RacingCar> racingCars;
    private String recordBoard;
    private static final int RACING_CAR_LIST_MAX_SIZE = 100;

    private GameBoard(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
        this.recordBoard = "";
    }

    public static GameBoard of(List<RacingCar> racingCars) {
        validate(racingCars);
        return new GameBoard(racingCars);
    }

    private static void validate(List<RacingCar> racingCarList) {
        if (racingCarList.size() > RACING_CAR_LIST_MAX_SIZE || racingCarList.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessage.OUTRAGE_RACING_CAR_COUNT.getMessage(RACING_CAR_LIST_MAX_SIZE));
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public String getRecordBoard() {
        return recordBoard;
    }

    public void recordToBoard() {
        StringBuilder record = new StringBuilder();
        for (RacingCar racingCar : racingCars) {
            record.append(racingCar.getCarName() + " : " + "-".repeat(racingCar.getMovingTime()) + "\n");
        }
        record.append("\n");
        recordBoard += record.toString();
    }

}
