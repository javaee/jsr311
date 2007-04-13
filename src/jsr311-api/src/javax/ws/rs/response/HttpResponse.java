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
 * HttpResponse.java
 *
 * Created on February 26, 2007, 5:47 PM
 *
 */

package javax.ws.rs.response;

import javax.ws.rs.HttpHeader;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.EntityBody;
import javax.ws.rs.core.HttpStatus;

/**
 * Base class for HTTP responses. Subclasses offer specializations
 * for various common response types.
 * @author mh124079
 */
public class HttpResponse {
    /**
     * The representation of a resource that will form the entity body of a
     * response
     */
    private Representation<?> representation;
    
    private int status;
    
    private CacheControl cacheControl = null;
    
    /**
     * Create a new instance, the HTTP status code defaults to 204.
     */
    public HttpResponse() {
        status = 204;
    }
    
    /**
     * Create a new instance, the HTTP status code defaults to 200.
     * @param representation the representation that will form the entity body
     * of the HTTP response
     */
    public HttpResponse(Representation<?> representation) {
        if (representation == null)
            throw new IllegalArgumentException();
        
        status = 200;
        this.representation = representation;
    }
    
    /**
     * Create a new instance with the specified status code.
     * @param status the HTTP status code
     */
    public HttpResponse(int status) {
        this.status = status;
    }
    
    /**
     * Create a new instance
     * @param status the HTTP status code
     * @param representation the representation that will form the entity body
     * of the HTTP response
     */
    public HttpResponse(int status, Representation<?> representation) {
        if (representation == null)
            throw new IllegalArgumentException();
        
        this.status = status;
        this.representation = representation;
    }
    
    /**
     * Get the representation associated with the response. The representation
     * forms the entity body of the HTTP response.
     * @return the representation or null if none is set.
     */
    @EntityBody
    public Representation<?> getRepresentation() {
        return representation;
    }

    /**
     * Set the representation associated with the response. The representation
     * forms the entity body of the HTTP response.
     * @param representation the representation
     */
    public void setRepresentation(Representation<?> representation) {
        if (representation != null && status == 204)
            status = 200;
        this.representation = representation;
    }
    
    /**
     * Set the response status code.
     * @param status the status code, see RFC 2616.
     * @throws java.lang.IllegalArgumentException if the status code is outside the permitted range
     */
    public void setStatus(int status) throws IllegalArgumentException {
        this.status = status;
    }

    /**
     * Get the response status code.
     * @return the response status code.
     */
    @HttpStatus
    public int getStatus() {
        return this.status;
    }
    
    /**
     * Get the cache control information that will be sent with the response
     * @return cache control information
     */
    @HttpHeader("Cache-Control")
    public CacheControl getCacheControl() {
        return this.cacheControl;
    }

    
    /**
     * Set the cache control information that will be sent with the response
     * @param cacheControl cache control information
     */
    public void setCacheControl(CacheControl cacheControl) {
        this.cacheControl = cacheControl;
    }

}
