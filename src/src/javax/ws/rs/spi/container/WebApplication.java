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

package javax.ws.rs.spi.container;

import javax.ws.rs.container.ContainerException;
import javax.ws.rs.core.ResourceConfig;
import javax.ws.rs.spi.resolver.WebResourceResolverFactory;

/**
 * A Web application that manages a set of Web resource.
 *
 * @author Paul.Sandoz@Sun.Com
 */
public interface WebApplication {
    /**
     * Initiate the Web application.
     * @param resourceConfig the resource configuration containing the set
     *        of Web resources to be managed by the Web application.
     * @param resolverFactory the Web resource resolver factory to be used
     *        for creating Web resource resolvers for the managed set of 
     *        Web resources.
     * @throws IllegalArgumentException if resourceConfig is null.
     */
    void initiate(ResourceConfig resourceConfig, 
            WebResourceResolverFactory resolverFactory) throws IllegalArgumentException;
    
    /**
     * Handle an HTTP request by dispatching the request to the appropriate
     * matching Web resource that produces the response or otherwise producing 
     * the appropriate HTTP error response.
     * <p>
     * @param request the HTTP container request.
     * @param response the HTTP container response.
     * @throws ContainerException if there is an error that the container 
     * should manage.
     */
    void handleRequest(ContainerRequest request, ContainerResponse response)
    throws ContainerException;
}