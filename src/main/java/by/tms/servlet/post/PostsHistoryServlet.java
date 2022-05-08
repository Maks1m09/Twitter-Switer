package by.tms.servlet.post;

import by.tms.model.Post;
import by.tms.model.User;
import by.tms.service.PostService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/postHistory")
public class PostsHistoryServlet extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        List<Post> all = postService.findAll(user);

//        int idPost = 1;
//        List<Comment> commentList = mapListComment.methodAddCommentsByIdPost(idPost);
//
//        //for (HashMap mapItem : all) {
//            for (int i = 1; i <= commentList.size(); i++) {
//                Comment comment = commentList.get(i);
//                postService.addCommentById(idPost, comment);
//            }
//            idPost++;
//        //}

        req.setAttribute("all", all);
        getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);
    }

}
