package ch.heigvd.amt.web;

import ch.heigvd.amt.services.UserManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Henrik on 28.09.2016.
 */
@WebFilter(filterName = "MagicFilter", urlPatterns = "/*")
public class AuthentificationFilter implements Filter {
    private UserManager userManager = new UserManager();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;

        //If the requested url contains "Login" or "Register", we have to make sure a logged in user cannot access these pages
        if (request.getRequestURL().toString().contains("Login") || request.getRequestURL().toString().contains("Register")) {
            if (userManager.isLogged(request.getSession())) {
                //cannot login or register again
                request.getRequestDispatcher("/").forward(request, resp);
                return;
            }

        //If the requested URL contains "Logout", we have to make sure the client is logged in to access that page
        } else if (request.getRequestURL().toString().contains("Logout")) {
            if (userManager.isLogged(request.getSession()) == false) {
                //Cannot log out
                request.getRequestDispatcher("/").forward(request, resp);
                return;
            }
        //If the requested URL contains "Protected", we have to make sure the client is logged in to access that content
        } else if(request.getRequestURL().toString().contains("Protected")) {
            if (userManager.compareSessions(request.getSession()) == false) {
                request.getRequestDispatcher("WEB-INF/pages/NotAllowed.jsp").forward(request, resp);
                return;
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
