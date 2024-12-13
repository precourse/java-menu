package menu.domain.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DataParserTest {

    @Test
    @DisplayName("존재하지 않는 메뉴 이름이 입력되었을 때, 예외가 발생한다")
    void invalidMenuName() {
        String input = "하하";

        assertThatThrownBy(() -> DataParser.parseMenuName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
