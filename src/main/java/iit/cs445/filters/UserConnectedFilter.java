package iit.cs445.filters;

import iit.cs445.models.users.User;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserConnectedFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        String path = new UrlPathHelper().getPathWithinApplication((HttpServletRequest) request);
        String pathTwo = new UrlPathHelper().getContextPath((HttpServletRequest) request);
        Logger.getLogger(UserConnectedFilter.class.getName()).log(Level.INFO, "Path is: " + path);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            Logger.getLogger(UserConnectedFilter.class.getName()).log(Level.INFO, "User is: " + session.getAttribute("user"));
            try {
                chain.doFilter(request, response);
            } catch (Exception ex) {
                ((HttpServletResponse) response).sendRedirect("/WEB-INF/jsp/index.jsp");
            }
        } else {
            if (path.equals("") || path.equals("/") || path.equals("/index") || path.equals("/login") || path.contains("/static") || path.contains("/users/add") || path.equals("/users")) {
                Logger.getLogger(UserConnectedFilter.class.getName()).log(Level.INFO, "Valid path is: " + path);
                chain.doFilter(request, response);
            } else {
                Logger.getLogger(UserConnectedFilter.class.getName()).log(Level.INFO, "Path is invalid doing redirect.");
                ((HttpServletResponse) response).sendRedirect(pathTwo + "/");
            }
        }

    }

}