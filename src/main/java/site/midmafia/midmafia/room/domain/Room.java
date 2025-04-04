package site.midmafia.midmafia.room.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.midmafia.midmafia.room.exception.InvalidRoomStateException;

@Entity
@Table(name = "room")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Room {

    private static final int INITIAL_PARTICIPANTS_COUNT = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Embedded
    private RoomName name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private RoomStatus status;

    @Column(name = "max_participants")
    private int maxParticipants;

    @Column(name = "current_participants")
    private int currentParticipants;

    public Room(String name, int maxParticipants) {
        this.status = RoomStatus.WAITING;
        this.name = new RoomName(name);
        this.maxParticipants = maxParticipants;
        this.currentParticipants = INITIAL_PARTICIPANTS_COUNT;
    }

    public String getNameValue() {
        return name.getValue();
    }

    public String getStatusValue() {
        return status.getValue();
    }

    public void enter() {
        if (maxParticipants < currentParticipants + 1) {
            throw new InvalidRoomStateException("방의 인원수가 최대 인원수를 초과했습니다.");
        }
        currentParticipants++;
    }

    public void updateName(String updatedName) {
        name = new RoomName(updatedName);
    }

    public void start() {
        if (status.unready()) {
            throw new InvalidRoomStateException("방이 준비되지 않았습니다.");
        }
        status = RoomStatus.PROGRESS;
    }
}
