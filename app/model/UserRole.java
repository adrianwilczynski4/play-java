package model;
import javax.persistence.*;
/**
 * Created by adrian on 07.06.17.
 */

@Entity
public class UserRole {

    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private Integer id;

    private String role;

    private Integer AuthorisationDegree;

    public Integer getAuthorisationDegree() {
        return AuthorisationDegree;
    }

    public void setAuthorisationDegree(Integer authorisationDegree) {
        AuthorisationDegree = authorisationDegree;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

