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

package javax.ws.rs.container;

import javax.ws.rs.core.ResourceConfig;
import javax.ws.rs.spi.container.ContainerProvider;
import javax.ws.rs.spi.container.WebApplication;
import javax.ws.rs.spi.container.WebApplicationFactory;
import javax.ws.rs.spi.service.ServiceFinder;

/**
 * Factory for creating specific containers.
 *
 * @author Paul.Sandoz@Sun.Com
 */
public final class ContainerFactory {
    
    private ContainerFactory() {
    }

    /**
     * Create a container according to the class requested.
     * <p>
     * The list of service-provider supporting the {@link ContainerProvider} 
     * service-provider will be iterated over until one returns a non-null
     * container instance.
     * <p>
     * @param type the type of the container.
     * @param resourceConfig the resource configuration containing the set
     *        of Web resources to be managed by the Web application.
     * @return the container.
     * @throws ContainerException if there is an error creating the container.
     * @throws IllegalArgumentException if no container provider supports the type.
     */
    @SuppressWarnings("unchecked")
    public static <A> A createContainer(Class<A> type, ResourceConfig resourceConfig) 
    throws ContainerException, IllegalArgumentException {        
        WebApplication wa = WebApplicationFactory.createWebApplication();
        
        for (ContainerProvider<A> rp : ServiceFinder.find(ContainerProvider.class)) {
            A r = rp.createContainer(type, resourceConfig, wa);
            if (r != null) {
                return r;
            }
        }     
        
        throw new IllegalArgumentException("No container provider supports the type " + type);
    }
    
    /**
     * Create an instance of a container according to the class requested.
     * 
     * @param type the type of the container.
     * @param packageName the name of the package where to find the resource configuration 
     *        class.
     * @return the HTTP handler, if a handler could not be created then null is 
     * returned.
     * @throws ContainerException if the resource configuration class could not
     *         be found and instantiated or there is an error creating the container.
     * @throws IllegalArgumentException if no container provider supports the type.
     */
    @SuppressWarnings("unchecked")
    public static <A> A createContainer(Class<A> type, String packageName) 
    throws ContainerException, IllegalArgumentException {
        String resourcesClassName = packageName + ".RESTBeansResources";
        try {
            Class<?> resourcesClass = ContainerFactory.class.getClassLoader().loadClass(resourcesClassName);
            ResourceConfig config = (ResourceConfig) resourcesClass.newInstance();
            return createContainer(type, config);
        } catch (ClassNotFoundException e) {
            throw new ContainerException(e);
        } catch (InstantiationException e) {
            throw new ContainerException(e);
        } catch (IllegalAccessException e) {
            throw new ContainerException(e);
        }
    }
 }