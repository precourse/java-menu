package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    @DisplayName("값으로 카테코리 찾는 기능 테스트")
    void findCategory() {
        int value = 4;

        Category category = Category.findCategory(value);

        assertThat(category).isEqualTo(Category.ASIAN);
    }

}
