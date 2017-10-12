package dao.Impl;

import dao.RoleDAO;
import model.UserRole;
import model.Users;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public class RoleDAOImpl implements RoleDAO {
    @Transactional
    public void addRole(UserRole role) {
        EntityManager em = JPA.em();

        em.persist(role);
        em.close();
    }
    @Transactional
    @Override
    public void editRole(UserRole role) {
        EntityManager em = JPA.em();
        em.merge(role);
        em.close();
    }

    @Transactional(readOnly = true)
    public List<UserRole> getRoleList() {
        EntityManager em = JPA.em();
        Query query = em.createNativeQuery("SELECT * FROM UserRole ",UserRole.class);

        List <UserRole> result = new ArrayList<UserRole>();

        try {
            result = (List<UserRole>) query.getResultList();
        }
        catch (EntityNotFoundException e)
        {
            //do nothing
        }
    em.close();
        return result;
    }

    @Transactional(readOnly = true)
    public List<UserRole> getRoleByAuthorisationDegree(int degree) {
        EntityManager em = JPA.em();
        Query query = em.createNativeQuery("SELECT * FROM UserRole WHERE degree=?1",UserRole.class);
        query.setParameter(1,degree);
        List <UserRole> result = new ArrayList<UserRole>();

        try {
            result = (List<UserRole>) query.getResultList();
        }
        catch (EntityNotFoundException e)
        {
            //do nothing
        }
    em.close();

        return result;
    }

    @Transactional
    public void removeRole(int roleId) {
    EntityManager em = JPA.em();
    UserRole role =em.find(UserRole.class,roleId);
    if(role!=null){
        em.remove(role);
    }
    em.close();
    }

    @Transactional
    public UserRole getRoleByName(String roleName) {
        EntityManager em = JPA.em();
        UserRole role = null;
        try {

             role =(UserRole)em.createNativeQuery("FROM USERROLE WHERE rolename=?1",UserRole.class).
                    setParameter(1,roleName).getSingleResult();
        }
        catch (EntityNotFoundException e){
            //do nothing TODO
        }
        catch (NonUniqueResultException e){
            //do nothing TODO
        }


        em.close();
        return role;
    }



    @Transactional
    public UserRole getRoleById(Long roleID) {
        EntityManager em = JPA.em();
        UserRole role = null;
        try {

            role =em.find(UserRole.class,roleID);
        }
        catch (EntityNotFoundException e){
            //do nothing TODO
        }


        em.close();
        return role;
    }
}
