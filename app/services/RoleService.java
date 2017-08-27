package services;

import model.UserRole;

import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public interface RoleService {
    void addRole(UserRole role);//TODO

    List<UserRole> getRoleList();//TODO
    List <UserRole> getRoleByAuthorisationDegree(int degree);

    void removeRole(int roleId); //TODO

    void removeAllRoles();// TODO

    UserRole getRoleByName(String roleName);//TODO
}
