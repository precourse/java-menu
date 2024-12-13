package menu.domain.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.coach.Coach;

public class DataParser {

    private static final String DELIMITER = ",";

    public static List<Coach> parseCoachName(final String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(name -> new Coach(name.trim()))
                .collect(Collectors.toList());
    }
}
