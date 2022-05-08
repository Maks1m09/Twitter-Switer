package by.tms.servlet.user;

import by.tms.model.Post;
import by.tms.model.User;
import by.tms.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/change")
public class ChangeUserServlet extends HttpServlet {
    private final   UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> all = userService.findAllUser();
        req.setAttribute("all", all);
        getServletContext().getRequestDispatcher("/changeUserRole.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        userService.changeUser(userName);
        getServletContext().getRequestDispatcher("/changeUserRole.jsp").forward(req, resp);

    }
}
