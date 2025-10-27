package racingcar.service.game.internal;

import racingcar.dto.RacingCarGameInfo;
import racingcar.dto.RacingCarGameResult;
import racingcar.entity.GameBoard;

public interface FormTranslator {
    public GameBoard translateInfoToBoard(RacingCarGameInfo gameInfo);

    public RacingCarGameResult translateBoardToResult(GameBoard gameBoard);
}

