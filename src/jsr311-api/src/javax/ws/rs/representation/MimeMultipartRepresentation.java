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
import java.util.HashMap;
import javax.mail.internet.MimeMultipart;

/**
 * Representation as a <code>Map&lt;String, DataSource&gt;</code> for MimeMultipart resources.
 * 
 * @author Doug Kohlert
 * @see java.util.Map
 */
public class MimeMultipartRepresentation extends Representation<MimeMultipart> {   

    /**
     * Creates a new instance of MimeMultipartRepresentation with the supplied media type string.

     * @param content the data contained in this <code>Representation</code>.
     * @param mediaType the media type of the <code>Representation</code>, e.g. Multipart/Related;type="application/xml".
     * @throws IllegalArgumentException if the supplied mediaType cannot be parsed
     */
    public MimeMultipartRepresentation(MimeMultipart content, String mediaType) throws IllegalArgumentException {
        this(content, new MediaType(mediaType));
    }
    
    /**
     * Creates a new instance of MimeMultipartRepresentation with the supplied media type string.

     * @param content the data contained in this <code>Representation</code>.
     * @param mediaType the media type of the <code>Representation</code>, e.g. Multipart/Related;type="application/xml".
     */
    public MimeMultipartRepresentation(MimeMultipart content, MediaType mediaType) {
        super(content, mediaType);
    }
    
    /**
     * Creates a new instance of MimeMultipartRepresentation with the supplied 
     * mulipart subtype and root body part type. E.g. Multipart/<code>subType</code>};type="<code>rootType</code>".
     *
     * @param content the data contained in this <code>Representation</code>.
     * @param subType the subtype of the <code>Representation</code>, e.g "related" or "mixed".
     * @param rootType the media type of the root body part, e.g. "application/xml"
     */
    public MimeMultipartRepresentation(MimeMultipart content, String subType, String rootType) {
        super(content);
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("type", rootType);
        this.setMediaType(new MediaType("multipart",subType,params));
    }
    
}
