package menu.domain.coach;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "sadsfsdf"})
    @DisplayName("잘못된 이름 입력")
    void invalidName(final String name) {
        assertThatThrownBy(() -> new Coach(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("너무 많은 양의 못 먹는 음식 목록 작성")
    void invalideInedible() {
        Coach coach = new Coach("가연");

        String input = "스시,김밥,규동";

        assertThatThrownBy(() -> coach.addInedible(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("못 먹는 음식 판단")
    void findInedible() {
        Coach coach = new Coach("가연");

        String input = "스시,김밥";
        coach.addInedible(input);

        assertThat(coach.canNotEat("스시")).isTrue();
    }
}
