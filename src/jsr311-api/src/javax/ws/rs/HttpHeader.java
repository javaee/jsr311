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
 * HttpHeader.java
 *
 * Created on January 24, 2007, 2:33 PM
 *
 */

package javax.ws.rs;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Binds a HTTP header to a Java method parameter, class field or bean
 * property.
 * <p>For injected values, the class of the annotated parameter, field or bean must
 * have a constructor
 * that accepts a single String or List<String> argument, or a static method 
 * named <code>valueOf</code> that accepts a single String argument
 * (see, for example, {@link Integer#valueOf(String)})</p>.
 * <p>When extracting values they will be serialized using one of the following
 * mechanisms in the order
 * listed:</p>
 * <ul>
 * <li>Using an available <code>HeaderProvider</code> for the value's class</li> 
 * <li>Using the objects's <code>toString</code> method</li> 
 * </ul>
 * @see DefaultValue
 * @see javax.ws.rs.spi.header.HeaderProvider
 */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HttpHeader {
    /**
     * Defines the name of the HTTP header whose value will be used
     * to initialize the value of the annotated method argument, class field or
     * bean property. Case insensitive.
     */
    String value();
}
