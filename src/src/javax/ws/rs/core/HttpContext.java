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

/*
 * HttpContext.java
 *
 * Created on November 16, 2006, 3:37 PM
 *
 */

package javax.ws.rs.core;

import javax.ws.rs.container.ContainerException;
import javax.ws.rs.response.HttpResponse;

/**
 * A HttpContext makes it possible for a web resource implementation class to 
 * access and manipulate HTTP request and response information directly. Typically
 * a HttpContext is injected into web resource implementation class using the 
 * Resource annotation.
 */
public interface HttpContext {
    /**
     * Get the HTTP request information.
     * @return the HTTP request information
     */
    HttpRequestContext getHttpRequestContext();

    /**
     * Get the HTTP response information.
     * @return the HTTP response information
     */
    HttpResponseContext getHttpResponseContext();
    
    /**
     * Create a response that will forward the HTTP request to another component
     * within the same container for further processing.
     * @param path the path that identifies the component. The path may be relative or absolute,
     * relative paths are relative to the request URI.
     * @return a response object that, when returned, will cause the container to forward
     * the request to another component.
     * @throws ContainerException if the path cannot be reached by a local forward
     * @throws UnsupportedOperationException if the current container does not support local forwards
     */
    HttpResponse createLocalForward(String path) throws ContainerException, UnsupportedOperationException;
    
}
