package ch.heigvd.amt.web.controllers;

import ch.heigvd.amt.model.User;
import ch.heigvd.amt.services.UserManager;
import ch.heigvd.amt.services.UserManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// This servlet takes care of the login
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @EJB
    private UserManagerLocal userManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Checking if the user is registered, can't log in a user that doesn't exist
        if (userManager.checkUser(request.getParameter("username"), request.getParameter("password"), request.getSession())) {
            request.getRequestDispatcher("/WEB-INF/pages/LoggedIn.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/pages/InvalidLogin.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(request, response);
    }
}
