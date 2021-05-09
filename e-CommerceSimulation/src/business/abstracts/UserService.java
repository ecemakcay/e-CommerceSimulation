package business.abstracts;

import entities.concrete.User;

public interface UserService {

    void addUser(User user);
    void deleteUser(User user);
    void login(User user, String mail, String password);
    void updatePassword(User user);
    void updateMail(User user);

}
