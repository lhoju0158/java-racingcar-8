package racingcar.service.racingcargame.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RacingCarGameInfo;
import racingcar.dto.RacingCarGameResult;
import racingcar.entity.GameBoard;
import racingcar.entity.RacingCar;

public interface FormTranslator {
    public GameBoard translateInfoToBoard(RacingCarGameInfo gameInfo);

    public RacingCarGameResult translateBoardToResult(GameBoard gameBoard);
}

