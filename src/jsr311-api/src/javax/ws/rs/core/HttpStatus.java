/*
 * HttpStatus.java
 *
 * Created on April 13, 2007, 4:18 PM
 *
 */

package javax.ws.rs.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to annotate a field or bean property that provides the HTTP status code
 * @author mh124079
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HttpStatus {
}
