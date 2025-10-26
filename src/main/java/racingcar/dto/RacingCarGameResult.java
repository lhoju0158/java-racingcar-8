package racingcar.dto;

import java.util.List;

public class RacingCarGameResultDto {
    private String gameResult;
    private String winners;

    public RacingCarGameResultDto(String gameResult, String winners) {
        this.gameResult = gameResult;
        this.winners = winners;
    }

    public String getGameResult() {
        return gameResult;
    }

    public String getWinners() {
        return winners;
    }
}
