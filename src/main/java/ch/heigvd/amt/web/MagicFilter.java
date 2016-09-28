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
public class MagicFilter implements Filter {
    private UserManager userManager = new UserManager();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("In filter");
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println(request.getRequestURL().toString());
        if (request.getRequestURL().toString().contains("Login") || request.getRequestURL().toString().contains("Register")) {
            if (userManager.isLogged(request.getSession())) {
                System.out.println("Already logged in or registered");
                //cannot login or register again
                request.getRequestDispatcher("/").forward(request, resp);
                return;
            }

        } else if (request.getRequestURL().toString().contains("Logout")) {
            if (userManager.isLogged(request.getSession()) == false) {
                //Cannot log out
                System.out.println("Not even logged in");
                request.getRequestDispatcher("/").forward(request, resp);
                return;
            }
        }
        System.out.println("Passing through filter");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
