import Data.UserDTO;
import Data.UserPassDTO;
import Function.IUserDAO;
import Function.SaveInDatabase;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("user")
public class UserManager{
    private static IUserDAO users;
    public static IUserDAO Users(){
        if (users == null)
            users = new SaveInDatabase();
        return users;
    }

    @Path("test")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public UserPassDTO test(){
        UserPassDTO output = new UserPassDTO();
        output.setUsername("hello");
        output.setPassword("world");
        return output;
    }

    @Path("getUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public static UserDTO auth(UserDTO user){
        System.out.println(user.getUserID());

        return users.getUser(user.getUserID());
    }
}
