package dao.Impl;

import dao.PossibleVisitsDAO;
import model.Cabinet;
import model.PossibleVisits;
import model.Room;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public class PossibleVisitsDAOImpl implements PossibleVisitsDAO{

    @Transactional(readOnly = true)
    @Override
    public  List<PossibleVisits> getAllPossibleVisitsForDoctor(int Doctorsid) {

        EntityManager em = JPA.em("default");
        Query query = em.createNativeQuery("SELECT * FROM PossibleVisits WHERE id=1?",PossibleVisits.class);
        query.setParameter(1,Doctorsid);
        List<PossibleVisits> result = null;

        try {
            result =  query.getResultList();
        }

        catch (IllegalStateException e){
            // do nothing
        }
        em.close();
        return result;

    }
    @Transactional
    @Override
    public void addPossibleVisit(PossibleVisits possibleVisit) {

        EntityManager em = JPA.em("default");

        em.persist(possibleVisit);

        em.close();

    }
    @Transactional
    @Override
    public void removePossibleVisit(int visitId) {
        EntityManager em = JPA.em("default");
      em.remove(em.find(PossibleVisits.class, visitId));


        em.close();
    }
    @Transactional
    @Override
    public void bookPossibleVisit(int visitId) {

        EntityManager em = JPA.em("default");
        Query query = em.createNativeQuery("UPDATE PossibleVisits set isbooked=TRUE WHERE id =?1");
        query.setParameter(1,visitId);

        int result = query.executeUpdate();//TODO

        em.close();

    }
}
