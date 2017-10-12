package dao.Impl;

import dao.UserDetailsDAO;
import model.Users;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.h2.engine.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public class UserDetailsDAOImpl implements UserDetailsDAO {


    @Transactional
    @Override
    public boolean addUser(Users user) {

        EntityManager em = JPA.em();

        try {
            em.persist(user);
            em.close();
            return true;
        }

        catch (Exception e){
            em.close();
            return false;
        }



    }

    @Transactional
    @Override
    public boolean editUser(Users user) {

        EntityManager em = JPA.em();

        try {
            em.merge(user);

            em.close();

            return true;
        }

        catch (Exception e){


            em.close();
            return false;

        }

    }

    @Transactional
    @Override
    public boolean deleteUser(Users user) {

        EntityManager em = JPA.em();

       try {
           em.remove(user);

           em.close();

           return true;
       }
       catch (Exception e){

           return false;
       }
    }


    @Transactional
    @Override
    public Integer deleteAllUsersButFor(Long userId) {

        EntityManager em = JPA.em();




        Integer result = em.createNativeQuery("DELETE FROM USERS WHERE ID NOT IN (?1)").setParameter(1,userId).executeUpdate();

        em.close();

        return result;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Users> getAllUsersList() {

        List <Users> result = new ArrayList<>();

        EntityManager em = JPA.em();

        Query query=em.createNativeQuery("FROM USERS",Users.class);

        result.addAll(query.getResultList());



        return result;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Users> getUsersListByRole(String RoleName) {


        EntityManager em = JPA.em();


       List<Users> usersLst= (List<Users>)em.
               createNativeQuery("SELECT * FROM" +
                       " USERS WHERE" +
                       " ID =( SELECT USERS_ID FROM USERS_USER_ROLE " +
                       "WHERE USER_ROLE_ID=(SELECT ID FROM USERROLE WHERE ROLE=?1))",Users.class).
                setParameter(1,RoleName).getResultList();


        return usersLst;
    }

    @Transactional(readOnly = true)
    @Override
    public Users getUserById(Long UserId) {

        EntityManager em = JPA.em();

       Users result = em.find(Users.class,UserId);

        return result;
    }

    @Override
    public Users getUserWithRole(Long UserId) {

        Users user = getUserById(UserId);

        Hibernate.initialize(user.getUserRole());
        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public Users getUserByEmail(String email) {


        EntityManager em = JPA.em();
        Users result=null;


        try{
            result = (Users)em.createNativeQuery("FROM USERS WHERE email=?1").
                    setParameter(1,email).getSingleResult();
        }

             catch (EntityNotFoundException e){
            //do nothing TODO
        }
        catch (NonUniqueResultException e){
            //do nothing TODO
        }


        return result;
    }
}
