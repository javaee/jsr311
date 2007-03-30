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

/**
 * Service-provider interface for creating container instances.
 * <p>
 * A container instance will be created according to the 
 * the supporting generic type of the container.
 * <p>
 * A provider shall support a one-to-one mapping between a type that is is not of 
 * the type Object. A provider may support 
 * more than one one-to-one mapping or a mapping of sub-types of a type
 * (that is not of the type Object). A provider shall not conflict with other
 * providers.
 * <p>
 * An implementation (a service-provider) identifies itself by placing a 
 * provider-configuration file (if not already present), 
 * "javax.ws.rs.spi.container.ContainerProvider" in the 
 * resource directory <tt>META-INF/services</tt>, and including the fully qualified
 * service-provider-class of the implementation in the file.
 *
 * @author Paul.Sandoz@Sun.Com
 */
public interface ContainerProvider<T> {
    
    /**
     * Create an container of type T.
     * <p>
     * The container provider is responsible for initiating the Web application
     * with the resource configuration.
     * <p>
     * @return the container, otherwise null if the provider does not support
     *         the requested <code>type</code>.
     * @param type the type of the container.
     * @param resourceConfig the resource configuration.
     * @param application the Web application the container delegates to for 
     *         the handling of a HTTP request.
     * @return the container, otherwise null if the provider does not support
     *         the requested <code>type</code>.
     * @throws ContainerException if there is an error creating the container.
     */
    T createContainer(Class<T> type, ResourceConfig resourceConfig, WebApplication application) 
    throws ContainerException;
}
