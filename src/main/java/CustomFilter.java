import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "customFilter", urlPatterns = {"/*"})
public class CustomFilter implements javax.servlet.Filter  {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("protocol is " + servletRequest.getProtocol());
        System.out.println("remote host is " + servletRequest.getRemoteHost());
        System.out.println("content type is " + servletRequest.getContentType());
        System.out.println("content length is " + servletRequest.getContentLength());
        System.out.println("username is " + servletRequest.getParameter("username"));

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
