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

/**
 * Listener for Web resource resolver events.
 *
 * @author Paul.Sandoz@Sun.Com
 */
public interface WebResourceResolverListener {
    /**
     * Called when a the {@link WebResourceResolver#resolve} method
     * results in the instantiation of a new Web resource instance.
     * 
     * @param resource the resolved web resource instance that has been newly
     * instantiated.
     * @throws ContainerException if there is an error produced by the listener.
     */
    void onInstantiation(Object resource) throws ContainerException;
}
