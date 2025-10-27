package racingcar.service.racingcargame.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class CustomRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}