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

import java.util.LinkedHashMap;

/**
 * A strongly typed <code>Map<String, String></code> interface used
 * by the {@link FormURLEncodedRepresentation} to store the properties
 * to be encoded.
 *
 * @author Doug Kohlert
 */
public class FormURLEncodedProperties extends LinkedHashMap<String, String> {
    static final long serialVersionUID = 2572713614319991270L;
    
}
