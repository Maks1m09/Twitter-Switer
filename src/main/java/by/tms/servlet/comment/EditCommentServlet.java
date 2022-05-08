package by.tms.servlet.comment;

import by.tms.model.User;
import by.tms.model.UserRole;
import by.tms.storage.MapListComment;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateComment")
public class EditCommentServlet extends HttpServlet {

    private final MapListComment mapListComment = new MapListComment();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/comment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPost = Integer.parseInt(req.getParameter("idPost"));
        int idComment = Integer.parseInt(req.getParameter("idComment"));
        String newText = req.getParameter("text");
        User user = (User) req.getSession().getAttribute("user");

        String userName = user.getName();
        if (user.getRole()== UserRole.ADMIN_ROLE){
            userName = req.getParameter("userName");
        }
        String getText = mapListComment.methodEditCommentByIdInPost(idPost, idComment, newText, userName);
        req.setAttribute("getText", getText);
        getServletContext().getRequestDispatcher("/comment.jsp").forward(req, resp);
    }

}
