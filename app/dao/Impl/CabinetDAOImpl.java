package dao.Impl;

import dao.CabinetDAO;
import model.Cabinet;
 import play.db.jpa.JPA;
import play.db.jpa.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public class CabinetDAOImpl  implements CabinetDAO{

    @Transactional(readOnly = true)
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
    @Override
    @Transactional(readOnly = true)
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
    @Override
    @Transactional
    public void AddCabinet(Cabinet cabinet) {

        EntityManager em = JPA.em("default");

        em.persist(cabinet);

        em.close(); // TODO INSERT RESULT
    }
    @Override
    @Transactional
    public void RemoveCabinet(int cabinetId) {

        EntityManager em = JPA.em("default");
        em.remove(em.find(Cabinet.class,cabinetId));


        em.close();

    }
    @Override
    @Transactional
    public void RemoveAllCabinets() {
        EntityManager em = JPA.em("default");
        Query query = em.createNativeQuery("DELETE FROM Cabinet");


        int result = query.executeUpdate();//TODO

        em.close();

    }
}
