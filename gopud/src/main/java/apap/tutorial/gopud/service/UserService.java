package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    public String encrypt(String password);
    UserModel findByUsername(String userName);
    public String isValid(UserModel user, String passwordLama, String passwordBaru, String passwordBaruKonfirmasi);

}
