import Data.UserPassDTO;
import Function.Database;

import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.sql.*;

@Path("login")
public class LoginManager {

    public static String dburl = "jdbc:mysql://mysql59.unoeuro.com:3306/vampire_live_dk_db_g16cdio1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static String dbusername = "vampire_live_dk";
    public static String dbpassword = "b2h4k9gc";

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static String auth(UserPassDTO userPass) {
        String logOn = "";

        try {
            // CONNECT
            Connection connection = Database.connect();

            // Set statement
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT userID FROM Users WHERE userName = ? and userPassword = ?");

            // Get result
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                logOn = "UserID: " + rs.getInt(1) + " has log on";
            }

            // close stuff
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        return logOn;
    }
}
