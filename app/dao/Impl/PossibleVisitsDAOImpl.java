package dao.Impl;

import dao.PossibleVisitsDAO;
import model.Cabinet;
import model.PossibleVisits;
import model.Room;
import play.db.jpa.JPA;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public class PossibleVisitsDAOImpl implements PossibleVisitsDAO{
    @Override
    public List<PossibleVisits> getAllPossibleVisitsForDoctor(int Doctorsid) {

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

    @Override
    public void addPossibleVisit(PossibleVisits possibleVisit) {

        EntityManager em = JPA.em("default");
        em.getTransaction().begin();
        em.persist(possibleVisit);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void removePossibleVisit(int visitId) {
        EntityManager em = JPA.em("default");
        Query query = em.createNativeQuery("DELETE FROM PossibleVisits  WHERE id =?1");
        query.setParameter(1,visitId);
        em.getTransaction().begin();
        int result = query.executeUpdate();//TODO
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void bookPossibleVisit(int visitId) {

        EntityManager em = JPA.em("default");
        Query query = em.createNativeQuery("UPDATE PossibleVisits set isbooked=TRUE WHERE id =?1");
        query.setParameter(1,visitId);
        em.getTransaction().begin();
        int result = query.executeUpdate();//TODO
        em.getTransaction().commit();
        em.close();

    }
}
