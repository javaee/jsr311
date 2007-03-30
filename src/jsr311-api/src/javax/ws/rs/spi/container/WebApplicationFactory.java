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
import javax.ws.rs.spi.service.ServiceFinder;

/**
 * A factory for WebApplication instances. Container providers use this class
 * to obtain an instance of the API runtime.
 *
 * @author Paul.Sandoz@Sun.Com
 */
public final class WebApplicationFactory {
    
    private WebApplicationFactory() {
    }
    
    /**
     * Create a Web application instance.
     *
     * @return the web application.
     * @throws ContainerException if there is an error creating the Web application.
     */
    public static WebApplication createWebApplication() throws ContainerException {
        WebApplicationProvider[] wap = ServiceFinder.find(WebApplicationProvider.class).toArray();
        if (wap.length == 0) {
            throw new ContainerException("No WebApplication provider is present in ");
        }
        return wap[0].createWebApplication();        
    }
    
}
