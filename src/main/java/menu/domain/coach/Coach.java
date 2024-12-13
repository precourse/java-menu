package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;
import menu.common.ErrorMessage;
import menu.domain.utils.DataParser;

public class Coach {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MAX_MENU_LENGTH = 2;

    private final String name;
    private final List<String> inedible;

    public Coach(final String name) {
        validate(name);
        this.name = name;
        this.inedible = new ArrayList<>();
    }

    public void addInedible(final String inedibleMenus) {
        List<String> menus = DataParser.parseMenuName(inedibleMenus);
        validateInedibleSize(menus);
        inedible.addAll(menus);
    }

    public boolean canNotEat(final String menu) {
        return inedible.contains(menu);
    }

    public String getName() {
        return name;
    }

    private void validate(final String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
    }

    private void validateInedibleSize(final List<String> menus) {
        if (menus.size() > MAX_MENU_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INEDIBLE_MENU.getMessage());
        }
    }
}
