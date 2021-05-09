package business.concrete;

import business.abstracts.UserService;
import core.AuthService;
import dataAccess.concrete.HibernateUserDao;
import entities.concrete.User;
import util.Code;
import java.util.Scanner;


public class UserManager implements UserService {
    MailCheckManager checkManager = new MailCheckManager();
    Code code = new Code();
    HibernateUserDao userDao;

    AuthService authService;

    public UserManager(HibernateUserDao userDao, AuthService authService) {
        this.userDao = userDao;
        this.authService = authService;
    }

    @Override
    public void addUser(User user) {

        if (checkManager.register(user.getMail()) &&
                checkManager.checkName(user.getFirstName()) &&
                checkManager.checkLastName(user.getLastName()) &&
                checkManager.checkPassword(user.getPassword()) ){

            this.userDao.add(user);
        }else
            System.out.println("Kayıt başarısız");

    }


    @Override
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    @Override
    public void login(User user, String mail, String password) {
        if (mail.equals(user.getMail())){
            if (password.equals(user.getPassword())){
                System.out.println("Giriş yapıldı " + user.getFirstName());
            }
        }else if (authService.check(user)) {

        }else
            System.out.println("Hatalı giriş");
    }

   @Override
    public void updatePassword(User user) {
       Scanner scn = new Scanner(System.in);
       String c = code.codeMaker();
       user.setActivationCode(c);
       if (user.getActivationCode().equals(c)){
           System.out.println("Yeni parolayı giriniz: ");
           user.setPassword(scn.nextLine());
           System.out.println("Yeni parola "+user.getPassword());
           this.userDao.update(user);
       }else
           System.out.println("Geçersiz kod");
    }

    @Override
    public void updateMail(User user) {
        Scanner scn = new Scanner(System.in);
        String c = code.codeMaker();
        user.setActivationCode(c);
        if (user.getActivationCode().equals(c)){
            System.out.println("Yeni maili giriniz: ");
            user.setMail(scn.nextLine());
            System.out.println("Yeni mail "+user.getMail());
            this.userDao.update(user);
        }else
            System.out.println("Geçersiz kod");

    }
}
