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
 * ProviderFactory.java
 *
 * Created on May 16, 2007, 12:01 PM
 *
 */

package javax.ws.rs.ext;

import java.util.Iterator;
import java.util.List;
import sun.misc.Service;

/**
 * Factory for creating instances of provider classes.
 */
public abstract class ProviderFactory {
    
    /** 
     * Creates a new instance of ProviderFactory. The implementation of
     * ProviderFactory that will be instantiated is determined using the 
     * Services API (as detailed in the JAR specification) to determine
     * the classname. The Services API will look for a classname in the file
     * META-INF/services/javax.ws.rs.ext.ProviderFactory in jars available
     * to the runtime.
     */
    public static ProviderFactory newInstance() {
       Iterator ps = Service.providers(ProviderFactory.class); 
       while (ps.hasNext()) { 
           ProviderFactory pf = (ProviderFactory)ps.next();
           return pf;
       } 
       return null;
    }
    
    /**
     * Create a new instance of the specified class.
     * @return a new provider instance
     */
    public abstract <T> T createInstance();

    /**
     * Create a new instance of a HeaderProvider for the specified class.
     * @return a new provider instance
     */
    public abstract <T> HeaderProvider<T> createHeaderProvider();

    /**
     * Create a new instance of an EntityProvider for the specified class.
     * @return a new provider instance
     */
    public abstract <T> EntityProvider<T> createEntityProvider();
}
