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

package javax.ws.rs.response;

import javax.ws.rs.core.HttpContext;
import javax.ws.rs.representation.Representation;
import java.net.URI;

/**
 * An abstraction for a response to a request that resulted in the creation
 * of a new resource,
 * @author Paul.Sandoz@Sun.Com
 */
public class Created extends HttpResponse {
    /**
     * The location of a newly created resource for which this is a
     * representation
     */
    private URI location;
    
    /**
     * Create a new instance
     * @param location an absolute or relative URI that identifies the newly
     * created resource. Relative URIs are relative to the request
     * URI.
     */
    public Created(URI location) {
        super(201);
        setLocation(location);
    }
    
    /**
     * Create a new instance.
     * @param r a representation of the newly created resource
     */
    public Created(Representation<?> r) {
        super(201);
        setRepresentation(r);
    }

    /**
     * Create a new instance
     * @param r a representation of the newly created resource
     * @param location an absolute or relative URI that identifies the newly
     * created resource. Relative URIs are relative to the request
     * URI.
     */
    public Created(Representation<?> r, URI location) {
        this(r);
        setLocation(location);
    }

    /**
     * Set the location of a newly created resource. When this value is non-null
     * the HTTP response status code will be putSingle to "201 Created" and a
     * "Location" header will be included in the HTTP response.
     * 
     * 
     * @param location the URI of the newly created resource. Relative URIs
     * are allowed, the runtime will resolve such URIs against the URI of the
     * resource whose method returned the representation.
     */
    public void setLocation(URI location) {
        this.location = location;
    }

    /**
     * Get the location of a newly created resource. When this value is non-null
     * the HTTP response status code will be putSingle to "201 Created" and a
     * "Location" header will be included in the HTTP response.  Relative URIs
     * are allowed, the runtime will resolve such URIs against the URI of the
     * resource whose method returned the representation.
     * 
     * 
     * @return the URI of the newly created resource
     */
    public URI getLocation() {
        return location;
    }

    /**
     * Add the HTTP headers for this type of response to the response context.
     * @param context the current HTTP context
     */
    public void addResponseHeaders(HttpContext context) {
        URI absoluteLocation = context.getHttpRequestContext().getBaseURI().resolve(location);
        context.getHttpResponseContext().getHttpHeaders().putSingle("Location", absoluteLocation.toASCIIString());
        super.addResponseHeaders(context);
    }
}
