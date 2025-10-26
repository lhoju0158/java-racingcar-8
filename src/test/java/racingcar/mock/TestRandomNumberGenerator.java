package racingcar.mock;

import racingcar.service.racingcargame.utils.RandomNumberGenerator;

public class TestRandomNumberGenerator implements RandomNumberGenerator {
    private final int fixedValue;

    public TestRandomNumberGenerator(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int generate() {
        return fixedValue;
    }

}