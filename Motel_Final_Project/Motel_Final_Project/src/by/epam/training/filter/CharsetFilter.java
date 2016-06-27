package by.epam.training.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CharsetFilter implements Filter {

    private String encoding;
    private ServletContext context;

    @Override
    public void destroy(){
        context = null;
    }

    @Override
    public void init(FilterConfig fConfig){
        encoding = fConfig.getInitParameter("characterEncoding");
        context = fConfig.getServletContext();
        context.log("CharsetFilter is initialized.");
        System.out.println("CharsetFilter is initialized.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {

            request.setCharacterEncoding(encoding);
            response.setCharacterEncoding(encoding);
            context.log("Charset was set.");

        } catch (UnsupportedEncodingException e) {

        }
        System.out.println("CharsetFilter doFilter.");
        chain.doFilter(request, response);
    }

}
