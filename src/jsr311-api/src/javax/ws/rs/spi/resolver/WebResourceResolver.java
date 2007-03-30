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

package javax.ws.rs.spi.resolver;

import javax.ws.rs.container.ContainerException;
import javax.ws.rs.core.HttpRequestContext;

/**
 * Resolver of a Web resource given an HTTP request.
 * <p>
 * A resolver can be used to associate state with a Web resource. For example,
 * if a Web resource is associated with the state of the HTTP request
 * an authenticated session.
 *
 * @author Paul.Sandoz@Sun.Com
 */
public interface WebResourceResolver {
    
    /**
     * Get the Web resource class. Resolving will return instances
     * of the class.
     *
     * @return the Web resource class.
     */
    Class<?> getWebResourceClass();

    /**
     * Resolve a Web resource to in instance.
     * <p>
     * If resolving results in the instantiation of a new Web resource
     * instance then the resolver shall call the 
     * {@link WebResourceResolverListener#onInstantiation} method.
     * 
     * @param request the HTTP request to use to resolve the Web resource.
     * @param listener the resolver listener
     * @return the resolved Web resource
     * @throws ContainerException if there is an error resolving the object instance.
     */
    Object resolve(HttpRequestContext request, 
            WebResourceResolverListener listener) throws ContainerException;
}
