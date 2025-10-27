package racingcar.service.racingcargame.utils;

import racingcar.dto.RacingCarGameResult;

public class CustomMovingDecisionMaker implements MovingDecisionMaker {

    private RandomNumberGenerator randomNumberGenerator;

    public CustomMovingDecisionMaker(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public boolean decideToGo() {
        if (randomNumberGenerator.generate() >= 4) {
            return true;
        }
        return false;
    }
}
