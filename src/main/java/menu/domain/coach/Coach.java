package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;
import menu.common.ErrorMessage;
import menu.domain.utils.DataParser;

public class Coach {

    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 4;

    private final String name;
    private final List<String> inedible;

    public Coach(final String name) {
        this.name = name;
        this.inedible = new ArrayList<>();
    }

    private void validate(final String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void addInedible(final String inedibleMenus) {
        List<String> menus = DataParser.parseMenuName(inedibleMenus);
        inedible.addAll(menus);
    }
}
