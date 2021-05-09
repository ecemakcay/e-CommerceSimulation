package dataAccess.concrete;

import dataAccess.abstracts.UserDao;
import entities.concrete.User;
import java.util.ArrayList;
import java.util.List;

public class HibernateUserDao implements UserDao {

    List<User> users = new ArrayList<>();

    @Override
    public void add(User user) {
        users.add(user);
        System.out.println("Kullanıcı kayıt başarılı. " + user.getFirstName());
    }

    @Override
    public void delete(User user) {
        users.remove(user);
        System.out.println("Kullanıcı kayıt silindi. " + user.getFirstName());
    }

    @Override
    public void update(User user) {
        System.out.println("Kullanıcı güncellendi " + user.getFirstName());
    }

    @Override
    public void get(User user) {
        System.out.println("kullanıcı " + user.getFirstName());
    }
}
