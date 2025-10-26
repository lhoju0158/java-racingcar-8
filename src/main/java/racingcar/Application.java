package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.service.racingcargame.CustomRacingCarGame;
import racingcar.service.racingcargame.utils.CustomFormTranslator;
import racingcar.service.racingcargame.utils.CustomMovingDecisionMaker;
import racingcar.service.racingcargame.utils.CustomRandomNumberGenerator;
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
