import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hi")
public class world {
    @GET
    public String hi(){
        return "Hello World";
    }
}
