package ch.heigvd.amt.web.controllers;

import ch.heigvd.amt.services.dao.UserManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AppServlet", urlPatterns = {""})
public class AppServlet extends HttpServlet {

    @EJB
    private UserManagerLocal userManager;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("isLogged", true);
//        request.setAttribute("isLogged", userManager.isLogged(request.getSession()));
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
