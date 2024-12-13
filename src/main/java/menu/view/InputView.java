package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.common.ErrorMessage;

public class InputView {

    public String inputCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        validate(input);
        return input;
    }

    public String inputInedibleMenu(final String name) {
        System.out.printf("%n%s(이)가 못 먹는 메뉴를 입력해 주세요.%n", name);
        String input = Console.readLine();
        validate(input);
        return input;
    }

    private void validate(final String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
