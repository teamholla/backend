package site.midmafia.midmafia.room.service.dto;

import java.util.List;
import site.midmafia.midmafia.room.domain.Room;
import site.midmafia.midmafia.user.domain.User;
import site.midmafia.midmafia.user.service.dto.UserResponse;

public record RoomEnterServiceResponse(
        long id,
        String name,
        String status,
        int maxParticipants,
        int currentParticipants,
        List<UserResponse> users
) {
    public static RoomEnterServiceResponse of(Room room, List<User> usersInRoom) {
        return new RoomEnterServiceResponse(
                room.getId(),
                room.getNameValue(),
                room.getStatusValue(),
                room.getMaxParticipants(),
                room.getCurrentParticipants(),
                UserResponse.of(usersInRoom.toArray(new User[0]))
        );
    }
}
