package by.epam.training.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;

public class RequestFilter implements Filter {

    private ServletContext context;
    private final static Logger logger = Logger.getRootLogger();
    private static final String COD="SHA-1";

    @Override
    public void destroy(){
        context = null;
    }

    @Override
    public void init(FilterConfig fConfig){
        context = fConfig.getServletContext();
        context.log("RequestFilter is initialized.");
        logger.info("RequestFilter is initialized.");
    }
    /**
     * Authenticate the user making this request, based on the specified
     * login configuration.
     *
     * @param request Request we are processing
     * @param response Response we are creating
     * @param chain Login configuration describing how authentication
     *              should be performed
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if an doFilter method error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        try {
            Enumeration<String> params = req.getParameterNames();
            while (params.hasMoreElements()) {
                String param = params.nextElement();
                if (param.equals("password")) {

                    logger.info("Filter catch password.");
                    String hash = getHash(req.getParameter(param));
                    request.setAttribute("pass", hash);
                    req.setAttribute("pass", hash);
                }

            }
        } catch (NoSuchAlgorithmException e) {
            logger.warn("Can not getHash in Filter.");
        }
        logger.info("RequestFilter doFilter.");
        chain.doFilter(req, response);
    }
    /**
     * Transforms password into hex number.
     * @param string password we are processing.
     * @exception NoSuchAlgorithmException if an MessageDigest error occurs
     */
    private static String getHash( String string) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance(COD);
        StringBuffer  hexString = new StringBuffer();

        sha.reset();
        sha.update(string.getBytes());
        byte[] array = sha.digest();

        for (int i = 0; i < array.length; i++) {
            hexString.append(Integer.toHexString(0xFF & array[i]));
        }
        logger.info("=============================\nHASH: " + hexString + "\n========================================");
        return hexString.toString();
    }
}
