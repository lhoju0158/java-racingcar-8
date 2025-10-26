package racingcar.service.racingcargame.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class MovingDicisionMaker {
    public static boolean isGoing() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return true;
        }
        return false;
    }
}