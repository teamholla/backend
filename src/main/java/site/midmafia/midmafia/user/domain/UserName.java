package site.midmafia.midmafia.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.midmafia.midmafia.user.exception.InvalidUserArgumentException;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserName {

    private static final int MAX_NAME_LENGTH = 30;

    @Column(name = "name")
    private String value;

    public UserName(String value) {
        validateNameLength(value);
        this.value = value;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidUserArgumentException("유저의 길이는 %d자 입니다.".formatted(MAX_NAME_LENGTH));
        }
    }
}

