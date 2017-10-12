package controllers;

import model.UserRole;
import model.Users;
import org.h2.engine.User;
import play.data.FormFactory;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.Impl.UserDetailsServiceImpl;
import services.RoleService;
import services.UserDetailsService;


import views.html.UsersManagement;
import javax.inject.Inject;
import java.util.List;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class UsersManagementController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    @Inject
    UserDetailsService userService;

    @Inject
    RoleService roleService;

    @Inject
    FormFactory formFactory;

    public  void AddUser(Users user){

        Form<Users> userForm = formFactory.form(Users.class);
        UserDetailsService ser = new UserDetailsServiceImpl();
        ser.addUser(user);

        //user.getUserRole();

    }

    public  Result DeleteUser(Long userId){

        userService.deleteUser(userId);
        return redirect("/usersManagement");
    }


    public  Result EditUser(Users user){


        userService.editUser(user);
        return redirect("/usersManagement");
    }


    public  Result showUserToEdit(Long userId){



       Users user= userService.getUserById(userId);
        return ok(views.html.UsersManagement.render(null,user));
    }
    public   Result showUsersWithRole(Long RoleId) {


        String RoleName= roleService.getRoleByID(RoleId).getRole();
        List<Users> UsersWithRole=userService.getUsersListByRole(RoleName);
        return ok(views.html.UsersManagement.render(UsersWithRole,null));
    }



    public Result chooseUsersWithRole(){


        List <UserRole> roleList = roleService.getRoleList();
        return ok(views.html.ChooseUserWithRole.render(roleList));
    }

}