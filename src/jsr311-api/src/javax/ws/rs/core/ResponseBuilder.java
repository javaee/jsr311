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
import javax.ws.rs.spi.ServiceFinder;

/**
 *
 * @author mh124079
 */
public abstract class ResponseBuilder implements ResponseProvider {
    
    static ResponseBuilder impl = null;
    
    protected static synchronized ResponseBuilder newInstance() {
        if (impl != null) {
            return impl;
        }
        for (ResponseBuilder b : ServiceFinder.find(ResponseBuilder.class)) {
            impl = b;
            return b;
        }     
        
        throw new IllegalArgumentException("No ResponseBuilder implementation found");
    }
    
    public static ResponseBuilder ok() {
        ResponseBuilder response = newInstance();
        response.status(200);
        return response;
    }
    
    public static ResponseBuilder ok(Object entity) {
        ResponseBuilder response = ok();
        response.entity(entity);
        return response;
    }
    
    public static ResponseBuilder serverError() {
        ResponseBuilder response = newInstance();
        response.status(500);
        return response;
    }
    
    public static ResponseBuilder created(Object entity, URI location) {
        ResponseBuilder response = created(location);
        response.entity(entity);
        return response;
    }
    
    public static ResponseBuilder created(URI location) {
        ResponseBuilder response = newInstance();
        response.status(201).location(location);
        return response;
    }
    
    public static ResponseBuilder noContent() {
        ResponseBuilder response = newInstance();
        response.status(204);
        return response;
    }
    
    public static ResponseBuilder notModified() {
        ResponseBuilder response = newInstance();
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
        ResponseBuilder response = newInstance();
        response.status(307).location(location);
        return response;
    }
    
    public abstract ResponseBuilder status(int status);
    
    public abstract ResponseBuilder entity(Object entity);
    
    public abstract ResponseBuilder type(MediaType type);

    public abstract ResponseBuilder type(String type);
    
    public abstract ResponseBuilder language(String language);
    
    public abstract ResponseBuilder location(URI location);

    public abstract ResponseBuilder contentLocation(URI location);
    
    public abstract ResponseBuilder tag(EntityTag tag);
    
    public abstract ResponseBuilder tag(String tag);
    
    public abstract ResponseBuilder lastModified(Date lastModified);
    
    public abstract ResponseBuilder cacheControl(CacheControl cacheControl);
    
    public abstract ResponseBuilder header(String name, Object value);
}
