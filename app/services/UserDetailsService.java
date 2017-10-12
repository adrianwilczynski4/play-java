package services;

import model.UserRole;
import model.Users;
import org.h2.engine.User;

import java.util.List;
import java.util.Set;

/**
 * Created by adrian on 02.07.17.
 */
public interface UserDetailsService {
    void addUser(Users user);

    void editUser(Users user);

    void deleteUser(Long userId);

    void deleteAllUsersButFor(Long userId);

    List<Users> getAllUsersList();

    List<Users> getUsersListByRole(String RoleName);

    Users getUserById(Long UserId);

    Set<UserRole> gerUserRole(Long UserId);

    Users getUserByEmail(String email);
}
