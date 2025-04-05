package site.midmafia.midmafia.room.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.midmafia.midmafia.room.domain.Room;
import site.midmafia.midmafia.room.exception.NotFoundRoomException;
import site.midmafia.midmafia.room.respository.RoomRepository;
import site.midmafia.midmafia.room.service.dto.RoomEnterServiceRequest;
import site.midmafia.midmafia.room.service.dto.RoomEnterServiceResponse;
import site.midmafia.midmafia.user.domain.User;
import site.midmafia.midmafia.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoomEnterService {

    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @Transactional
    public RoomEnterServiceResponse enter(RoomEnterServiceRequest request) {
        Room room = roomRepository.findById(request.roomId())
                .orElseThrow(NotFoundRoomException::new);

        User user = new User(request.userName());
        user.enter(room);
        userRepository.save(user);

        List<User> users = userRepository.findAllByRoom(room);

        return RoomEnterServiceResponse.of(room, users);
    }
}
