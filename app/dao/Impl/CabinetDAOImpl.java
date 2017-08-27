package dao.Impl;

import dao.CabinetDAO;
import model.Cabinet;
 import play.db.jpa.JPA;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public class CabinetDAOImpl  implements CabinetDAO{


    @Override
    public Cabinet getCabinetById(int id) {
        EntityManager em = JPA.em("default"); // TODO why default?

        Query query = em.createNativeQuery("SELECT * from Cabinet  where id=?1 ", Cabinet.class);


        query.setParameter(1,id);

        Cabinet result = null;

        try {
            result = (Cabinet) query.getSingleResult();
        }

        catch (IllegalStateException e){
            // do nothing
        }
        em.close();
        return result;


    }

    public List<Cabinet> getCabinetsList() {
        EntityManager em = JPA.em("default");

        Query query = em.createNativeQuery("SELECT * FROM Cabinet");
        List <Cabinet> result = new ArrayList<Cabinet>();

        try {
            result = query.getResultList(); // TODO IS IT good?
        }

        catch (IllegalStateException e){
            // do nothing
        }
        em.close();
        return result;
    }


    public void AddCabinet(Cabinet cabinet) {

        EntityManager em = JPA.em("default");
        em.getTransaction().begin();
        em.persist(cabinet);
        em.getTransaction().commit();
        em.close(); // TODO INSERT RESULT
    }


    public void RemoveCabinet(int cabinetId) {

        EntityManager em = JPA.em("default");
        Query query = em.createNativeQuery("DELETE FROM Cabinet WHERE id =?1");
        query.setParameter(1,cabinetId);
        em.getTransaction().begin();
        int result = query.executeUpdate();//TODO
        em.getTransaction().commit();
        em.close();

    }


    public void RemoveAllCabinets() {
        EntityManager em = JPA.em("default");
        Query query = em.createNativeQuery("DELETE FROM Cabinet");

        em.getTransaction().begin();
        int result = query.executeUpdate();//TODO
        em.getTransaction().commit();
        em.close();

    }
}
