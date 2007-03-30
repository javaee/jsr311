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
 * HttpRequestContext.java
 *
 * Created on October 23, 2006, 2:08 PM
 *
 */

package javax.ws.rs.core;

import java.sql.Date;
import javax.ws.rs.Entity;
import java.net.URI;
import java.util.List;
import javax.ws.rs.response.HttpResponse;

/**
 * An abstraction for a HTTP request
 */
public interface HttpRequestContext {
    /**
     * Get the request entity, returns null if the request does not
     * contain an entity body.
     * @return the request entity or null
     * @param type the type of entity
     * @throws java.lang.IllegalArgumentException if the content of the request
     * cannot be mapped to an entity of the requested type
     */
    public <T> Entity<T> getEntity(Class<T> type) 
      throws IllegalArgumentException;

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
     * Get the values of HTTP request headers. The returned Map is case-insensitive
     * wrt keys.
     * @return a map of header names and values.
     */
    public MultivaluedMap<String, String> getHttpHeaders();
    
    /**
     * Get the URI query parameters of the current request.
     * <p>
     * All sequences of escaped octets are decoded.
     * @return a map of query parameter names and values.
     */
    public MultivaluedMap<String, String> getQueryParameters();
    
    /**
     * Get a list of media types that are acceptable for the response. This is
     * a shortcut for <code>getHttpHeaders().get("Accept")</code>.
     * @return list of requested response media types
     */
    public List<MediaType> getAcceptableMediaTypes();
    
    /**
     * Get a list of cookies that accompanied the request.
     * @return list of cookies
     */
    public List<Cookie> getCookies();
    
    /**
     * Get the HTTP method name
     * @return the method name as a String
     */
    public String getHttpMethod();
    
    /**
     * Evaluate request preconditions based on the passed in value.
     * @param eTag an ETag for the current state of the resource
     * @return null if the preconditions are met, a Response that should be returned if the
     * preconditions are not met.
     */
    HttpResponse evaluatePreconditions(String eTag);

    /**
     * Evaluate request preconditions based on the passed in value.
     * @param lastModified a date that specifies the modification date of the resource
     * @return null if the preconditions are met, a Response that should be returned if the
     * preconditions are not met.
     */
    HttpResponse evaluatePreconditions(Date lastModified);
    
    /**
     * Evaluate request preconditions based on the passed in value.
     * @param lastModified a date that specifies the modification date of the resource
     * @param eTag an ETag for the current state of the resource
     * @return null if the preconditions are met, a Response that should be returned if the
     * preconditions are not met.
     */
    HttpResponse evaluatePreconditions(Date lastModified, String eTag);
}
