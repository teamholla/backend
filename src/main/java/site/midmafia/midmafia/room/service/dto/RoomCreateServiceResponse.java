package site.midmafia.midmafia.room.service.dto;

import site.midmafia.midmafia.room.domain.Room;

public record RoomCreateServiceResponse (
    long id,
    String name,
    String status,
    int maxParticipants,
    int currentParticipants
) {
    public static RoomCreateServiceResponse of(Room room) {
        return new RoomCreateServiceResponse(
                room.getId(),
                room.getNameValue(),
                room.getStatusValue(),
                room.getMaxParticipants(),
                room.getCurrentParticipants()
        );
    }
}
