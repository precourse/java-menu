package menu.domain.coach;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachesTest {

    @Test
    @DisplayName("잘못된 명수일 경우 예외가 발생한다")
    void invalidCoachSize() {
        assertThatThrownBy(() -> new Coaches(List.of(new Coach("안녕"))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
