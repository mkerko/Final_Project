package by.epam.training.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/**
 * Class {@code LocaleFilter} is the class, that implements {@code Filter} interface to
 * deal with localization in the system.
 * @author Mikhail Kerko
 */
public class LocaleFilter implements Filter {
    private static final String ATTR_LOCALE = "locale";
    private static final String EN_LOCALE = "en";
    private static final String RU_LOCALE = "ru";
    private String locale;
    private final static Logger logger = Logger.getRootLogger();
    /**
     * <p>Sets initial locale for the system.</p>
     * <p>
     * @param fConfig is the configuration of the filter.
     */
    @Override
    public void init(FilterConfig fConfig){
        locale = "ru";
        logger.info("LocaleFilter is initialized.");
    }
    /**
     * <p>Sets necessary locale for the next pages.</p>
     * @param request is necessary to get actual locale and set next one.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getSession().getAttribute(ATTR_LOCALE) == null) {
            req.getSession().setAttribute(ATTR_LOCALE, locale);
        }
        if (req.getSession().getAttribute(ATTR_LOCALE) == EN_LOCALE) {
            req.getSession().setAttribute(ATTR_LOCALE, EN_LOCALE);
        }
        if (req.getSession().getAttribute(ATTR_LOCALE) == RU_LOCALE) {
            req.getSession().setAttribute(ATTR_LOCALE, RU_LOCALE);
        }
        logger.info("LocaleFilter doFilter.");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {    }
}
