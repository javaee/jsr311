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

import javax.ws.rs.Entity;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.HttpContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.messages.ApiMessages;
import javax.ws.rs.spi.header.HeaderFactory;
import javax.ws.rs.spi.header.HeaderProvider;
import java.net.URI;
import java.util.Date;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Generic base class of all representations.
 * 
 * @author Paul.Sandoz@Sun.Com
 * @author Marc.Hadley@Sun.Com
 */
public class Representation<T> implements Entity<T> {
    /**
     * The content of the representation
     */
    private T content = null;
    
    /**
     * The media type of the representation
     */
    private MediaType mediaType = null;
    
    /**
     * The contentLanguage of the representation
     */
    private String contentLanguage = null;

    /**
     * The contentLocation of the representation
     */
    private URI contentLocation = null;
    
    /**
     * The last modified date of the representation
     */
    private Date lastModified = null;
    
    /**
     * The entity tag of the representation
     */
    private EntityTag eTag = null;
    
    /**
     * Create a new representation with the supplied content. The default media
     * type of "application/octet-stream" is applied.
     * @param content the content of the representation
     */
    public Representation(T content) {
        this(content, "application/octet-stream");
    }
    
    /**
     * Create a new representation with the supplied content and media type.
     * @param content the content of the representation
     * @param mediaType the media type of the content
     * @throws IllegalArgumentException if the supplied mediaType cannot be parsed
     */
    public Representation(T content, String mediaType) throws IllegalArgumentException {
        if (content == null)
            throw new IllegalArgumentException(ApiMessages.CONTENT_CANNOT_BE_NULL());
        this.content = content;
        if (mediaType == null)
            throw new IllegalArgumentException(ApiMessages.MEDIA_TYPE_CANNOT_BE_NULL());
        this.mediaType = new MediaType(mediaType);
    }

    /**
     * Create a new representation with the supplied content and media type.
     * @param content the content of the representation
     * @param mediaType the media type of the content
     */
    public Representation(T content, MediaType mediaType) {
        if (content == null)
            throw new IllegalArgumentException(ApiMessages.CONTENT_CANNOT_BE_NULL());
        this.content = content;
        if (mediaType == null)
            throw new IllegalArgumentException(ApiMessages.MEDIA_TYPE_CANNOT_BE_NULL());
        this.mediaType = mediaType;
    }

    /**
     * Get the content
     * @return the content
     */
    public T getContent() {
        return content;
    }

    /**
     * Set the content
     * @param content the new content
     */
    public void setContent(T content) {
        this.content = content;
    }
    
    /**
     * Get the media type
     * @return the media type
     */
    public MediaType getMediaType() {
        return mediaType;
    }

    /**
     * Set the media type
     * @param mediaType the new media type
     * @throws IllegalArgumentException if the supplied mediaType cannot be parsed
     */
    public void setMediaType(String mediaType) throws IllegalArgumentException {
        this.mediaType = new MediaType(mediaType);
    }
    
    /**
     * Set the media type
     * @param mediaType the new media type
     */
    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
    
    /**
     * 
     * Get the content language
     * 
     * @return the content language
     */
    public String getLanguage() {
        return contentLanguage;
    }    

    /**
     * 
     * Set the content language
     * 
     * @param language the content language
     */
    public void setLanguage(String language) {
        this.contentLanguage = language;
    }

    /**
     * 
     * Get the content location
     * 
     * @return the content location
     */
    public URI getContentLocation() {
        return contentLocation;
    }    

    /**
     * 
     * Set the content location
     * 
     * @param location the content location
     */
    public void setContentLocation(URI location) {
        this.contentLocation = location;
    }
    
    /** 
     * Get the last modified date
     * @return the last modified date
     */
    public Date getLastModified() {
        return lastModified;
    }

    /** 
     * Set the last modified date
     * @param lastModified the last modified date
     */
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    /** 
     * Get the entity tag
     * @return the entity tag
     */
    public EntityTag getETag() {
        return eTag;
    }

    /** 
     * Set the entity tag
     * @param eTag the entity tag
     */
    public void setETag(EntityTag eTag) {
        this.eTag = eTag;
    }
    
    /** 
     * Set the entity tag, eTag will be converted into a strong 
     * {@link javax.ws.rs.core.EntityTag}.
     * @param eTag the value of a strong entity tag
     */
    public void setETag(String eTag) {
        this.eTag = new EntityTag(eTag);
    }

    /**
     * Add entity and response headers associated with the representation to the
     * HttpResponseContext.
     * @param context the current context to which the headers should be written
     */
    public void addResponseHeaders(HttpContext context) {
        final MultivaluedMap<String, Object> responseHeaders = context.getHttpResponseContext().getHttpHeaders();
        if (contentLanguage != null)
            responseHeaders.putSingle("Content-Language", contentLanguage);
        if (contentLocation != null)
            responseHeaders.putSingle("Content-Location", contentLocation.toASCIIString());
        if (lastModified != null)
            responseHeaders.putSingle("Last-Modified", lastModified);
        if (eTag != null)
            responseHeaders.putSingle("ETag", eTag);
        if (mediaType != null)
            responseHeaders.putSingle("Content-Type", mediaType);
    }
}
