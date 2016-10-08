package ch.heigvd.amt.web.controllers;

import ch.heigvd.amt.services.UserManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProtectedServlet", urlPatterns = {"/protected"})
public class ProtectedServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("isLogged", true);
        request.getRequestDispatcher("/WEB-INF/pages/ProtectedPage.jsp").forward(request, response);
    }
}
