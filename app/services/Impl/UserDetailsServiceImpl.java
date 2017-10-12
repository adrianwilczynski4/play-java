package services.Impl;

import dao.RoleDAO;
import dao.UserDetailsDAO;
import model.UserRole;
import model.Users;
import org.h2.engine.User;
import services.UserDetailsService;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

/**
 * Created by adrian on 02.07.17.
 */
public class UserDetailsServiceImpl implements UserDetailsService{
    @Inject
    UserDetailsDAO userDAO;



    @Inject
    RoleDAO roleDAO;

    @Override
    public void addUser(Users user) {

        userDAO.addUser(user);
    }

    @Override
    public void editUser(Users user) {
            userDAO.editUser(user);
    }

    @Override
    public void deleteUser(Long userId) {


        Users user= userDAO.getUserById(userId);
        userDAO.deleteUser(user);
    }

    @Override
    public void deleteAllUsersButFor(Long userId) {

        userDAO.deleteAllUsersButFor(userId);


    }

    @Override
    public List<Users> getAllUsersList() {

       return userDAO.getAllUsersList();

    }

    @Override
    public List<Users> getUsersListByRole(String RoleName) {
        return userDAO.getUsersListByRole(RoleName);
    }

    @Override
    public Users getUserById(Long UserId) {
        return userDAO.getUserById(UserId);
    }

    @Override
    public Set<UserRole> gerUserRole(Long UserId) {

        return userDAO.getUserWithRole(UserId).getUserRole();
    }

    @Override
    public Users getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }
}
