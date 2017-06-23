package iit.cs445.models.users;

import iit.cs445.exceptions.DuplicateEmailException;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserManager implements UserService {

    @Override
    public Boolean registerNewUser(User user) throws DuplicateEmailException {
        try {
            user.saveNew();
        } catch (Exception exception) {
            throw new DuplicateEmailException("Duplicate email");
        }
        return true;
    }

    @Override
    public Boolean updateUser(User user) {
        user.update();
        return true;
    }

    @Override
    public Boolean deleteUser(User user) {
        user.delete();
        return true;
    }

    @Override
    public User findUserByMail(String email) {
        Logger.getLogger(UserManager.class.getName()).log(Level.INFO, "Find by email: " + email);

        for (User user : new User().listAll()) {
            Boolean test = user.getEmail().toLowerCase().equals(email.toLowerCase());
            if (test) return user;
        }
        return null;
    }

    @Override
    public User findUserById(Long id) {
        Logger.getLogger(UserManager.class.getName()).log(Level.INFO, "Find by id: " + id);
        for (User user : new User().listAll()) {
            Boolean test = user.getId().equals(id);
            if (test) return user;
        }
        return null;
    }

    @Override
    public Boolean authenticateUser(User user, String password) {
        return user.getPassword().toLowerCase().equals(password.toLowerCase());
    }
}
