package menu.domain;

import java.util.Arrays;
import menu.common.ErrorMessage;

public enum Category {

    JAPANESE(1),
    KOREAN(2),
    CHINESE(3),
    ASIAN(4),
    WESTERN(5);

    private final int value;

    Category(final int value) {
        this.value = value;
    }

    public static Category from(final int value) {
        return Arrays.stream(values())
                .filter(response -> response.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_CATEGORY.getMessage()));
    }
}
