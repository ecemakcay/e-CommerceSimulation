package business.concrete;

import business.abstracts.MailCheckService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailCheckManager implements MailCheckService {

    public boolean register(String mail){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);

        if(matcher.matches() == false) {
            System.out.println("E-mail bilgisi istenilen kosullari saglamiyor : " + mail);
            return false;
        }
        return true;
    }

    public boolean checkName(String name){
        if (name.length() < 2){
            System.out.println("Ad 2 karakteden küçük olamaz");
            return false;
        }else
            return true;
    }

    public boolean checkLastName(String lastname){
        if (lastname.length() < 2){
            System.out.println("Soyad 2 karakteden küçük olamaz");
            return false;
        }else
            return true;
    }

    public boolean checkPassword(String password){
        if (password.length() < 6){
            System.out.println("Parola 6 karakteden küçük olamaz");
            return false;
        }else
            return true;
    }
}
