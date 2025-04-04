package site.midmafia.midmafia.room.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.midmafia.midmafia.room.exception.InvalidRoomArgumentException;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomName {

    private static final int MAX_NAME_LENGTH = 30;

    @Column(name = "name")
    private String value;

    public RoomName(String value) {
        validateNameLength(value);
        this.value = value;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidRoomArgumentException("방 최대 길이는 %d자 입니다.".formatted(MAX_NAME_LENGTH));
        }
    }
}
