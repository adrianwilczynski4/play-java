package model;
import javax.persistence.*;
/**
 * Created by adrian on 07.06.17.
 */

@Entity
public class Cabinet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name="Category", nullable=false)
    private String Category;



    private String Nr;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getNr() {
        return Nr;
    }

    public void setNr(String nr) {
        Nr = nr;
    }
}
