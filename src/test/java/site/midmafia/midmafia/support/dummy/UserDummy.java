package site.midmafia.midmafia.support.dummy;

import site.midmafia.midmafia.user.domain.User;

public class UserDummy {

    public static final int USER_NAME_LENGTH = 30;

    public static User createUser() {
        return new User("name");
    }
}
