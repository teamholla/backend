package site.midmafia.midmafia.room.service;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestConstructor.AutowireMode;
import site.midmafia.midmafia.room.respository.RoomRepository;
import site.midmafia.midmafia.room.service.dto.RoomCreateServiceRequest;
import site.midmafia.midmafia.room.service.dto.RoomCreateServiceResponse;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@TestConstructor(autowireMode = AutowireMode.ALL)
@RequiredArgsConstructor
public class RoomCreateServiceTest {

    private final RoomCreateService roomCreateService;
    private final RoomRepository roomRepository;

    @AfterEach
    void tearDown() {
        roomRepository.deleteAll();
    }

    @Test
    @DisplayName("방 생성 시 방이 생성된다.")
    void create_room_when_create_room() {
        // given
        RoomCreateServiceRequest request = new RoomCreateServiceRequest("name", 10);

        // when
        RoomCreateServiceResponse response = roomCreateService.create(request);

        // then
        Assertions.assertThat(roomRepository.findAll())
                .hasSize(1);
    }
}
