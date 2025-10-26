package racingcar.view;

import racingcar.dto.RacingCarGameResult;

public class CustomOutputView implements OutputView {
    private final String OUTPUT_GAME_RESULT_START = "\n실행 결과\n%s";
    private final String OUTPUT_FINAL_WINNER = "최종 우승자 : %s";
    private static final CustomOutputView SINGLETON_INSTANCE = new CustomOutputView();

    public static CustomOutputView of() {
        return SINGLETON_INSTANCE;
    }

    @Override
    public void printGameResult(RacingCarGameResult gameResult) {
        System.out.printf(OUTPUT_GAME_RESULT_START, gameResult.getGameResult());
        System.out.printf(OUTPUT_FINAL_WINNER, gameResult.getWinners());
    }

}
