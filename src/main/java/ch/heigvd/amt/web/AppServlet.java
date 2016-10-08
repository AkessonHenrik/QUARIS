package ch.heigvd.amt.web;

import ch.heigvd.amt.services.UserManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AppServlet", urlPatterns = {"/index"})
public class AppServlet extends HttpServlet {

    @EJB
    private UserManagerLocal userManager;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("isLogged", userManager.isLogged(request.getSession()));
        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
    }
}
