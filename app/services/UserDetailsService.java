package services;

import model.UserRole;
import model.Users;

import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public interface UserDetailsService {
    void addUser(Users user);

    void editUser(Users user);

    void deleteUser(Users user);

    void deleteAllUsersButFor(Users user);

    List<Users> getAllUsersList();

    List<Users> getUsersListByRole(int RoleId);

    Users getUserById(int UserId);

    UserRole gerUserRole(int UserId);

    Users getUserByEmail(String email);
}
