package dao.Impl;

import dao.SpecializationDAO;
import model.Specialization;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */

public class SpecializationDAOImpl implements SpecializationDAO {

    @Transactional(readOnly = true)
    @Override
    public  List<Specialization> getAllSpecializations() {
        EntityManager em = JPA.em();
        List <Specialization> result= new ArrayList<>();


        result.addAll(em.createNativeQuery("FROM  Specialization",Specialization.class).getResultList());


        em.close();
        return result;
    }
    @Transactional(readOnly = true)
    public  Specialization getSpecializationById(int specializationID){
        EntityManager em = JPA.em();

        Specialization specialization= em.find(Specialization.class,specializationID);

        em.close();
        return specialization;
    }
    @Transactional
    @Override
    public  void AddSpecialization(Specialization specialization) {
        EntityManager em = JPA.em();

        em.persist(specialization);

        em.close();
    }
    @Transactional
    @Override
    public  void DeleteSpecialization(int specializationId) {

        EntityManager em = JPA.em();
        em.remove(em.find(Specialization.class,specializationId));
        em.close();
    }

    @Transactional
    @Override
    public  void DeleteAllSpecializations() {

        EntityManager em = JPA.em();
        Query query = em.createNativeQuery( "DELETE FROM SPECIALIZATION");
        query.executeUpdate();
        em.close();
    }
}
