package site.midmafia.midmafia.room.service.dto;

public record RoomEnterServiceRequest(
        long roomId,
        String userName
) {
}
