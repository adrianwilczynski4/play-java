package model;
import javax.persistence.*;
import java.util.Date;
/**
 * Created by adrian on 07.06.17.
 */

@Entity
public class PossibleVisits {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name="Doctorsname", nullable=false)
    @ManyToOne
    private int Doctorsid;

    @Temporal(TemporalType.TIME)
    private Date Hour;
    @Temporal(TemporalType.DATE)
    private Date date;

    private String fullname;
    private int bookingId;

    private String login;

    private boolean isbooked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorsid() {
        return Doctorsid;
    }

    public void setDoctorsid(int doctorsid) {
        Doctorsid = doctorsid;
    }

    public Date getHour() {
        return Hour;
    }

    public void setHour(Date hour) {
        Hour = hour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isIsbooked() {
        return isbooked;
    }

    public void setIsbooked(boolean isbooked) {
        this.isbooked = isbooked;
    }
}
