package model;
import javax.annotation.Nullable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Time;
import model.Cabinet;
/**
 * Created by adrian on 07.06.17.
 */
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Nullable
    private int DoctorsId;
    @ManyToOne
    private Cabinet Roomnr;

    @Temporal(TemporalType.TIME)
    private Date Length;


    @Temporal(TemporalType.DATE)
    private Date Date;

    @Temporal(TemporalType.TIME)
    private Date Starttime;


    @Temporal(TemporalType.TIME)
    private  Date Endtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorsId() {
        return DoctorsId;
    }

    public void setDoctorsId(int doctorsId) {
        DoctorsId = doctorsId;
    }

    public Cabinet getRoomnr() {
        return Roomnr;
    }

    public void setRoomnr(Cabinet roomnr) {
        Roomnr = roomnr;
    }

    public java.util.Date getLength() {
        return Length;
    }

    public void setLength(java.util.Date length) {
        Length = length;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public java.util.Date getStarttime() {
        return Starttime;
    }

    public void setStarttime(java.util.Date starttime) {
        Starttime = starttime;
    }

    public java.util.Date getEndtime() {
        return Endtime;
    }

    public void setEndtime(java.util.Date endtime) {
        Endtime = endtime;
    }



}
