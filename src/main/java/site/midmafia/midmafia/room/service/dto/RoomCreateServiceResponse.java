package site.midmafia.midmafia.room.service.dto;

import site.midmafia.midmafia.room.domain.Room;

public record RoomCreateServiceResponse (
    String name,
    String status,
    int maxParticipants,
    int currentParticipants,
    String code
) {
    public static RoomCreateServiceResponse of(Room room, String code) {
        return new RoomCreateServiceResponse(
                room.getNameValue(),
                room.getStatusValue(),
                room.getMaxParticipants(),
                room.getCurrentParticipants(),
                code
        );
    }
}
