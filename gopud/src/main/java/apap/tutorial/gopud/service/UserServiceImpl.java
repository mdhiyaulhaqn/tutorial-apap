package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public UserModel findByUsername(String userName) {
        return userDb.findByUsername(userName);
    }

    @Override
    public String isValid(UserModel user, String passwordLama, String passwordBaru, String passwordBaruKonfirmasi){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Boolean isAccepted = passwordEncoder.matches(passwordLama, user.getPassword());

        System.out.println("passwordLama = " + passwordLama);
        System.out.println("passwordBaru = " + passwordBaru);
        System.out.println("passwordBaruKonfirmasi = " + passwordBaruKonfirmasi);

        if(isAccepted){
            if(passwordBaru.equals(passwordBaruKonfirmasi)){
                user.setPassword(encrypt(passwordBaru));
                userDb.save(user);
                return "Password berhasil diubah";
            } else {
                return "Password konfirmasi tidak sama";
            }
        } else {
            return "Password lama salah";
        }
    }
}
