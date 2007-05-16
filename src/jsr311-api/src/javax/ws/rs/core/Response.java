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
 * Response.java
 *
 * Created on April 18, 2007, 9:00 AM
 *
 */

package javax.ws.rs.core;

import java.net.URI;
import java.util.Date;
import javax.ws.rs.ext.Contract;
import javax.ws.rs.ext.ProviderFactory;

/**
 * Defines the contract between a returned instance and the runtime when
 * an application needs to provide metadata to the runtime. An application
 * class can implement this interface directly or can use the nested Builder
 * class to create an instance.
 * 
 * @see Response.Builder
 */
public interface Response {
    
    /**
     * Return the entity for the response. The response will be serialized using an
     * EntityProvider for the class of the entity.
     * @return an object instance or null if there is no entity
     * @see javax.ws.rs.ext.EntityProvider
     */
    Object getEntity();
    
    /**
     * Get the status code associated with the response.
     * @return the response status code or -1 if the status was not set
     */
    int getStatus();

    /**
     * Write any metadata associated with the response to the supplied map. Values
     * will be serialized using a HeaderProvider for the class of the value. Multivalued
     * entries will be serialized as separate headers.
     * @param metadata a map to write the metadata to
     * @see javax.ws.rs.ext.HeaderProvider
     */
    void addMetadata(MultivaluedMap<String, Object> metadata);
    
    /**
     * A class used to build Response instances that contain metadata instead of or in addition
     * to an entity. Static methods are provided to obtain an initial instance,
     * instance methods provide the ability to set metadata. E.g. to create a response
     * that indicates the creation of a new resource:
     * <pre>@HttpMethod
     * Response addWidget(...) {
     *   Widget w = ...
     *   URI widgetId = ...
     *   return Builder.created(w, widgetId).build();
     * }</pre>
     */
    @Contract
    public static abstract class Builder {
        
        /**
         * Create a new builder instance.
         * @return a new Builder
         */
        protected static synchronized Builder newInstance() {
            Builder b = ProviderFactory.newInstance().createInstance();
            if (b==null)
                throw new UnsupportedOperationException("No Builder implementation found");
            return b;
        }
        
        /**
         * Create a Response instance from the current Builder.
         * @return a Response instance
         */
        public abstract Response build();
        
        /**
         * Create a new Builder that contains a representation.
         * @param entity the representation entity data
         * @return a new Builder
         */
        public static Builder representation(Object entity) {
            Builder b = newInstance();
            b.entity(entity);
            return b;
        }
        
        /**
         * Create a new Builder that contains a representation.
         * @param entity the representation entity data
         * @param type the media type of the entity
         * @return a new Builder
         */
        public static Builder representation(Object entity, MediaType type) {
            Builder b = representation(entity);
            b.type(type);
            return b;
        }
        
        /**
         * Create a new Builder that contains a representation.
         * @param entity the representation entity data
         * @param type the media type of the entity
         * @return a new Builder
         */
        public static Builder representation(Object entity, String type) {
            Builder b = representation(entity);
            b.type(type);
            return b;
        }
        
        /**
         * Create a new Builder with an OK status.
         * @return a new Builder
         */
        public static Builder ok() {
            Builder b = newInstance();
            b.status(200);
            return b;
        }
        
        /**
         * Create a new Builder with an OK status.
         * @param entity the representation entity data
         * @return a new Builder
         */
        public static Builder ok(Object entity) {
            Builder b = ok();
            b.entity(entity);
            return b;
        }
        
        /**
         * Create a new Builder with an server error status.
         * @return a new Builder
         */
        public static Builder serverError() {
            Builder b = newInstance();
            b.status(500);
            return b;
        }
        
        /**
         * Create a new Builder for a created resource.
         * @param entity the representation of the new resource
         * @param location the URI of the new resource
         * @return a new Builder
         */
        public static Builder created(Object entity, URI location) {
            Builder b = created(location);
            b.entity(entity);
            return b;
        }
        
        /**
         * Create a new Builder for a created resource.
         * @param location the URI of the new resource
         * @return a new Builder
         */
        public static Builder created(URI location) {
            Builder b = newInstance();
            b.status(201).location(location);
            return b;
        }
        
        /**
         * Create a new Builder for an empty response.
         * @return a new Builder
         */
        public static Builder noContent() {
            Builder b = newInstance();
            b.status(204);
            return b;
        }
        
        /**
         * Create a new Builder with a not-modified status.
         * @return a new Builder
         */
        public static Builder notModified() {
            Builder b = newInstance();
            b.status(304);
            return b;
        }
        
        /**
         * Create a new Builder with a not-modified status.
         * @param tag a tag for the unmodified entity
         * @return a new Builder
         */
        public static Builder notModified(EntityTag tag) {
            Builder b = notModified();
            b.tag(tag);
            return b;
        }
        
        /**
         * Create a new Builder with a not-modified status.
         * @param tag a tag for the unmodified entity
         * @return a new Builder
         */
        public static Builder notModified(String tag) {
            Builder b = notModified();
            b.tag(tag);
            return b;
        }
        
        /**
         * Create a new Builder for a temporary redirection.
         * @param location the redirection URI
         * @return a new Builder
         */
        public static Builder temporaryRedirect(URI location) {
            Builder b = newInstance();
            b.status(307).location(location);
            return b;
        }
        
        /**
         * Set the status on the Builder.
         * @param status the response status
         * @return the updated Builder
         */
        public abstract Builder status(int status);
        
        /**
         * Set the entity on the Builder.
         * 
         * @return the updated Builder
         * @param entity the response entity
         */
        public abstract Builder entity(Object entity);
        
        /**
         * Set the type on the Builder.
         * 
         * @return the updated Builder
         * @param type the media type of the response entity
         */
        public abstract Builder type(MediaType type);
        
        /**
         * Set the type on the Builder.
         * 
         * @return the updated Builder
         * @param type  the media type of the response entity
         */
        public abstract Builder type(String type);
        
        /**
         * Set the language on the Builder.
         * 
         * @return the updated Builder
         * @param language the language of the response entity
         */
        public abstract Builder language(String language);
        
        /**
         * Set the location on the Builder.
         * 
         * @return the updated Builder
         * @param location the location
         */
        public abstract Builder location(URI location);
        
        /**
         * Set the content location on the Builder.
         * 
         * @return the updated Builder
         * @param location the content location
         */
        public abstract Builder contentLocation(URI location);
        
        /**
         * Set the entity tag on the Builder.
         * 
         * @return the updated Builder
         * @param tag the entity tag
         */
        public abstract Builder tag(EntityTag tag);
        
        /**
         * Set the entity tag on the Builder.
         * 
         * @return the updated Builder
         * @param tag the entity tag
         */
        public abstract Builder tag(String tag);
        
        /**
         * Set the last modified date on the Builder.
         * 
         * @return the updated Builder
         * @param lastModified the last modified date
         */
        public abstract Builder lastModified(Date lastModified);
        
        /**
         * Set the cache control data on the Builder.
         * 
         * @return the updated Builder
         * @param cacheControl the cache control directives
         */
        public abstract Builder cacheControl(CacheControl cacheControl);
        
        /**
         * Set the value of a specific header on the Builder.
         * @param name the name of the header
         * @param value the value of the header, the header will be serialized
         * using a HeaderProvider for the class of the value
         * @see javax.ws.rs.ext.HeaderProvider
         * @return the updated Builder
         */
        public abstract Builder header(String name, Object value);
        
        /**
         * Set a new cookie on the Builder.
         * 
         * @return the updated Builder
         * @param cookie the new cookie that will accompany the response.
         */
        public abstract Builder cookie(NewCookie cookie);
    }
}
