package ch.heigvd.amt.web;

import ch.heigvd.amt.services.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Henrik on 28.09.2016.
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {
    UserManager userManager = new UserManager();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (userManager.checkUser(request.getParameter("username"), request.getParameter("password"), request.getSession())) {
            System.out.println(request.getParameter("username") + " is logged in");
            request.getRequestDispatcher("/WEB-INF/pages/LoggedIn.jsp").forward(request, response);
        } else {
            System.out.println("No user called " + request.getParameter("username"));
            request.getRequestDispatcher("/WEB-INF/pages/InvalidLogin.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (userManager.isLogged(request.getSession()) == false) {
            request.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(request, response);
        } else {
            System.out.println("user is already logged in");
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
}
