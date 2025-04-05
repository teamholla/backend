package site.midmafia.midmafia.user.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import site.midmafia.midmafia.room.domain.Room;
import site.midmafia.midmafia.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByRoom(Room room);
}
