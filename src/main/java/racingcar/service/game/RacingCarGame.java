package racingcar.service.game;

import racingcar.dto.RacingCarGameInfo;
import racingcar.dto.RacingCarGameResult;

public interface RacingCarGame {
    public RacingCarGameResult play(RacingCarGameInfo racingCarGameInfo);
}
