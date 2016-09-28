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
@WebServlet(name = "ProtectedServlet", urlPatterns = {"/Protected"})
public class ProtectedServlet extends HttpServlet {
    UserManager userManager = new UserManager();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (userManager.compareSessions(request.getSession()))
            request.getRequestDispatcher("/WEB-INF/pages/ProtectedPage.jsp").forward(request, response);
        else
            request.getRequestDispatcher("WEB-INF/pages/NotAllowed.jsp").forward(request, response);
    }
}
