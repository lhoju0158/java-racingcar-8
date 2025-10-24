package racingcar.dto;

import java.util.List;

public class RacingCarGameBoard {
    private String gameTime;
    private List<RacingCar> racingCars;

    public RacingCarGameBoard(String gameTime, List<RacingCar> racingCars) {
        this.gameTime = gameTime;
        this.racingCars = racingCars;
    }

    public String getGameTime() {
        return gameTime;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
