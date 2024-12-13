package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMachine {

    private static final int MAX_NUMBER = 5;
    private static final int MIN_NUMBER = 1;

    public Category pickRandomCategory() {
        int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return Category.findCategory(number);
    }
}
