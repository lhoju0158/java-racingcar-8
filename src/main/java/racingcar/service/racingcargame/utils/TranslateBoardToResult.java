package racingcar.service.racingcargame.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RacingCarGameResult;
import racingcar.entity.RacingCar;
import racingcar.entity.RacingCarGameBoard;

public class TranslateBoardToDto {

    public static RacingCarGameResult translate(RacingCarGameBoard gameBoard) {
        return RacingCarGameResult.of(gameBoard.getRecordBoard(), getWinner(gameBoard.getRacingCarList()));
    }

    private static String getWinner(List<RacingCar> carList) {
        int maxTime = carList.stream().mapToInt(RacingCar::getMovingTime).max().orElse(0);
        List<String> winners = carList.stream().filter(car -> car.getMovingTime() == maxTime)
                .map(RacingCar::getCarName).collect(Collectors.toList());

        return String.join(", ", winners);
    }
}
