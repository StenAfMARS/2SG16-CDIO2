import Data.UserDTO;
import Function.SaveInDatabase;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "rest API",
        urlPatterns = "/rest/*",
        loadOnStartup = 1)
public class MainServlet extends HttpServlet {

    private static SaveInDatabase userList = new SaveInDatabase();

    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getPathInfo();
        PrintWriter writer = resp.getWriter();
        System.out.println(uri);

        HttpSession session = req.getSession();





        switch (uri){
            case "/login":
                session.setAttribute(
                    "user",
                    LoginManager.auth(
                        req.getParameter("username"),
                        req.getParameter("password"))
                );
                break;
            case "/getUser":
                try {
                    int userID = Integer.parseInt(req.getParameter("userID"));

                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");

                    gson.toJson(userList.getUser(userID));
                }catch (Exception e){
                    writer.println("500 internal server error");
                }
                break;
            case "/getUsers":
                try {
                    gson.toJson(userList.getUserList());
                }catch (Exception e){
                    writer.println("500 internal server error");
                }
                break;
            case "/createUser":
                try {
                    UserDTO user = constructUserDTO(req);

                    userList.createUser(user);
                }catch (Exception e){
                    writer.println("500 internal server error");
                }
                break;
            case "/updateUser":
                try {
                    UserDTO user = constructUserDTO(req);

                    userList.updateUser(user);
                }catch (Exception e){
                    writer.println("500 internal server error");
                }
                break;
            case "/deleteUser":
                try {
                    int userID = Integer.parseInt(req.getParameter("userID"));

                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");

                    userList.deleteUser(userID);
                }catch (Exception e){
                    writer.println("500 internal server error");
                }
                break;
            default:
                writer.println("404 API not found");
                break;
        }

        writer.flush();
        writer.close();
    }

    private UserDTO constructUserDTO(HttpServletRequest req) {
        UserDTO user = new UserDTO();

        user.setUserID(Integer.parseInt(req.getParameter("userID")));
        user.setUserName(req.getParameter("userID"));
        user.setPassword(req.getParameter("userID"));
        user.setCpr(req.getParameter("userID"));
        user.setIni(req.getParameter("userID"));

        return user;
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}