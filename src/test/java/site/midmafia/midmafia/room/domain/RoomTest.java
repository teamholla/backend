package site.midmafia.midmafia.room.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import site.midmafia.midmafia.room.exception.InvalidRoomArgumentException;
import site.midmafia.midmafia.room.exception.InvalidRoomStateException;
import site.midmafia.midmafia.support.dummy.RoomDummy;

class RoomTest {

    @Test
    @DisplayName("방은 최대 인원 수보다 현재 인원수가 많을 수 없다.")
    void throw_exception_when_current_participants_greater_then_max() {
        // given
        Room room = RoomDummy.createRoom();
        room.enter();

        // when & then
        Assertions.assertThatThrownBy(room::enter)
                .isInstanceOf(InvalidRoomStateException.class);
    }

    @Test
    @DisplayName("방에 입장하면 현재 인원수가 1씩 증가한다.")
    void increase_current_participants() {
        // given
        Room room = RoomDummy.createRoom();

        // when
        room.enter();

        // then
        Assertions.assertThat(room.getCurrentParticipants())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("준비가 되지 않는 방은 시작할 수 없다.")
    void throw_exception_when_unready() {
        // given
        Room room = RoomDummy.createRoom();
        room.start();

        // when & then
        Assertions.assertThatThrownBy(room::start)
                .isInstanceOf(InvalidRoomStateException.class);
    }

    @Test
    @DisplayName("준비가 되었다면 방을 시작할 수 있다.")
    void start_when_ready() {
        // given
        Room room = RoomDummy.createRoom();

        // when
        room.start();

        // then
        Assertions.assertThat(room.getStatus())
                .isEqualTo(RoomStatus.PROGRESS);
    }
}
