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

package javax.ws.rs.spi;

/**
 * Error thrown when something goes wrong while looking up service providers.
 * In particular, this error will be thrown in the following situations:
 *
 *   <ul>
 *   <li> A concrete provider class cannot be found,
 *   <li> A concrete provider class cannot be instantiated,
 *   <li> The format of a provider-configuration file is illegal, or
 *   <li> An IOException occurs while reading a provider-configuration file.
 *   </ul>
 *
 * @author Mark Reinhold
 * @version 1.7, 03/12/19
 * @since 1.3
 */
public class ServiceConfigurationError extends Error {

    /**
     * Constructs a new instance with the specified detail string.
     * @param msg the detail string
     */
    public ServiceConfigurationError(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance that wraps the specified throwable.
     * @param x the throwable to be wrapped
     */
    public ServiceConfigurationError(Throwable x) {
        super(x);
    }

}
