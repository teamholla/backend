package site.midmafia.midmafia.support.dummy;

import site.midmafia.midmafia.room.domain.Room;

public class RoomDummy {

    public static final int ROOM_NAME_LENGTH = 30;

    public static Room createRoom() {
        return new Room("name", 1);
    }
}
