package racingcar.service.game.internal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RacingCarGameInfo;
import racingcar.dto.RacingCarGameResult;
import racingcar.entity.RacingCar;
import racingcar.entity.GameBoard;

public class CustomFormTranslator implements FormTranslator {

    @Override
    public GameBoard translateInfoToBoard(RacingCarGameInfo gameInfo) {
        String carNames = gameInfo.getCarNames();
        List<String> carNamesList = Arrays.asList(carNames.split(","));
        List<RacingCar> racingCars = carNamesList.stream().map(RacingCar::of).collect(Collectors.toList());
        return GameBoard.of(racingCars);
    }

    @Override
    public RacingCarGameResult translateBoardToResult(GameBoard gameBoard) {
        return RacingCarGameResult.of(gameBoard.getRecordBoard(), getWinner(gameBoard.getRacingCars()));
    }

    private String getWinner(List<RacingCar> carList) {
        int maxTime = carList.stream().mapToInt(RacingCar::getMovingTime).max().orElse(0);
        List<String> winners = carList.stream().filter(car -> car.getMovingTime() == maxTime)
                .map(RacingCar::getCarName).collect(Collectors.toList());
        return String.join(", ", winners);
    }
}
