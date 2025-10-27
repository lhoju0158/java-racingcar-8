package racingcar.service.game.internal;

import racingcar.dto.RacingCarGameInfo;
import racingcar.dto.RacingCarGameResult;
import racingcar.entity.GameBoard;
import racingcar.entity.GameCount;

public interface GameDataTranslator {

    public GameCount translateInfoToGameCount(RacingCarGameInfo gameInfo);

    public GameBoard translateInfoToBoard(RacingCarGameInfo gameInfo);

    public RacingCarGameResult translateBoardToResult(GameBoard gameBoard);
}

