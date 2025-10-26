package racingcar.entity;

import java.util.List;
import racingcar.error.ErrorMessage;

public class GameBoard {
    private final List<RacingCar> racingCarList;
    private String recordBoard;
    private static final int RACING_CAR_LIST_MAX_SIZE = 100;

    private GameBoard(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
        this.recordBoard = "";
    }

    public static GameBoard of(List<RacingCar> racingCarList) {
        validate(racingCarList);
        return new GameBoard(racingCarList);
    }

    private static void validate(List<RacingCar> racingCarList) {
        if (racingCarList.size() > RACING_CAR_LIST_MAX_SIZE || racingCarList.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessage.OUTRAGE_RACING_CAR_COUNT.getMessage(RACING_CAR_LIST_MAX_SIZE));
        }
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public String getRecordBoard() {
        return recordBoard;
    }

    public void recordToBoard() {
        StringBuilder record = new StringBuilder();
        for (RacingCar racingCar : racingCarList) {
            record.append(racingCar.getCarName() + " : " + "-".repeat(racingCar.getMovingTime()) + "\n");
        }
        record.append("\n");
        recordBoard += record.toString();
    }

}
