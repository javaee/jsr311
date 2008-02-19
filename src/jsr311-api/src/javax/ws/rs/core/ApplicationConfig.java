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

package javax.ws.rs.core;

import java.util.List;
import java.util.Map;

/**
 * Defines the components of a JAX-RS application and supplies additional
 * metadata.
 * 
 */
public abstract class ApplicationConfig {
    
    /**
     * Get a list of root resource classes. Classes
     * not annotated with {@link javax.ws.rs.Path} will be ignored.
     * @return a list of root resource classes.
     * @see javax.ws.rs.Path
     */
    public abstract List<Class<?>> getResourceClasses();
    
    /**
     * Get a list of provider classes. Classes not implementing an extension
     * interface (one or more of {@link javax.ws.rs.ext.MessageBodyReader}, 
     * {@link javax.ws.rs.ext.MessageBodyWriter} or 
     * {@link javax.ws.rs.ext.ContextResolver}) will be ignored. The default 
     * implementation returns null.
     * @return a list of provider classes or null if none provided
     * @see javax.ws.rs.ext.Provider
     * @see javax.ws.rs.ext.MessageBodyReader
     * @see javax.ws.rs.ext.MessageBodyWriter
     * @see javax.ws.rs.ext.ContextResolver
     */
    public List<Class<?>> getProviderClasses() {
        return null;
    }
    
    /**
     * Get a map of file extensions to media types. This is used to drive 
     * URI-based content negotiation such that, e.g.:
     * <pre>GET /resource.atom</pre>
     * <p>is equivalent to:</p>
     * <pre>GET /resource
     *Accept: application/atom+xml</pre>
     * <p>The default implementation returns null.</p>
     * @return a map of file extension to media type or null if no
     * mappings are required
     */
    public Map<String, MediaType> getExtensionMappings() {
        return null;
    }
}
