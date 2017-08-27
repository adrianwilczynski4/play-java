package dao;

import model.UserRole;
import model.Users;
import org.h2.engine.User;

import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public interface UserDetailsDAO {

    void addUser(Users user);

    void editUser(Users user);

    void deleteUser(Users user);

    List<Users> getUsersListByRole(int RoleId);

    Users getUserById(int UserId);

    UserRole gerUserRole(int UserId);

    Users getUserByEmail(String email);

}
