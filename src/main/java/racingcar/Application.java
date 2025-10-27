package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.service.game.CustomRacingCarGame;
import racingcar.service.game.internal.CustomFormTranslator;
import racingcar.service.game.internal.CustomMovingDecisionMaker;
import racingcar.service.game.internal.CustomRandomNumberGenerator;
import racingcar.view.CustomInputView;
import racingcar.view.CustomOutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController racingCarGameController
                = RacingCarGameController.of(
                CustomRacingCarGame.of(new CustomMovingDecisionMaker(new CustomRandomNumberGenerator()),
                        new CustomFormTranslator()),
                CustomInputView.of(), CustomOutputView.of());
        racingCarGameController.run();
    }
}
