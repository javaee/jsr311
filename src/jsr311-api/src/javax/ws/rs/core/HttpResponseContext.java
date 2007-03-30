/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 * 
 * You can obtain a copy of the license at
 * http://www.opensource.org/licenses/cddl1.php
 * See the License for the specific language governing
 * permissions and limitations under the License.
 */

/*
 * HttpResponseContext.java
 *
 * Created on October 23, 2006, 2:18 PM
 *
 */

package javax.ws.rs.core;

import javax.ws.rs.response.HttpResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Encapsulates the response to a HTTP request.
 */
public interface HttpResponseContext {
    
    /**
     * Set the response object. If not set an empty '200 OK' will be
     * sent.
     * @param response A representation of the response that will be carried in the HTTP response
     */
    void setHttpResponse(HttpResponse response);
    
    /**
     * Get the response object.
     * @return the response object, or null if no response has been set
     */
    HttpResponse getHttpResponse();
    
    /**
     * Get an OutputStream to which a representation may be written. The first
     * byte written will cause any headers currently set to be flushed.
     * @return the output stream
     * @throws java.io.IOException if an IO error occurs
     */
    OutputStream getOutputStream() throws IOException;
    
        
    /**
     * Get a mutable map of HTTP response headers. The returned map is case-insensitive wrt
     * keys. Values will be serialized using one of the following mechanisms in the order
     * listed:
     * <ul>
     * <li>Using an available <code>HeaderProvider</code> for the value's class</li> 
     * <li>Using the objects's <code>toString</code> method</li> 
     * </ul>
     * Note that <code>setHttpResponse</code> can change the HTTP response
     * headers and may overwrite headers set previously.
     * @return a mutable map of HTTP header names and values that will be
     * included in the response. Any headers explicitly set will override
     * automatically generated values.
     * @see javax.ws.rs.spi.header.HeaderProvider
     */
    MultivaluedMap<String, Object> getHttpHeaders();
    
    /**
     * Get a mutable list of cookies that will be set by the response
     * @return list of new cookies that will be set
     */
    List<NewCookie> getNewCookies();
        
}
