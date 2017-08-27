package model;
import javax.persistence.*;
import java.util.List;
import model.Users;

/**
 * Created by adrian on 07.06.17.
 */
@Entity
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;


    @Column(name="specializationname", nullable=false)
    private String specializationname;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecializationname() {
        return specializationname;
    }

    public void setSpecializationname(String specializationname) {
        this.specializationname = specializationname;
    }


}
