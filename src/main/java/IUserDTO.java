public interface IUserDTO {
    UserDTO getUser(int userID);
    UserDTO getUser(String userName, String ini, String cpr, String[] roles);
    UserDTO[] getUsers();
    boolean updateUser(UserDTO user);
    boolean deleteUser(int userID);
}
