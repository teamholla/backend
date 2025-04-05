package site.midmafia.midmafia.user.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import site.midmafia.midmafia.support.dummy.UserDummy;
import site.midmafia.midmafia.user.exception.InvalidUserArgumentException;

class UserNameTest {


    @Test
    @DisplayName("유저 이름은 최대 글자 수를 초과할 수 없다.")
    void throw_exception_when_update_name_with_over_max_name_length() {
        // given
        String name = "a".repeat(31);

        // when & then
        Assertions.assertThatThrownBy(() -> new UserName(name))
                .isInstanceOf(InvalidUserArgumentException.class);
    }

    @Test
    @DisplayName("유저 이름은 최대 글자 수를 초과하지 않는 경우 유저 이름으로 생성할 수 있다.")
    void construct_name_when_update_name_with_less_max_name_length() {
        // given
        String name = "a".repeat(UserDummy.USER_NAME_LENGTH);

        // when & then
        Assertions.assertThatCode(() -> new UserName(name))
                .doesNotThrowAnyException();
    }
}
