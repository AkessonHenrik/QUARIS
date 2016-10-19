package ch.heigvd.amt.web.filters;

import ch.heigvd.amt.services.dao.UserManagerLocal;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(filterName = "MagicFilter", urlPatterns = "/*")
//@Provider
public class AuthentificationFilter implements Filter {
    @EJB
    private UserManagerLocal userManager;

    public AuthentificationFilter() throws SQLException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;

        // If the requested url contains "Login" or "Register", we have to make sure a logged in user cannot access these pages
        if (request.getRequestURL().toString().contains("login") || request.getRequestURL().toString().contains("register")) {
            if (userManager.isLogged(request.getSession())) {
                // cannot login or register again
                request.getRequestDispatcher("/").forward(request, resp);
                return;
            }

        // If the requested URL contains "Logout", we have to make sure the client is logged in to access that page
        } else if (request.getRequestURL().toString().contains("logout")) {
            if (userManager.isLogged(request.getSession()) == false) {
                //Cannot log out
                request.getRequestDispatcher("/").forward(request, resp);
                return;
            }
        // If the requested URL contains "Protected", we have to make sure the client is logged in to access that content
        } else if(request.getRequestURL().toString().contains("protected")) {
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
