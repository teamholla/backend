package site.midmafia.midmafia.room.service.dto;

public record RoomCreateServiceRequest(
    String name,
    int maxParticipants
) {

}
