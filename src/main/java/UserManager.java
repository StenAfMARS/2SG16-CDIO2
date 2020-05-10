import dto.UserPassDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("user")
public class UserManager {

    @Path("test")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public UserPassDTO test(){
        UserPassDTO output = new UserPassDTO();
        output.setUsername("hello");
        output.setPassword("world");
        return output;
    }

    @Path("login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static String auth(UserPassDTO userPassDTO){
        System.out.println(userPassDTO.getUsername());
        return "hello " + userPassDTO.getUsername();
    }
}
