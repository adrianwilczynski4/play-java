package dao;

import model.UserRole;

import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public interface RoleDAO {

    void addRole(UserRole role);//TODO

    List<UserRole> getRoleList();//TODO
    List <UserRole> getRoleByAuthorisationDegree(int degree);

    void removeRole(int roleId); //TODO

    UserRole getRoleByName(String roleName);//TODO


}
