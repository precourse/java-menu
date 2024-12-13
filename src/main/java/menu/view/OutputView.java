package menu.view;

import java.util.List;
import java.util.Map;
import menu.domain.Result;
import menu.domain.coach.Coach;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String PREFIX = "[ ";
    private static final String SUFFIX = " ]";
    private static final String SEPARATOR = " | ";

    public void printWelcomeMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다." + NEW_LINE);
    }

    public void printResult(final Result result) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(PREFIX + getCategoryNames(result) + SUFFIX);
        Map<Coach, List<String>> results = result.getResults();
        for (Map.Entry<Coach, List<String>> entry : results.entrySet()) {
            System.out.println(PREFIX + getMenuNames(entry) + SUFFIX);
        }
    }

    private String getCategoryNames(final Result result) {
        List<String> categories = result.getCategoryNames();
        categories.add(0, "카테고리");
        return String.join(SEPARATOR, categories);
    }

    private String getMenuNames(final Map.Entry<Coach, List<String>> entry) {
        List<String> result = entry.getValue();
        result.add(0, entry.getKey().getName());
        return String.join(SEPARATOR, result);
    }

    public void printEndMessage() {
        System.out.println(NEW_LINE + "추천을 완료했습니다.");
    }

    public void printErrorMessage(final String message) {
        System.out.println(message);
    }
}
