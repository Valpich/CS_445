package iit.cs445.models.users;

import iit.cs445.exceptions.DuplicateEmailException;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    @Override
    public Boolean registerNewUser(User user) throws DuplicateEmailException {
        try{
            user.saveNew();
        }catch (Exception exception){
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
        return null;
    }

    @Override
    public Boolean authenticateUser(User user, String password) {
        return null;
    }
}
