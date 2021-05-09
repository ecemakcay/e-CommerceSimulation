import business.concrete.UserManager;
import core.AuthManagerAdapter;
import dataAccess.concrete.HibernateUserDao;
import entities.concrete.User;


public class Main {

    public static void main(String[] args) {

        User user1 = new User("Ecem", "Akçay","ecemakcay00@gmail.com", "1234567");
        User user2 = new User("Anakin","Skywalker","anakin@hotmail.com","iLovePadme");

        UserManager manager = new UserManager(new HibernateUserDao(), new AuthManagerAdapter());
        manager.addUser(user1);
        manager.addUser(user2);
        manager.deleteUser(user2);
        manager.login(user1, user1.getMail(), user1.getPassword());
        manager.updatePassword(user1);
        manager.updateMail(user1);

    }
}
