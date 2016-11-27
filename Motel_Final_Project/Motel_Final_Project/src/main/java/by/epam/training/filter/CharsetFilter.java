package by.epam.training.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
/**
 * Class {@code CharsetFilter} is the class, that implements {@code Filter} interface to
 * process with different encodings of Russian and English languages.
 * @author Mikhail Kerko
 */
public class CharsetFilter implements Filter {

    private String encoding;
    private ServletContext context;

    private final static Logger logger = Logger.getRootLogger();
    @Override
    public void destroy(){
        context = null;
    }
    /**
     * <p>Sets initial encoding for the system.</p>
     * <p>
     * @param fConfig is the configuration of the encoding.
     */
    @Override
    public void init(FilterConfig fConfig){
        encoding = fConfig.getInitParameter("characterEncoding");
        context = fConfig.getServletContext();
        context.log("CharsetFilter is initialized.");
        logger.info("CharsetFilter is initialized.");
    }
    /**
     * <p>Sets necessary encoding for the next pages through responses.</p>
     * @param request Request we are processing
     * @param response Response we are creating
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {

            request.setCharacterEncoding(encoding);
            response.setCharacterEncoding(encoding);
            context.log("Charset was set.");

        } catch (UnsupportedEncodingException e) {
            logger.warn("Unsupported Encoding Exception catch.");
        }
        logger.info("CharsetFilter doFilter.");
        chain.doFilter(request, response);
    }

}
