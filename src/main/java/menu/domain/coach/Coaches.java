package menu.domain.coach;

import java.util.List;
import menu.common.ErrorMessage;

public class Coaches {

    private static final int MAX_COACHES = 5;
    private static final int MIN_COACHES = 2;

    private final List<Coach> coaches;

    public Coaches(final List<Coach> coaches) {
        this.coaches = coaches;
    }

    private void validate(final List<Coach> coaches) {
        if (coaches.size() < MIN_COACHES || coaches.size() > MAX_COACHES) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_SIZE.getMessage());
        }
    }
}
