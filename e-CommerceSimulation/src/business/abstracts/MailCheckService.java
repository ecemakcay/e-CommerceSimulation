package business.abstracts;

public interface MailCheckService {
    boolean register(String mail);
    boolean checkName(String name);
    boolean checkLastName(String lastName);
    boolean checkPassword(String password);
}
