package site.midmafia.midmafia.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.midmafia.midmafia.room.domain.Room;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private UserName name;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public String getNameValue() {
        return name.getValue();
    }

    public User(String name) {
        this.name = new UserName(name);
    }

    public void enter(Room enteredRoom) {
        room = enteredRoom;
        room.enter();
    }
}
