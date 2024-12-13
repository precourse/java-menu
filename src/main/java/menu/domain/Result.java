package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;

public class Result {

    private final List<Category> categories;
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

    public int categoryCount(final Category category) {
        return (int) categories.stream()
                .filter(c -> c == category)
                .count();
    }

    public void addCategory(final Category category) {
        categories.add(category);
    }

    public boolean isContainMenu(final Coach coach, final String menu) {
        List<String> values = results.get(coach);
        if (values.contains(menu)) {
            return true;
        }
        return false;
    }

    public void addMenu(final Coach coach, final String menu) {
        List<String> values = results.get(coach);
        values.add(menu);
        results.put(coach, values);
    }

    public List<String> getCategoryNames() {
        return categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }

    public Map<Coach, List<String>> getResults() {
        return results;
    }
}
