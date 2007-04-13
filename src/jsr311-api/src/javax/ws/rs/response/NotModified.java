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

import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.HttpContext;

/**
 * An abstraction for a HTTP response to a request containing
 * preconditions that indicates that a resource
 * has not been modified.
 * @author Paul.Sandoz@Sun.Com
 */
public class NotModified extends HttpResponse {
    /**
     * The eTag of the resource.
     */
    private EntityTag eTag;
    
    /**
     * Create a new instance.
     */
    public NotModified() {
        super(304);
    }
    
    /**
     * Create a new instance
     * @param eTag an ETag that will be returned with the response.
     */
    public NotModified(EntityTag eTag) {
        super(304);
        setETag(eTag);
    }

    /**
     * Get the eTag.
     * @return the eTag.
     */
    public EntityTag getETag() {
        return eTag;
    }

    /**
     * Set the eTag.
     * @param eTag the eTag.
     */
    public void setETag(EntityTag eTag) {
        this.eTag = eTag;
    }
    
}
