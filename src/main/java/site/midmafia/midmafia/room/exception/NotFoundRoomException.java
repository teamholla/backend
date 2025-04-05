package site.midmafia.midmafia.room.exception;

public class NotFoundRoomException extends RuntimeException {

    public NotFoundRoomException() {
        super("방 정보를 찾을 수 없습니다.");
    }
}
