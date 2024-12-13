package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;

public class Result {

    private final List<String> categories;
    private final Map<Coach, List<String>> results;

    public Result(final Coaches coaches) {
        this.categories = new ArrayList<>();
        results = initResults(coaches);
    }

    private Map<Coach, List<String>> initResults(final Coaches coaches) {
        Map<Coach, List<String>> results = new HashMap<>();
        for (Coach coach : coaches.getCoaches()) {
            results.put(coach, new ArrayList<>());
        }
        return results;
    }
}
