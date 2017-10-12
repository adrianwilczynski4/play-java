package dao;

import model.UserRole;
import model.Users;
import org.h2.engine.User;

import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public interface UserDetailsDAO {
    boolean addUser(Users user);

    boolean editUser(Users user);

    boolean deleteUser(Users user);


    Integer deleteAllUsersButFor(Long userId);
    List<Users> getAllUsersList();

    List<Users> getUsersListByRole(String RoleName);

    Users getUserById(Long UserId);

    Users getUserWithRole(Long UserId);

    Users getUserByEmail(String email);

}
