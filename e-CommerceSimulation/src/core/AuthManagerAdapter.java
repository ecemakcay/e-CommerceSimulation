package core;

import Google.AuthManager;
import dataAccess.concrete.HibernateUserDao;
import entities.concrete.User;

public class AuthManagerAdapter implements AuthService{
    @Override
    public boolean check(User user) {


        AuthManager authManager = new AuthManager();
        authManager.checkToMail(user.getMail());
        return true;
    }
}
