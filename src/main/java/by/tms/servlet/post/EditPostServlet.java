package by.tms.servlet.post;

import by.tms.model.User;
import by.tms.model.UserRole;
import by.tms.service.PostService;
import by.tms.storage.MapListComment;
import by.tms.storage.MapListPost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePost")
public class EditPostServlet extends HttpServlet {

    private final PostService postService = new PostService();
    private final MapListPost mapListPost = new MapListPost();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPost = Integer.parseInt(req.getParameter("idPost"));
        String text = req.getParameter("text");
        User user = (User) req.getSession().getAttribute("user");
        String userName = user.getName();
        if (user.getRole()== UserRole.ADMIN_ROLE){
            userName = req.getParameter("userName");
        }

//        String getText = postService.isEditPostId(idPost, text, user);
        String getText = mapListPost.methodEditPostById(idPost, text, userName);
        req.setAttribute("getText", getText);
        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
    }

}
