package menu.domain;

import menu.domain.coach.Coaches;

public class Recommender {

    private static final int TOTAL_DAY = 5;

    private final RandomMachine randomMachine;

    public Recommender(final RandomMachine randomMachine) {
        this.randomMachine = randomMachine;
    }


    public void recommend(final Coaches coaches) {
        for (int i = 0; i < TOTAL_DAY; i++) {
            Category category = randomMachine.pickRandomCategory();
        }
    }
}
