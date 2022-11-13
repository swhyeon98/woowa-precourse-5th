package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @DisplayName("구입금액이 1,000원 미만이면 예외가 발생한다.")
    @Test
    void createMoneyByLessThan1000() {
        // given
        User user = new User();

        // expect
        assertThatThrownBy(()->user.toInteger("900"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1,000원 이상을 입력해 주세요.");
    }

    @DisplayName("사용자의 입력이 1,000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void createMoneyByDivisible1000() {
        // given
        User user = new User();

        // expect
        assertThatThrownBy(()->user.toInteger("3800"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1,000원으로 나누어 떨어지는 금액만 입력해 주세요.");
    }
}
