package by.tms.servlet.post;

import by.tms.model.User;
import by.tms.model.UserRole;
import by.tms.service.PostService;
import by.tms.storage.MapListPost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletePost")
public class DeletePostServlet extends HttpServlet {

    private final PostService postService = new PostService();
    private final MapListPost mapListPost = new MapListPost();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPost = Integer.parseInt(req.getParameter("idPost"));
        User user = (User) req.getSession().getAttribute("user");
//        if (user.getRole().equals(UserRole.ADMIN_ROLE)){
//            String loginUser = postService.getPostId();
//            postService.deletePostById(idPost, loginUser);
//        } else {
//        postService.deletePostById(idPost, user);
//    }
//        String getText = postService.deletePostById(idPost, user);

        String userName = user.getName();
        if (user.getRole()== UserRole.ADMIN_ROLE){
            userName = req.getParameter("userName");
        }
       // String getText = mapListPost.methodDeletePostById(idPost, user);
        String getText = mapListPost.methodDeletePostById(idPost,  userName);
        req.setAttribute("getText", getText);
        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
    }
}
