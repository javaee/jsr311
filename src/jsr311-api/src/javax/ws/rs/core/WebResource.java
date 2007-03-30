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
 * WebResource.java
 *
 * Created on October 25, 2006, 2:17 PM
 *
 */

package javax.ws.rs.core;

/**
 * Low level interface for implementing web resource classes. Implmenting
 * classes must be annotated with <code>@UriTemplate</code> and may use
 * <code>@ConsumeMime</code> and <code>@ProduceMime</code> to filter the
 * requests they will receive.
 *
 * The container must honour annotations from the javax.annotation package. In
 * particular, resource class instance lifecycle can be managed using the
 * javax.annotation.PostConstruct and java.annotation.PreDestroy annotations
 * and a class can obtain access to container context information using 
 * javax.annotation.Resource as specified in JSR 250.
 *
 * @see javax.ws.rs.UriTemplate
 * @see javax.ws.rs.ConsumeMime
 * @see javax.ws.rs.ProduceMime
 */
public interface WebResource {
    
  /**
   * Called for each HTTP request
   * @param request the HTTP request information
   * @param response the HTTP response information
   */
  void handleRequest(HttpRequestContext request, HttpResponseContext response);
  
}
