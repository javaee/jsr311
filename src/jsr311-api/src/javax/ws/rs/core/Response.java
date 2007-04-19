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
 * Created on April 17, 2007, 5:07 PM
 *
 */

package javax.ws.rs.core;

import java.net.URI;
import java.util.Date;
import javax.ws.rs.spi.ServiceFinder;

/**
 *
 * @author mh124079
 */
public abstract class Response implements ResponseProvider {
    
    static Response impl = null;
    
    protected static synchronized Response newInstance() {
        if (impl != null) {
            return impl;
        }
        for (Response b : ServiceFinder.find(Response.class)) {
            impl = b;
            return b;
        }     
        
        throw new IllegalArgumentException("No ResponseBuilder implementation found");
    }
    
    public static Response representation(Object entity) {
        Response response = newInstance();
        response.entity(entity);
        return response;
    }
    
    public static Response representation(Object entity, MediaType type) {
        Response response = representation(entity);
        response.type(type);
        return response;
    }

    public static Response representation(Object entity, String type) {
        Response response = representation(entity);
        response.type(type);
        return response;
    }

    public static Response ok() {
        Response response = newInstance();
        response.status(200);
        return response;
    }
    
    public static Response ok(Object entity) {
        Response response = ok();
        response.entity(entity);
        return response;
    }
    
    public static Response serverError() {
        Response response = newInstance();
        response.status(500);
        return response;
    }
    
    public static Response created(Object entity, URI location) {
        Response response = created(location);
        response.entity(entity);
        return response;
    }
    
    public static Response created(URI location) {
        Response response = newInstance();
        response.status(201).location(location);
        return response;
    }
    
    public static Response noContent() {
        Response response = newInstance();
        response.status(204);
        return response;
    }
    
    public static Response notModified() {
        Response response = newInstance();
        response.status(304);
        return response;
    }
    
    public static Response notModified(EntityTag tag) {
        Response response = notModified();
        response.tag(tag);
        return response;
    }
    
    public static Response notModified(String tag) {
        Response response = notModified();
        response.tag(tag);
        return response;
    }
    
    public static Response TemporaryRedirect(URI location) {
        Response response = newInstance();
        response.status(307).location(location);
        return response;
    }
    
    public abstract Response status(int status);
    
    public abstract Response entity(Object entity);
    
    public abstract Response type(MediaType type);

    public abstract Response type(String type);
    
    public abstract Response language(String language);
    
    public abstract Response location(URI location);

    public abstract Response contentLocation(URI location);
    
    public abstract Response tag(EntityTag tag);
    
    public abstract Response tag(String tag);
    
    public abstract Response lastModified(Date lastModified);
    
    public abstract Response cacheControl(CacheControl cacheControl);
    
    public abstract Response header(String name, Object value);
}
