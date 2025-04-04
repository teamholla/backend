package site.midmafia.midmafia.room.domain;

import lombok.Getter;

@Getter
public enum RoomStatus {

    WAITING("WAITING"),
    PROGRESS("PROGRESS");

    private final String value;

    RoomStatus(String value) {
        this.value = value;
    }

    public boolean unready() {
        return this == PROGRESS;
    }
}
