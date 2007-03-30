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
 * Entity.java
 *
 * Created on October 23, 2006, 1:54 PM
 *
 */

package javax.ws.rs;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.GregorianCalendar;

/**
 * An abstraction for the immutable entity of a HTTP request.
 */
public interface Entity<T> {
    /**
     * Get the media type of the entity
     * @return the media type
     */
    public MediaType getMediaType();
    
    /**
     * Get the language of the entity
     * @return the language of the entity
     */
    public String getLanguage();
    
    /**
     * Get the content of the representation.
     * @return the representation as type T
     */
    public T getContent();

}
