package site.midmafia.midmafia.room.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import site.midmafia.midmafia.room.exception.InvalidRoomArgumentException;
import site.midmafia.midmafia.support.dummy.RoomDummy;

public class RoomNameTest {

    @Test
    @DisplayName("방 이름은 최대 글자 수를 초과할 수 없다.")
    void throw_exception_when_update_name_with_over_max_name_length() {
        // given
        String name = "a".repeat(31);

        // when & then
        Assertions.assertThatThrownBy(() -> new RoomName(name))
                .isInstanceOf(InvalidRoomArgumentException.class);
    }

    @Test
    @DisplayName("방 이름은 최대 글자 수를 초과하지 않는 경우 방 이름으로 생성할 수 있다.")
    void construct_name_when_update_name_with_less_max_name_length() {
        // given
        String name = "a".repeat(RoomDummy.ROOM_NAME_LENGTH);

        // when & then
        Assertions.assertThatCode(() -> new RoomName(name))
                .doesNotThrowAnyException();
    }
}
