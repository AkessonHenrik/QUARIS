package ch.heigvd.amt.web.controllers;

import ch.heigvd.amt.services.UserManager;
import ch.heigvd.amt.services.UserManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @EJB
    private UserManagerLocal userManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (userManager.isLogged(request.getSession())) {
            userManager.logout(request.getSession());
        }
        request.getRequestDispatcher("/index").forward(request, response);
    }
}
