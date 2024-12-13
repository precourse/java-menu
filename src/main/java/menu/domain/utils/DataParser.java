package menu.domain.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.common.ErrorMessage;
import menu.domain.Category;
import menu.domain.coach.Coach;

public class DataParser {

    private static final String DELIMITER = ",";

    public static List<Coach> parseCoachName(final String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(name -> new Coach(name.trim()))
                .collect(Collectors.toList());
    }

    public static List<String> parseMenuName(final String menus) {
        return Arrays.stream(menus.split(DELIMITER))
                .filter(menu -> !menu.isBlank())
                .peek(DataParser::validateMenuName)
                .collect(Collectors.toList());
    }

    private static void validateMenuName(final String menuName) {
        if (!Category.isExist(menuName.trim())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU_NAME.getMessage());
        }
    }
}
