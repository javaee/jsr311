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
 * ResponseBuilder.java
 *
 * Created on April 17, 2007, 5:07 PM
 *
 */

package javax.ws.rs.core;

import java.net.URI;
import java.util.Date;

/**
 *
 * @author mh124079
 */
public class ResponseBuilder implements Response {
    
    Object entity;
    MultivaluedMap<String, Object> metadata;
    int status;
    
    public int getStatus() {
        return status;
    }
    
    public Object getEntity() {
        return entity;
    }
    
    public MultivaluedMap<String, Object> getMetadata() {
        return metadata;
    }
    
    /**
     * Creates a new instance of ResponseBuilder
     */
    protected ResponseBuilder() {
        entity = null;
        status = -1;
        metadata = new MultivaluedMap<String, Object>();
    }
    
    public static ResponseBuilder ok() {
        ResponseBuilder response = new ResponseBuilder();
        response.status(200);
        return response;
    }
    
    public static ResponseBuilder ok(Object entity) {
        ResponseBuilder response = ok();
        response.entity(entity);
        return response;
    }
    
    public static ResponseBuilder serverError() {
        ResponseBuilder response = new ResponseBuilder();
        response.status(500);
        return response;
    }
    
    public static ResponseBuilder created(Object entity, URI location) {
        ResponseBuilder response = created(location);
        response.entity(entity);
        return response;
    }
    
    public static ResponseBuilder created(URI location) {
        ResponseBuilder response = new ResponseBuilder();
        response.status(201).location(location);
        return response;
    }
    
    public static ResponseBuilder noContent() {
        ResponseBuilder response = new ResponseBuilder();
        response.status(204);
        return response;
    }
    
    public static ResponseBuilder notModified() {
        ResponseBuilder response = new ResponseBuilder();
        response.status(304);
        return response;
    }
    
    public static ResponseBuilder notModified(EntityTag tag) {
        ResponseBuilder response = notModified();
        response.tag(tag);
        return response;
    }
    
    public static ResponseBuilder notModified(String tag) {
        ResponseBuilder response = notModified();
        response.tag(tag);
        return response;
    }
    
    public static ResponseBuilder TemporaryRedirect(URI location) {
        ResponseBuilder response = new ResponseBuilder();
        response.status(307).location(location);
        return response;
    }
    
    public ResponseBuilder status(int status) {
        this.status = status;
        return this;
    }
    
    public ResponseBuilder entity(Object entity) {
        this.entity = entity;
        return this;
    }
    
    public ResponseBuilder type(MediaType type) {
        metadata.add("Content-Type", type);
        return this;
    }

    public ResponseBuilder type(String type) {
        metadata.add("Content-Type", type);
        return this;
    }
    
    public ResponseBuilder language(String language) {
        metadata.add("Language", language);
        return this;
    }
    
    public ResponseBuilder location(URI location) {
        metadata.add("Location", location);
        return this;
    }

    public ResponseBuilder contentLocation(URI location) {
        metadata.add("Content-Location", location);
        return this;
    }
    
    public ResponseBuilder tag(EntityTag tag) {
        metadata.add("ETag", tag);
        return this;
    }
    
    public ResponseBuilder tag(String tag) {
        metadata.add("ETag", tag);
        return this;
    }
    
    public ResponseBuilder lastModified(Date lastModified) {
        metadata.add("Last-Modified", lastModified);
        return this;
    }
    
    public ResponseBuilder cacheControl(CacheControl cacheControl) {
        metadata.add("Cache-Control", cacheControl);
        return this;
    }
    
    public ResponseBuilder header(String name, Object value) {
        metadata.add(name, value);
        return this;
    }
}
