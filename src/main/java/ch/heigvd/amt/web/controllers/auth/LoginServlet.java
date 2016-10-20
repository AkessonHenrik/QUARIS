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

//    private boolean isLogged() {
//        return request.getSession().getAttribute("username") != null;
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------");
        System.out.println("-----------");

        if (request.getSession().getAttribute("username") != null) {
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form infos
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Checking if the user is registered, can't log in a user that doesn't exist
        User user = userManager.getUserByUsername(username);

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        // User does exists or the password correct
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user); // TODO Use UserDTO ?
            request.setAttribute("isLogged", true);
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/pages/InvalidLogin.jsp").forward(request, response);
        }
    }
}
