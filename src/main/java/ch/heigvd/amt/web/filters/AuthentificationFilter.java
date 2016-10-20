package ch.heigvd.amt.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "AuthentificationFilter", urlPatterns = {
        "/logout",
        "/admin",
        "/admin/*"
})
//@Provider
public class AuthentificationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;

        if (request.getSession().getAttribute("user") == null) {
            request.setAttribute("_message", "NOT_ALLOWED");
            request.getRequestDispatcher("WEB-INF/auth/login.jsp").forward(request, resp);
            return;
        }

        chain.doFilter(request, resp);
    }

    @Override
    public void destroy() {

    }
}
