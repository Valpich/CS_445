package iit.cs445.models.users;

import iit.cs445.exceptions.DuplicateEmailException;

public interface UserService {

    default Boolean registerNewUser(User user) throws DuplicateEmailException {
        return false;
    }

    default Boolean updateUser(User user) {
        return false;
    }

    default Boolean deleteUser(User user) {
        return false;
    }

    default User findUserByMail(String email) {
        return null;
    }

    default User findUserById(Long id) {
        return null;
    }

    default Boolean authenticateUser(User user, String password) {
        return false;
    }

}