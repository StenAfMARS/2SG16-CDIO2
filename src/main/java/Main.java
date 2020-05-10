import Data.UserDTO;
import Function.SaveInDatabase;

public class Main {
    public static void main(String[] args) {
        SaveInDatabase database = new SaveInDatabase();

        for (UserDTO user: database.getUserList()) {
            System.out.println(user.getUserID());
        }

        System.out.println(database.getUser(2).getUserName());
    }
}
