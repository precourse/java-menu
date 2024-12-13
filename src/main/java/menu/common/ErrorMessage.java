package menu.common;

public enum ErrorMessage {

    INVALID_INPUT("아무것도 입력되지 않았습니다. 다시 입력해주세요."),
    INVALID_INPUT_TYPE("숫자로 입력해주세요."),
    NOT_FOUND_CATEGORY("카테고리를 찾을 수 없습니다."),
    INVALID_NAME_LENGTH("코치 이름은 최소 2글자에서 최대 4글자이여야 합니다.");

    private static final String HEADER = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return HEADER + message;
    }
}
