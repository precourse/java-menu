package menu.domain;

import java.util.List;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;

public class Recommender {

    private static final int TOTAL_DAY = 5;
    private static final int CATEGORY_COUNT_LIMIT = 2;

    private final RandomMachine randomMachine;

    public Recommender(final RandomMachine randomMachine) {
        this.randomMachine = randomMachine;
    }

    public Result recommend(final Coaches coaches) {
        Result result = new Result(coaches);
        for (int date = 0; date < TOTAL_DAY; date++) {
            Category category = getRandomCategory(result);
            List<String> menusInCategory = category.findMenus();
            for (Coach coach : coaches.getCoaches()) {
                getRandomMenu(result, coach, menusInCategory);
            }
        }
        return result;
    }

    private Category getRandomCategory(final Result result) {
        Category category = randomMachine.pickRandomCategory();
        if (result.categoryCount(category) > CATEGORY_COUNT_LIMIT) {
            getRandomCategory(result);
        }
        result.addCategory(category);
        return category;
    }

    private void getRandomMenu(final Result result, final Coach coach, final List<String> menusInCategory) {
        String menu = randomMachine.pickRandomMenu(menusInCategory);
        if (result.isContainMenu(coach, menu) || coach.canNotEat(menu)) {
            getRandomMenu(result, coach, menusInCategory);
        }
        result.addMenu(coach, menu);
    }
}
