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

import java.util.Map;

/**
 * The HTTP request context supplied by the container.
 * <p>
 * This interface is a place for holder for any container specific HTTP request 
 * functionality that may be required in the future.
 *
 * @author Paul.Sandoz@Sun.Com
 */
public interface ContainerRequest extends javax.ws.rs.core.HttpRequestContext {
}
