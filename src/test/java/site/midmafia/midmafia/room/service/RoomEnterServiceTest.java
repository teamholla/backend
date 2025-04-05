package site.midmafia.midmafia.room.service;

import static org.junit.jupiter.api.Assertions.*;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestConstructor.AutowireMode;
import site.midmafia.midmafia.room.domain.Room;
import site.midmafia.midmafia.room.exception.NotFoundRoomException;
import site.midmafia.midmafia.room.respository.RoomRepository;
import site.midmafia.midmafia.room.service.dto.RoomEnterServiceRequest;
import site.midmafia.midmafia.user.repository.UserRepository;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@TestConstructor(autowireMode = AutowireMode.ALL)
@RequiredArgsConstructor
class RoomEnterServiceTest {

    private final RoomEnterService roomEnterService;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("입장하려는 방이 존재해야 한다.")
    void throw_exception_when_not_found_room() {
        // given
        RoomEnterServiceRequest request = new RoomEnterServiceRequest(1, "username");

        // when & then
        Assertions.assertThatThrownBy(() -> roomEnterService.enter(request))
                .isInstanceOf(NotFoundRoomException.class);
    }

    @Test
    @DisplayName("방에 입장하면 유저가 생성되야 한다.")
    void create_user_when_enter_room() {
        // given
        Room room = new Room("name", 10);
        room = roomRepository.save(room);
        RoomEnterServiceRequest request = new RoomEnterServiceRequest(room.getId(), "username");

        // when
        roomEnterService.enter(request);

        // then
        Assertions.assertThat(userRepository.findAll())
                .hasSize(1);
    }
}
