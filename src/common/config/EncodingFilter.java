package common.config;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Filter to set the request character encoding.<br>
 * Required character encoding should be configured in web.xml under key <strong>encoding</strong><br>
 * "gb2312" is recommended.
 */
public class EncodingFilter implements Filter {
    // Default character encoding to set for requests
    protected String encoding = null;

    /**
     * Initialize the filter parameters
     * 
     * @param filterConfig The filter configuration object
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    /**
     * Apply filter: set request character encoding.
     *
     * @param request ServletRequest object passed in
     * @param result ServletResponse object passed out
     * @param chain FilterChain object
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain)
        throws IOException, ServletException {

        // set request encoding
        if (encoding != null && !encoding.equals("")) {
            request.setCharacterEncoding(encoding);
        }

        // Pass control on to the next filter
        chain.doFilter(request, response);
    }

    /**
     * Cleanup work to be taken when the filter is out of the service.<br>
     */
    public void destroy() {
        encoding = null;
    }
}