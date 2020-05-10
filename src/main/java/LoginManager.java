import java.sql.*;
public class LoginManager {

    public static String dburl = "jdbc:mysql://mysql59.unoeuro.com:3306/vampire_live_dk_db_g16cdio1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static String dbusername = "vampire_live_dk";
    public static String dbpassword = "b2h4k9gc";

    public static String auth(String username, String password){
        String logOn =  "";
        System.out.println("Connecting database...");
        try (Connection connection = DriverManager.getConnection(dburl, dbusername, dbpassword)) {
            System.out.println("Connected database...");
            Statement stmt=connection.createStatement();
            System.out.println("execute command");
            ResultSet rs= stmt.executeQuery("SELECT userID FROM Users WHERE userName = "+username+" AND userPassword = "+password+"");
            System.out.println("executed command");

            while(rs.next()) {
               logOn =  "UserID: " + rs.getInt(1)+" has log on";
        }

            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return logOn;

    }
}
