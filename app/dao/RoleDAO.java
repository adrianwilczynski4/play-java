package dao;

import model.UserRole;

import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public interface RoleDAO {

    void addRole(UserRole role);
    void editRole(UserRole role);
    List<UserRole> getRoleList();
    List <UserRole> getRoleByAuthorisationDegree(int degree);

    void removeRole(int roleId);

    UserRole getRoleByName(String roleName);

    UserRole getRoleById(Long roleID);


}
