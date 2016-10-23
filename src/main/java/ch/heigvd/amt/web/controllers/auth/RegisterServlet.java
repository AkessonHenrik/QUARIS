/**
 * @author Henrik Akesson
 * @author Fabien Salathe
 */
package ch.heigvd.amt.web.controllers.auth;

import ch.heigvd.amt.models.User;
import ch.heigvd.amt.services.dao.UserManagerLocal;
import ch.heigvd.amt.utils.validations.UserValidation;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "RegisterServlet", urlPatterns = {"auth/register"})
public class RegisterServlet extends HttpServlet {

    @EJB
    private UserManagerLocal userManager;

    // http://stackoverflow.com/a/8204716/1066915
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * Show the register form
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/auth/register.jsp").forward(request, response);
    }

    /**
     * Handle a login request for a new user
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean validation = true;

        if (!UserValidation.username(username)) {
            validation = false;
            request.setAttribute("_message", "INVALID_USERNAME");
        }

        if (!UserValidation.password(password)) {
            validation = false;
            request.setAttribute("_message", "INVALID_PASSWORD");
        }

        if (!UserValidation.email(email)) {
            validation = false;
            request.setAttribute("_message", "INVALID_EMAIL");
        }

        if (validation && userManager.addUser(new User(email, username, password))) {
            request.setAttribute("_message", "USER_CREATED");
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        } else {
            request.setAttribute("_message", "USERNAME_ALREADY_EXISTS");
            request.getRequestDispatcher("/WEB-INF/auth/register.jsp").forward(request, response);
        }
    }
}
