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
 * DefaultValue.java
 *
 * Created on November 16, 2006, 2:04 PM
 *
 */

package javax.ws.rs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines the default value of a method parameter that
 * is bound from a URI query or matrix parameter or a HTTP header 
 * using the {@link javax.ws.rs.QueryParam}, {@link javax.ws.rs.MatrixParam},
 * {@link javax.ws.rs.CookieParam}
 * or {@link javax.ws.rs.HeaderParam} annotations respectively. The 
 * default value is used if the query
 * or matrix parameter is not present in the request URI or if the
 * cookie or HTTP header is not 
 * present in the request. If the type of the annotated parameter is 
 * <code>List</code>, <code>Set</code> or <code>SortedSet</code> then the
 * resulting collection will have a single entry mapped from the supplied 
 * default value.
 * 
 * <p>If this annotation is not used
 * and the query or matrix parameter is not present in the request URI or the 
 * cookie or HTTP header is not supplied, the value will
 * be an empty collection for <code>List</code>, <code>Set</code> or 
 * <code>SortedSet</code>, null for other class types, and the Java-defined 
 * default for primitive types.</p>
 * 
 * @see QueryParam
 * @see HeaderParam
 * @see MatrixParam
 * @see CookieParam
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultValue {
    /**
     * The default value.
     */
    String value();
}
