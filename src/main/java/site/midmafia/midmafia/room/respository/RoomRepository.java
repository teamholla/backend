package site.midmafia.midmafia.room.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.midmafia.midmafia.room.domain.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
