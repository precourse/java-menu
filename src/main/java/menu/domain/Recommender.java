package menu.domain;

import menu.domain.coach.Coaches;

public class Recommender {

    private static final int TOTAL_DAY = 5;
    private static final int CATEGORY_LIMIT = 2;

    private final RandomMachine randomMachine;

    public Recommender(final RandomMachine randomMachine) {
        this.randomMachine = randomMachine;
    }


    public void recommend(final Coaches coaches) {
        Result result = new Result(coaches);
        for (int date = 0; date < TOTAL_DAY; date++) {
            Category category = getRandomCategory(result);


        }
    }

    private Category getRandomCategory(final Result result) {
        Category category = randomMachine.pickRandomCategory();
        if (result.categoryCount(category) > CATEGORY_LIMIT) {
            getRandomCategory(result);
        }
        result.addCategory(category);
        return category;
    }
}
