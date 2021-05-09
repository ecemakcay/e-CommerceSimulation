package core;

import entities.concrete.User;

public interface AuthService {
    boolean check(User user);
}
