package by.tms.servlet.post;

import by.tms.model.Post;
import by.tms.model.User;
import by.tms.model.UserRole;
import by.tms.service.PostService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addOrNo")
public class AddOrNoServlet extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String postAddOrNo = "no publish";
        if (user.getRole()==UserRole.ADMIN_ROLE){
            int idPost = Integer.parseInt(req.getParameter("idPost"));
            String userName = req.getParameter("userName");
         postAddOrNo  = postService.PublishOrNot(idPost, userName);
        }

        req.setAttribute("post", postAddOrNo);
        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
    }
}

