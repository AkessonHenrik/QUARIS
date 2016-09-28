package ch.heigvd.amt.web;

import ch.heigvd.amt.services.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Henrik on 28.09.2016.
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/Register"})
public class RegisterServlet extends HttpServlet {
    UserManager userManager = new UserManager();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userManager.addUser(request.getParameter("username"), request.getParameter("password"), request.getSession());
        request.getRequestDispatcher("/WEB-INF/pages/LoggedIn.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/Register.jsp").forward(request, response);
    }
}
