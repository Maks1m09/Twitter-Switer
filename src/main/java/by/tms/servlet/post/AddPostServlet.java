package by.tms.servlet.post;

import by.tms.model.User;
import by.tms.service.PostService;
import by.tms.storage.MapListComment;
import by.tms.storage.MapListPost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addPost")
public class AddPostServlet extends HttpServlet {

    private final PostService postService = new PostService();
    private final MapListPost mapListPost = new MapListPost();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        int idPost = postService.getPostId();
        User user = (User) req.getSession().getAttribute("user");
        String getText = postService.createNewPost(idPost, user.getName(), text);
        String getText1 = mapListPost.methodAddInHashMap(user, postService.findPost(idPost, user.getName()));
        req.setAttribute("getText", getText1);
        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
    }

}
