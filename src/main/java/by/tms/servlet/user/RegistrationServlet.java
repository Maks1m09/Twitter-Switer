package by.tms.servlet.user;

import by.tms.model.User;
import by.tms.model.UserRole;
import by.tms.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        UserRole roleForUser;

        roleForUser = UserRole.ADMIN_ROLE;

//        if (role.contains("admin")) {
//            roleForUser = UserRole.ADMIN_ROLE;
//        } else {
//            roleForUser = UserRole.USER_ROLE;
//        }
       User user = new User(name, login, password, roleForUser);
//        if (name == null && login == null && password == null) {
//            System.out.println("User not created");
//        }

        boolean isAdded = userService.add(user);
        if (isAdded) {
            resp.getWriter().println("Ok");
        } else {
            resp.getWriter().println("Error");
        }
        getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }

}
