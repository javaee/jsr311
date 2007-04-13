/*
 * HttpHeaders.java
 *
 * Created on April 13, 2007, 3:00 PM
 *
 */

package javax.ws.rs.core;

import java.util.List;

/**
 * An injectable interface that provides access to HTTP header information
 * @see HttpContext
 */
public interface HttpHeaders {
    
    /**
     * Get the values of HTTP request headers. The returned Map is case-insensitive
     * wrt keys and is read-only.
     * @return a map of header names and values.
     */
    public MultivaluedMap<String, String> getRequestHeaders();

    /**
     * Get a list of media types that are acceptable for the response. This is
     * a shortcut for <code>getHttpHeaders().get("Accept")</code>.
     * @return list of requested response media types
     */
    public List<MediaType> getAcceptableMediaTypes();
    
    /**
     * Get the media type of the entity
     * @return the media type
     */
    public MediaType getMediaType();
    
    /**
     * Get the language of the entity
     * @return the language of the entity
     */
    public String getLanguage();

    /**
     * Get a list of cookies that accompanied the request.
     * @return list of cookies
     */
    public List<Cookie> getCookies();
    
    /**
     * Get a mutable map of HTTP response headers. The returned map is case-insensitive wrt
     * keys. Values will be serialized using one of the following mechanisms in the order
     * listed:
     * <ul>
     * <li>Using an available <code>HeaderProvider</code> for the value's class</li> 
     * <li>Using the objects's <code>toString</code> method</li> 
     * </ul>
     * @return a mutable map of HTTP header names and values that will be
     * included in the response. Any headers explicitly set will override
     * automatically generated values.
     * @see javax.ws.rs.spi.header.HeaderProvider
     */
    MultivaluedMap<String, Object> getResponseHeaders();
    
    /**
     * Get a mutable list of cookies that will be set by the response
     * @return list of new cookies that will be set
     */
    List<NewCookie> getNewCookies();
}
