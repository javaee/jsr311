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
     * a string. All sequences of escaped octets are decoded, equivalent to
     * <code>getURIPath(true)</code>.
     * @return the relative URI path.
     */
    public String getURIPath();
    
    /**
     * Get the URI path of the current request relative to the base URI as
     * a string.
     *
     * @param decode controls whether sequences of escaped octets are decoded
     * (true) or not (false).
     * @return the relative URI path.
     */
    public String getURIPath(boolean decode);

    /**
     * Get the URI path of the current request relative to the base URI as a 
     * list of {@link PathSegment}. This method is useful when the URI
     * path needs to be parsed, particularly when matrix parameters may be
     * present in the URI path. All sequences of escaped octets are decoded,
     * equivalent to <code>getURIPathSegments(true)</code>.
     * @return the list of {@link PathSegment}.
     * @see PathSegment
     */
    public List<PathSegment> getURIPathSegments();
    
    /**
     * Get the URI path of the current request relative to the base URI as a 
     * list of {@link PathSegment}. This method is useful when the URI
     * path needs to be parsed, particularly when matrix parameters may be
     * present in the URI path.
     * @param decode controls whether sequences of escaped octets are decoded
     * (true) or not (false).
     * @return the list of {@link PathSegment}.
     * @see PathSegment
     */
    public List<PathSegment> getURIPathSegments(boolean decode);
    
    /**
     * Get the complete URI of the request. This is a shortcut for
     * <code>uriInfo.getBaseURI().resolve(uriInfo.getURIPath()).</code>
     * @return the complete URI of the request
     */
    public URI getURI();
    
    /**
     * Get the URI of the current request in the form of a UriBuilder.
     * @return a UriBuilder initialized with the current request URI.
     */
    public UriBuilder getURIBuilder();

    /**
     * Get the base URI of the application. URIs of resource beans
     * are all relative to this base URI.
     * @return the base URI of the application
     */
    public URI getBaseURI();
    
    /**
     * Get the base URI of the application in the form of a UriBuilder.
     * @return a UriBuilder initialized with the base URI of the application.
     */
    public UriBuilder getBaseURIBuilder();
    
    /**
     * Get the values of any embedded URI parameters.
     * All sequences of escaped octets are decoded,
     * equivalent to <code>getURIParameters(true)</code>.
     * @return a map of parameter names and values.
     * @see javax.ws.rs.UriTemplate
     */
    public MultivaluedMap<String, String> getURIParameters();
    
    /**
     * Get the values of any embedded URI parameters.
     * 
     * @param decode controls whether sequences of escaped octets are decoded
     * (true) or not (false).
     * @return a map of parameter names and values.
     * @see javax.ws.rs.UriTemplate
     */
    public MultivaluedMap<String, String> getURIParameters(boolean decode);
    
    /**
     * Get the URI query parameters of the current request.
     * All sequences of escaped octets are decoded,
     * equivalent to <code>getQueryParameters(true)</code>.
     * @return a map of query parameter names and values.
     */
    public MultivaluedMap<String, String> getQueryParameters();
    
    /**
     * Get the URI query parameters of the current request.
     * @param decode controls whether sequences of escaped octets are decoded
     * (true) or not (false).
     * @return a map of query parameter names and values.
     */
    public MultivaluedMap<String, String> getQueryParameters(boolean decode);
}
