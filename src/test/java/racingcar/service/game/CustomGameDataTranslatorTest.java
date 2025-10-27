package racingcar.service.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingCarGameInfo;
import racingcar.dto.RacingCarGameResult;
import racingcar.entity.GameBoard;
import racingcar.entity.GameCount;
import racingcar.entity.RacingCar;
import racingcar.error.ErrorMessage;
import racingcar.service.game.internal.CustomGameDataTranslator;

public class CustomGameDataTranslatorTest {
    private CustomGameDataTranslator customFormTranslator = new CustomGameDataTranslator();

    @Test
    public void 정보에서_게임_카운트로_변환() {
        // given
        RacingCarGameInfo racingCarGameInfo = RacingCarGameInfo.of("재롱,동쟈,우댕,만선", "5");

        // when
        GameCount gameCount = customFormTranslator.translateInfoToGameCount(racingCarGameInfo);

        // then
        assertThat(gameCount.get()).isEqualTo(5);
    }

    @Test
    public void 정보에서_게임_카운트로_변환_문자열_입력() {
        // given
        RacingCarGameInfo racingCarGameInfo = RacingCarGameInfo.of("재롱,동쟈,우댕,만선", "다섯번");

        // when. then
        assertThatThrownBy(() -> customFormTranslator.translateInfoToGameCount(racingCarGameInfo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_GAME_COUNT_TYPE.getMessage());

        // then

    }

    @Test
    public void 정보에서_보드로_변환() {
        // given
        RacingCarGameInfo racingCarGameInfo = RacingCarGameInfo.of("재롱,동쟈,우댕,만선", "5");

        // when
        GameBoard gameBoard = customFormTranslator.translateInfoToBoard(racingCarGameInfo);
        List<String> carNameList = gameBoard.getRacingCars().stream()
                .map(RacingCar::getCarName).collect(Collectors.toList());

        // then
        assertThat(carNameList).containsExactly("재롱", "동쟈", "우댕", "만선");
    }

    @Test
    public void 공백문자_입력_포함() {
        // given
        RacingCarGameInfo racingCarGameInfo = RacingCarGameInfo.of("재롱,동쟈,우댕,만선,", "5");

        // when
        GameBoard gameBoard = customFormTranslator.translateInfoToBoard(racingCarGameInfo);

        // then
        assertThat(gameBoard.getRacingCars()).hasSize(4);

    }

    @Test
    public void 보드에서_결과로_변환_단독_우승() {
        // given
        List<RacingCar> carList = new ArrayList<>(
                Arrays.asList(
                        RacingCar.of("재롱"),
                        RacingCar.of("동주"),
                        RacingCar.of("우댕"),
                        RacingCar.of("만선")));

        for (int i = 0; i < carList.size(); i++) {
            for (int j = 0; j < i + 1; j++) {
                carList.get(i).move();
            }
        }
        GameBoard gameBoard = GameBoard.of(carList);
        gameBoard.recordToBoard();

        // when
        RacingCarGameResult racingCarGameResult = customFormTranslator.translateBoardToResult(gameBoard);

        // then
        assertThat(racingCarGameResult.getGameResult()).isEqualTo("재롱 : -\n동주 : --\n우댕 : ---\n만선 : ----\n\n");
        assertThat(racingCarGameResult.getWinners()).isEqualTo("만선");
    }

    @Test
    public void 보드에서_결과로_변환_공동_우승() {
        // given
        List<RacingCar> carList = new ArrayList<>(
                Arrays.asList(
                        RacingCar.of("재롱"),
                        RacingCar.of("동주"),
                        RacingCar.of("우댕"),
                        RacingCar.of("만선")));

        for (int i = 0; i < 2; i++) {
            carList.get(i).move();
        }
        GameBoard gameBoard = GameBoard.of(carList);
        gameBoard.recordToBoard();

        // when
        RacingCarGameResult racingCarGameResult = customFormTranslator.translateBoardToResult(gameBoard);

        // then
        assertThat(racingCarGameResult.getGameResult()).isEqualTo("재롱 : -\n동주 : -\n우댕 : \n만선 : \n\n");
        assertThat(racingCarGameResult.getWinners()).isEqualTo("재롱, 동주");
    }
}
