package services.Impl;

import dao.RoleDAO;
import model.UserRole;
import services.RoleService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public class RoleServiceImpl implements RoleService{
    @Inject
    RoleDAO roleDAO;

    @Override
    public void addRole(UserRole role) {

        roleDAO.addRole(role);

    }

    @Override
    public List<UserRole> getRoleList() {

        return roleDAO.getRoleList();
    }

    @Override
    public List<UserRole> getRoleByAuthorisationDegree(int degree) {
        return roleDAO.getRoleByAuthorisationDegree(degree);
    }

    @Override
    public void removeRole(int roleId) {

        roleDAO.removeRole(roleId);
    }

    @Override
    public void removeAllRoles() {

        for (UserRole role: roleDAO.getRoleList()){

            removeRole(role.getId());

        }
    }

    @Override
    public UserRole getRoleByName(String roleName) {
        return roleDAO.getRoleByName(roleName);
    }

    @Override
    public UserRole getRoleByID(Long roleID) {
        return roleDAO.getRoleById(roleID);
    }


}
