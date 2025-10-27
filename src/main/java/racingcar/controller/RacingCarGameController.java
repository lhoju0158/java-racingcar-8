package racingcar.controller;


import racingcar.dto.RacingCarGameInfo;
import racingcar.dto.RacingCarGameResult;
import racingcar.service.game.RacingCarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    private RacingCarGame racingCarGame;
    private InputView inputView;
    private OutputView outputView;

    private RacingCarGameController(RacingCarGame racingCarGame, InputView inputView, OutputView outputView) {
        this.racingCarGame = racingCarGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static RacingCarGameController of(RacingCarGame racingCarGame, InputView inputView, OutputView outputView) {
        return new RacingCarGameController(racingCarGame, inputView, outputView);
    }

    public void run() {
        RacingCarGameInfo racingCarGameInfo = inputView.printGameInfoForm();
        RacingCarGameResult racingCarGameResult = racingCarGame.play(racingCarGameInfo);
        outputView.printGameResult(racingCarGameResult);
    }
}
