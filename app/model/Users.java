package model;

//import java.beans.Transient;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;
/**
 * Created by adrian on 07.06.17.
 */
//@Entity
//@Table(name="users")


public class Users {



       // @Id
       // @GeneratedValue(strategy = GenerationType.AUTO)
        int id;

      //  @Column(name="firstname", nullable=false)
        private String firstname;
        private String lastname;
        private String email;
        private String login;
        private String password;
        private String address;
        private String postcode;
        private String phone;
        private String pesel;
        private boolean enabled;

       // @ManyToMany(fetch = FetchType.LAZY)
      ///  private Set <Specialization> specialization = new HashSet<Specialization>();

     //   @ManyToOne(fetch = FetchType.LAZY)

     //   private Set<UserRole> userRole = new HashSet<UserRole>(0);


        public int getId() {
                return id;
        }

        public void setId(int id) {

                this.id = id;
        }

        public String getFirstname() {
                return firstname;
        }

        public void setFirstname(String firstname) {
                this.firstname = firstname;
        }

        public String getLastname() {
                return lastname;
        }

        public void setLastname(String lastname) {
                this.lastname = lastname;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getLogin() {
                return login;
        }

        public void setLogin(String login) {
                this.login = login;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getPostcode() {
                return postcode;
        }

        public void setPostcode(String postcode) {
                this.postcode = postcode;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getPesel() {
                return pesel;
        }

        public void setPesel(String pesel) {
                this.pesel = pesel;
        }

        public boolean isEnabled() {
                return enabled;
        }

        public void setEnabled(boolean enabled) {
                this.enabled = enabled;
        }


     //   public Set<UserRole> getUserRole() {
       //         return userRole;
      //  }

     //   public void setUserRole(Set<UserRole> userRole) {
  //              this.userRole = userRole;
    //    }
}
