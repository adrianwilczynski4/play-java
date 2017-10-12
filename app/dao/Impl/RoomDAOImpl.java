package dao.Impl;

import dao.RoomDAO;
import model.Room;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public class RoomDAOImpl implements RoomDAO {
    @Transactional(readOnly = true)
    @Override
    public List<Room> getRoomsByFeature(Room room) {
        List<Room> result = new ArrayList<Room>();
        EntityManager em = JPA.em();
        StringBuilder queryString = new StringBuilder("SELECT * from ROOM " );

        if(room.getDate()!=null){
          queryString.append("WHERE DATE="+room.getDate());
      }

      if(room.getStarttime()!=null){
            queryString.append(" WHERE STARTTIME>="+room.getStarttime());
      }
      if(room.getEndtime()!=null){
          queryString.append(" WHERE ENDTIME<="+room.getEndtime());
      }
      if(room.getDoctorsId()!=(-1)){
          queryString.append(" WHERE doctorsid="+room.getDoctorsId());

      }



        Query  query = em.createNativeQuery(String.valueOf(queryString));

      try {
       result =   query.getResultList();
      }
      catch (Exception e){
         //do nothing
      }
        return result;
    }
    @Transactional(readOnly = true)
    @Override
    public List<Room> getAllRoomsList() {

        List<Room> result = new ArrayList<Room>();
        EntityManager em = JPA.em();


        Query  query = em.createNativeQuery(String.valueOf("SELECT * from ROOM "));

        try {
            result =   query.getResultList();
        }
        catch (Exception e){
            //do nothing
        }
        em.close();
        return result;
    }

    @Transactional
    @Override
    public void AddRoom(Room room) {

        EntityManager em = JPA.em("default");

        em.persist(room);

        em.close();
    }
    @Transactional
    @Override
    public void editRoom(Room room) {

        EntityManager em = JPA.em();
        em.merge(room);
        em.close();
    }
    @Transactional
    @Override
    public void removeRoom(Room room) {


        EntityManager em = JPA.em("default");


        em.remove(room);

        em.close();

    }
}
