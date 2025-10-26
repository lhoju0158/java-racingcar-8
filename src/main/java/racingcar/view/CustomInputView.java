package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.RacingCarGameInfo;
import racingcar.error.ErrorMessage;

public class CustomInputView implements InputView {
    private final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final CustomInputView SINGLETON_INSTANCE = new CustomInputView();

    public static CustomInputView of() {
        return SINGLETON_INSTANCE;
    }

    @Override
    public RacingCarGameInfo printGameInfoForm() {
        System.out.println(INPUT_CAR_NAME);
        String carNames = Console.readLine();
        System.out.println(INPUT_COUNT);
        int gameCount;
        try {
            gameCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_COUNT_TYPE.getMessage());
        } finally {
            Console.close();
        }
        return RacingCarGameInfo.of(carNames, gameCount);
    }
}
