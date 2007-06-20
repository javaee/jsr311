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
 * UriInfo.java
 *
 * Created on April 13, 2007, 2:55 PM
 *
 */

package javax.ws.rs.core;

import java.net.URI;
import java.util.List;

/**
 * An injectable interface that provides access to request URI information
 * @see HttpContext
 * @author mh124079
 */
public interface UriInfo {
    
    /**
     * Get the URI path of the current request relative to the base URI as
     * a string.
     * <p>
     * All sequences of escaped octets are decoded.
     * @return the relative URI path.
     */
    public String getURIPath();
    
    /**
     * Get the URI path of the current request relative to the base URI as a 
     * list of {@link PathSegment}. This method is useful when the URI
     * path needs to be parsed, particularly when matrix parameters may be
     * present in the URI path.
     * @return the list of {@link PathSegment}.
     * @see PathSegment
     */
    public List<PathSegment> getURIPathSegments();
    
    /**
     * Get the complete URI of the request.
     * <p>
     * This is equivalent to the URI that is produce from the
     * the following method calls on an instance of HttpRequestContext:
     * <p>
     * <code>request.getBaseURI().resolver(request.getURIPath()).</code>
     * @return the complete URI of the application
     */
    public URI getURI();
    
    /**
     * Get the base URI of the REST beans application. URIs of resource beans
     * are all relative to this base URI.
     * @return the base URI of the application
     */
    public URI getBaseURI();
    
    /**
     * Get the values of any embedded URI parameters.
     * <p>
     * All sequences of escaped octets are decoded.
     * @return a map of parameter names and values.
     * @see javax.ws.rs.UriTemplate
     */
    public MultivaluedMap<String, String> getURIParameters();
    
    /**
     * Get the URI query parameters of the current request.
     * <p>
     * All sequences of escaped octets are decoded.
     * @return a map of query parameter names and values.
     */
    public MultivaluedMap<String, String> getQueryParameters();
    
}
