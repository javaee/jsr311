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

/**
 * Runtime exception to be caught by the container.
 * <p>
 * This exception may be thrown by the application signaling that the 
 * container should handle the exception to produce an appropriate HTTP response.
 * <p>
 * This exception may also be thrown by the runtime if an exception  
 * occurs that should be handled by the container.
 *
 * @author Paul.Sandoz@Sun.Com
 */
public class ContainerException extends RuntimeException {

    /**
     * Construct a new instance with the supplied message
     */
    public ContainerException() {
        super();
    }

    /**
     * Construct a new instance with the supplied message
     * @param message the message
     */
    public ContainerException(String message) {
        super(message);
    }

    /**
     * Construct a new instance with the supplied message and cause
     * @param message the message
     * @param cause the Throwable that caused the exception to be thrown
     */
    public ContainerException(String message, Throwable cause) {
        super(message, cause);
    }
        
    /**
     * Construct a new instance with the supplied cause
     * @param cause the Throwable that caused the exception to be thrown
     */
    public ContainerException(Throwable cause) {
        super(cause);
    }
}
