package site.midmafia.midmafia.room.service;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.midmafia.midmafia.room.domain.Room;
import site.midmafia.midmafia.room.respository.RoomRepository;
import site.midmafia.midmafia.room.service.dto.RoomCreateServiceRequest;
import site.midmafia.midmafia.room.service.dto.RoomCreateServiceResponse;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoomCreateService {

    private final RoomRepository roomRepository;

    @Transactional
    public RoomCreateServiceResponse create(RoomCreateServiceRequest request) {
        Room room = new Room(request.name(), request.maxParticipants());

        roomRepository.save(room);

        String code = String.valueOf(Objects.hashCode(room.getId()));

        return RoomCreateServiceResponse.of(room, code);
    }
}
