package ch.heigvd.amt.web.controllers.auth;

import ch.heigvd.amt.models.User;
import ch.heigvd.amt.services.dao.UserManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"auth/login"})
public class LoginServlet extends HttpServlet {

    @EJB
    private UserManagerLocal userManager;

    /**
     * Show the login form
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(request, response);
        }
    }

    /**
     * Handle a login request to log a user
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form info
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Checking if the user is registered, can't log in a user that doesn't exist
        User user = userManager.getUserByUsername(username);

        // User does exists or the password correct
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user); // TODO Use UserDTO ?

            request.setAttribute("_message", "USER_LOGGED");
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        } else {
            request.setAttribute("_message", "INVALID_LOGIN");
            request.getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(request, response);
        }
    }
}
