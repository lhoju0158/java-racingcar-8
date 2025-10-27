package racingcar.dto;

public class RacingCarGameInfo {
    private final String gameCount;
    private final String carNames;

    private RacingCarGameInfo(String carNames, String gameCount) {
        this.gameCount = gameCount;
        this.carNames = carNames;
    }

    public static RacingCarGameInfo of(String carNames, String gameCount) {
        return new RacingCarGameInfo(carNames, gameCount);
    }

    public String getGameCount() {
        return gameCount;
    }

    public String getCarNames() {
        return carNames;
    }
}
