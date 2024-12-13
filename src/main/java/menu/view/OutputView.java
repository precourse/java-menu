package menu.view;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();

    public void printWelcomeMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다." + NEW_LINE);
    }

    public void printEndMessage() {
        System.out.println(NEW_LINE + "추천을 완료했습니다.");
    }

    public void printErrorMessage(final String message) {
        System.out.println(message);
    }
}
