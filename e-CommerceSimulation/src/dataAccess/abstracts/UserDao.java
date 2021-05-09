package dataAccess.abstracts;

import entities.concrete.User;

public interface UserDao {
    void add(User user);
    void delete(User user);
    void update(User user);
    void get(User user);
}
