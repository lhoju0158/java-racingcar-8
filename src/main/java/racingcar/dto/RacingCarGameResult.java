package racingcar.dto;

public class RacingCarGameResult {
    private final String gameResult;
    private final String winners;

    private RacingCarGameResult(String gameResult, String winners) {
        this.gameResult = gameResult;
        this.winners = winners;
    }

    public static RacingCarGameResult of(String gameResult, String winners) {
        return new RacingCarGameResult(gameResult, winners);
    }

    public String getGameResult() {
        return gameResult;
    }

    public String getWinners() {
        return winners;
    }
}
