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

/**
 * Service-provider interface for creating Web application instances.
 * <p>
 * An implementation (a service-provider) identifies itself by placing a 
 * provider-configuration file (if not already present), 
 * "javax.ws.rs.spi.container.WebApplicationProvider" in the 
 * resource directory <tt>META-INF/services</tt>, and including the fully qualified
 * service-provider-class of the implementation in the file.
 * <p>
 * Only the first registered provider in the provider-configuration file will
 * be used any subsequent providers (if present) will be ignored.
 *
 * @author Paul.Sandoz@Sun.Com
 */
public interface WebApplicationProvider {

    /**
     * Instantiate a new {@link WebApplication}.
     * 
     * @return the Web application.
     * @throws ContainerException if there is an error creating the Web application.
     */
    public abstract WebApplication createWebApplication()
        throws ContainerException;    
}
