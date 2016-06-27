package by.epam.training.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LocaleFilter implements Filter {

    private static final String ATTR_LOCALE = "locale";
    private static final String EN_LOCALE = "en";
    private static final String RU_LOCALE = "ru";


    private String locale;

    @Override
    public void init(FilterConfig fConfig){
        locale = "ru";
        System.out.println("LocaleFilter is initialized.");
    }

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
        System.out.println("LocaleFilter doFilter.");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {    }
}
