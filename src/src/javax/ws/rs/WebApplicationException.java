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

package javax.ws.rs;

import javax.ws.rs.response.HttpResponse;

/**
 * Runtime exception for applications.
 * <p>
 * This acception may be thrown by a Web application if a specific HTTP error
 * response needs to be produced.
 *
 * @author Paul.Sandoz@Sun.Com
 */
public class WebApplicationException extends RuntimeException {

    private HttpResponse response;

    /**
     * Construct a new instance with a blank message and default HTTP status code of 500
     */
    public WebApplicationException() {
	super();
        response = new HttpResponse(500);
    }

    /**
     * Construct a new instance with a blank message and specified HTTP status code
     * @param response the response that will be returned to the client
     */
    public WebApplicationException(HttpResponse response) {
	super();
        this.response = response;        
    }
    
    /**
     * Construct a new instance with a blank message and specified HTTP status code
     * @param status the HTTP status code that will be returned to the client
     */
    public WebApplicationException(int status) {
	this(new HttpResponse(status));
    }
    
    /**
     * Construct a new instance with a blank message and default HTTP status code of 500
     * @param cause the underlying cause of the exception
     */
    public WebApplicationException(Throwable cause) {
        super(cause);
        response = new HttpResponse(500);
    }
    
    /**
     * Construct a new instance with a blank message and specified HTTP status code
     * @param response the response that will be returned to the client
     * @param cause the underlying cause of the exception
     */
    public WebApplicationException(Throwable cause, HttpResponse response) {
        super(cause);
        this.response = response;
    }
    
    /**
     * Construct a new instance with a blank message and specified HTTP status code
     * @param status the HTTP status code that will be returned to the client
     * @param cause the underlying cause of the exception
     */
    public WebApplicationException(Throwable cause, int status) {
        this(cause, new HttpResponse(status));
    }
    
    /**
     * Get the HTTP response.
     *
     * @return the HTTP response.
     */
    public HttpResponse getHttpResponse() {
        return response;
    }
}
