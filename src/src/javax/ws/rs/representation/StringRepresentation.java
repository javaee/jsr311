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

import javax.ws.rs.core.MediaType;
import javax.ws.rs.representation.Representation;

/**
 * Representation as a {@link String} for text-based resources.
 * 
 */
public class StringRepresentation extends Representation<String> {    
    /**
     * Creates a new instance of StringRepresentation with a default media type of text/plain
     * @param text the string content of the representation
     */
    public StringRepresentation(String text) {
        this(text, "text/plain");
    }

    /**
     * Creates a new instance of StringRepresentation with the specified media type
     * @param text the string content of the representation
     * @param mediaType the media type of the representation
     * @throws IllegalArgumentException if the supplied mediaType cannot be parsed
     */
    public StringRepresentation(String text, String mediaType) throws IllegalArgumentException {
        this(text, new MediaType(mediaType));
    }
    
    /**
     * Creates a new instance of StringRepresentation with the specified media type
     * @param text the string content of the representation
     * @param mediaType the media type of the representation
     */
    public StringRepresentation(String text, MediaType mediaType) {
        super(text, mediaType);
    }
}
