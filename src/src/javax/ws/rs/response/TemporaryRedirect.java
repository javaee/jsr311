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
 * TemporaryRedirect.java
 *
 * Created on February 26, 2007, 6:06 PM
 *
 */

package javax.ws.rs.response;

import javax.ws.rs.core.HttpContext;
import java.net.URI;

/**
 * An abstraction for a HTTP response to temporarily redirect a client to
 * a new URI.
 */
public class TemporaryRedirect extends HttpResponse {
    /**
     * The location where clients wil be redirected
     */
    private URI location;
    
    /** Creates a new instance of TemporaryRedirect */
    public TemporaryRedirect() {
        super(307);
    }

    /**
     * Creates a new instance of TemporaryRedirect
     * @param location the location where clients wil be redirected. Relative URIs
     * are allowed, the runtime will resolve such URIs against the URI of the
     * resource whose method returned the representation.
     */
    public TemporaryRedirect(URI location) {
        super(307);
        setLocation(location);
    }

    /**
     * Set the location where clients wil be redirected.
     * 
     * @param location the location where clients wil be redirected. Relative URIs
     * are allowed, the runtime will resolve such URIs against the URI of the
     * resource whose method returned the representation.
     */
    public void setLocation(URI location) {
        this.location = location;
    }

    /**
     * Get the location where clients wil be redirected. Relative URIs
     * are allowed, the runtime will resolve such URIs against the URI of the
     * resource whose method returned the representation.
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
