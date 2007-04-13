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
 * HttpMethod.java
 *
 * Created on October 25, 2006, 2:02 PM
 *
 */

package javax.ws.rs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the annotated Java method should be used to handle HTTP
 * requests. Annotated methods must satisfy the following constraints:
 * <ul>
 * <li>Methods must have a return type of <code>void</code>,
 * <code>Representation&lt;T&gt;</code>, <code>T</code> or
 * <code>HttpResponse</code>. Return values will be serialized
 * in the HTTP response entity body.
 * <li>Methods may have a single optional parameter of type
 * <code>Entity&lt;T&gt;</code></li>. The parameter provides access to
 * the contents of the HTTP request entity body. The parameter will be null if
 * the HTTP request entity body is of zero length.
 * <li>Methods may have zero or more additional method arguments, each of which
 * must be annotated with either <code>@UriParam</code>, 
 * <code>@HeaderParam</code>, 
 * <code>@MatrixParam</code> or <code>@QueryParam</code></li>
 * </ul>
 *
 * @see javax.ws.rs.representation.Representation
 * @see UriParam
 * @see QueryParam
 * @see MatrixParam
 * @see HttpHeader
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface HttpMethod {
    
    /**
     * HTTP GET method
     */
    public static final String GET="GET";
    /**
     * HTTP POST method
     */
    public static final String POST="POST"; 
    /**
     * HTTP PUT method
     */
    public static final String PUT="PUT";
    /**
     * HTTP DELETE method
     */
    public static final String DELETE="DELETE";
    /**
     * HTTP HEAD method
     */
    public static final String HEAD="HEAD";
    
    /**
     * Specifies the name of a HTTP method. E.g. "GET". If not specified the
     * name of the annotated method must begin with one of the method constants
     * (in lowercase). E.g. <pre>
     * &#064;HttpMethod
     * public void deleteSomething()</pre>
     * is equivalent to <pre>
     * &#064;HttpMethod(DELETE)
     * public void deleteSomething()</pre>
     */
    String value() default "";        
}
