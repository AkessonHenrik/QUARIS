package ch.heigvd.amt.web.controllers.auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = {"auth/logout"})
public class LogoutServlet extends HttpServlet {

    /**
     * Logout the current user, invalidate the session.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        request.getSession().invalidate();

        request.setAttribute("_message", "USER_LOGGED_OUT");
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
