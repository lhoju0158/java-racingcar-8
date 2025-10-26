package racingcar.service.racingcargame.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class CustomMovingDecisionMaker implements MovingDecisionMaker {
    @Override
    public boolean isTrue() {
        if (getRandomNumber() >= 4) {
            return true;
        }
        return false;
    }

    @Override
    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}