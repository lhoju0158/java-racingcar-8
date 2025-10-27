package racingcar.service.game;

import racingcar.dto.RacingCarGameInfo;
import racingcar.dto.RacingCarGameResult;
import racingcar.entity.GameCount;
import racingcar.entity.RacingCar;
import racingcar.entity.GameBoard;
import racingcar.error.ErrorMessage;
import racingcar.service.game.internal.GameDataTranslator;
import racingcar.service.game.internal.MovingDecisionMaker;


public class CustomRacingCarGame implements RacingCarGame {
    private MovingDecisionMaker movingDecisionMaker;
    private GameDataTranslator gameDataTranslator;

    private CustomRacingCarGame(MovingDecisionMaker movingDecisionMaker, GameDataTranslator gameDataTranslator) {
        this.movingDecisionMaker = movingDecisionMaker;
        this.gameDataTranslator = gameDataTranslator;
    }

    public static CustomRacingCarGame of(MovingDecisionMaker movingDecisionMaker,
                                         GameDataTranslator gameDataTranslator) {
        return new CustomRacingCarGame(movingDecisionMaker, gameDataTranslator);
    }

    @Override
    public RacingCarGameResult play(RacingCarGameInfo racingCarGameInfo) {
        GameCount gameCount = gameDataTranslator.translateInfoToGameCount(racingCarGameInfo);
        GameBoard gameBoard = gameDataTranslator.translateInfoToBoard(racingCarGameInfo);
        for (int i = 0; i < gameCount.get(); i++) {
            playSingleGame(gameBoard);
        }
        return gameDataTranslator.translateBoardToResult(gameBoard);
    }

    private void playSingleGame(GameBoard gameBoard) {
        for (RacingCar racingCar : gameBoard.getRacingCars()) {
            if (movingDecisionMaker.decideToGo()) {
                racingCar.move();
            }
        }
        gameBoard.recordToBoard();
    }
}
