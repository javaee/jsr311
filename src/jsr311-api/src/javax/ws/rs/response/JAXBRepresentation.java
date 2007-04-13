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

package javax.ws.rs.response;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.response.Representation;
import javax.xml.bind.JAXBContext;

/**
 * Representation as a {@link Object} for JAXB element-based resources.
 * 
 * @author Doug Kohlert 
 */
public class JAXBRepresentation<T> extends Representation<T> {   
    JAXBContext context;

    /**
     * Creates a new instance of JAXBRepresentation
     *
     * @param content the data contained in this <code>Representation</code>.
     * @param context the <code>JAXBContext</code> to be used when marshalling/
     * unmarshalling this <code>Representation</code>.
     */
    public JAXBRepresentation(T content, JAXBContext context) {
        this(content, context, "application/xml");
    }
    
    /**
     * Creates a new instance of JAXBRepresentation

     * @param content the data contained in this <code>Representation</code>.
     * @param context the <code>JAXBContext</code> to be used when marshalling/
     * unmarshalling this <code>Representation</code>.
     * @param mediaType the media type of the <code>Representation</code>.
     * @throws IllegalArgumentException if the supplied mediaType cannot be parsed
     */
    public JAXBRepresentation(T content, JAXBContext context, String mediaType) throws IllegalArgumentException{
        this(content, context, new MediaType(mediaType));
    }

    /**
     * Creates a new instance of JAXBRepresentation

     * @param content the data contained in this <code>Representation</code>.
     * @param context the <code>JAXBContext</code> to be used when marshalling/
     * unmarshalling this <code>Representation</code>.
     * @param mediaType the media type of the <code>Representation</code>.
     */
    public JAXBRepresentation(T content, JAXBContext context, MediaType mediaType) {
        super(content, mediaType);
        this.context = context; 
    }

}
