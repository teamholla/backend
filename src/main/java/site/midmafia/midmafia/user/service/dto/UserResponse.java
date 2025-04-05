package site.midmafia.midmafia.user.service.dto;

import java.util.Arrays;
import java.util.List;
import site.midmafia.midmafia.user.domain.User;

public record UserResponse(
        String name
) {

    public static UserResponse from(User user) {
        return new UserResponse(user.getNameValue());
    }

    public static List<UserResponse> of(User... users) {
        return Arrays.stream(users)
                .map(UserResponse::from)
                .toList();
    }
}
