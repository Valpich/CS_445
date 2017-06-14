package iit.cs445.model.users;

import iit.cs445.exceptions.DuplicateEmailException;

public interface UserService {

    Boolean registerNewUser(User user) throws DuplicateEmailException;

    Boolean updateUser(User user);

    Boolean deleteUser(User user);

}