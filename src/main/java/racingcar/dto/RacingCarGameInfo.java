package racingcar.dto;

public class RacingCarGameInfo {
    private final int gameCount;
    private final String carNames;

    private RacingCarGameInfo(String carNames, int gameCount) {
        this.gameCount = gameCount;
        this.carNames = carNames;
    }

    public static RacingCarGameInfo of(String carNames, int gameCount) {
        return new RacingCarGameInfo(carNames, gameCount);
    }

    public int getGameCount() {
        return gameCount;
    }

    public String getCarNames() {
        return carNames;
    }
}
