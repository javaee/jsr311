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

package javax.ws.rs.representation;

import javax.ws.rs.representation.Representation;

/**
 * Representation as a <code>java.util.Map&lt;String,String&gt;</code> for www-form-urlencoded resources.
 *
 * @author Doug Kohlert
 * @see java.util.Map
 */
public class FormURLEncodedRepresentation extends Representation<FormURLEncodedProperties> {   
    /**
     * Creates a new instance of FormURLEncodedRepresentation
     *
     * @param content the properties to encode.
     */
    public FormURLEncodedRepresentation(FormURLEncodedProperties content) {
        super(content, "application/x-www-form-urlencoded");
    }
   
    
}
