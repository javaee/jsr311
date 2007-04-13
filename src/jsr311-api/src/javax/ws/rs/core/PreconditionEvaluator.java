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
 * PreconditionEvaluator.java
 *
 * Created on October 23, 2006, 2:08 PM
 *
 */

package javax.ws.rs.core;

import java.sql.Date;
import javax.ws.rs.response.HttpResponse;

/**
 * An injectable evaluator for preconditions.
 * @see HttpContext
 */
public interface PreconditionEvaluator {
    
    /**
     * Evaluate request preconditions based on the passed in value.
     * @param eTag an ETag for the current state of the resource
     * @return null if the preconditions are met, a Response that should be returned if the
     * preconditions are not met.
     */
    HttpResponse evaluate(String eTag);

    /**
     * Evaluate request preconditions based on the passed in value.
     * @param lastModified a date that specifies the modification date of the resource
     * @return null if the preconditions are met, a Response that should be returned if the
     * preconditions are not met.
     */
    HttpResponse evaluate(Date lastModified);
    
    /**
     * Evaluate request preconditions based on the passed in value.
     * @param lastModified a date that specifies the modification date of the resource
     * @param eTag an ETag for the current state of the resource
     * @return null if the preconditions are met, a Response that should be returned if the
     * preconditions are not met.
     */
    HttpResponse evaluate(Date lastModified, String eTag);
}
