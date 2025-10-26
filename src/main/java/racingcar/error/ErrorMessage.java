package racingcar.error;

public enum ErrorMessage {
    OUTRAGE_RACING_CAR_COUNT("자동차의 개수는 %d 이하 양수여야합니다."),
    INVALID_RACING_CAR_NAME("자동차의 이름 글자 수는 %d 이하 양수여야합니다."),
    INVALID_GAME_COUNT_VALUE("게임 횟수는 %d 이하 양수입니다."),
    INVALID_GAME_COUNT_TYPE("게임 횟수는 정수입니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int max) {
        return String.format(message, max);
    }

}
