package racingcar.service.game;

import racingcar.dto.RacingCarGameInfo;
import racingcar.dto.RacingCarGameResult;
import racingcar.entity.GameCount;
import racingcar.entity.RacingCar;
import racingcar.entity.GameBoard;
import racingcar.service.game.internal.FormTranslator;
import racingcar.service.game.internal.MovingDecisionMaker;


public class CustomRacingCarGame implements RacingCarGame {
    private MovingDecisionMaker movingDecisionMaker;
    private FormTranslator formTranslator;

    private CustomRacingCarGame(MovingDecisionMaker movingDecisionMaker, FormTranslator formTranslator) {
        this.movingDecisionMaker = movingDecisionMaker;
        this.formTranslator = formTranslator;
    }

    public static CustomRacingCarGame of(MovingDecisionMaker movingDecisionMaker,
                                         FormTranslator formTranslator) {
        return new CustomRacingCarGame(movingDecisionMaker, formTranslator);
    }

    @Override
    public RacingCarGameResult play(RacingCarGameInfo racingCarGameInfo) {
        GameCount gameCount = GameCount.of(racingCarGameInfo.getGameCount());
        GameBoard gameBoard = formTranslator.translateInfoToBoard(racingCarGameInfo);
        for (int i = 0; i < gameCount.get(); i++) {
            playSingleGame(gameBoard);
        }
        return formTranslator.translateBoardToResult(gameBoard);
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
