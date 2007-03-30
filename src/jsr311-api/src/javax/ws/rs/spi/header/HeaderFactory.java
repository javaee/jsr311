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

package javax.ws.rs.spi.header;

import javax.ws.rs.spi.service.ServiceFinder;

/**
 * Factory for getting {@link HeaderProvider} instances.
 *
 * @author Paul.Sandoz@Sun.Com
 * @author Marc.Hadley@Sun.Com
 */
public final class HeaderFactory {
    
    /**
     * Get a {@link HeaderProvider} that supports the type (or {@link Class})
     * requested.
     * <p>
     * The list of service-provider supporting the {@link HeaderProvider} 
     * service-provider will be iterated over until the first one supports the type 
     * is found.
     * <p>
     * @return the instance of {@link HeaderProvider} supporting the type.
     * @param type the supporting type.
     * @throws IllegalArgumentException if a header provider cannot be found for the supplied type
     */
    @SuppressWarnings("unchecked")
    public static <T> HeaderProvider<T> getHeaderProvider(Class<T> type) throws IllegalArgumentException {        
        // This is obviously slow
        // Caching the providers using a Map with key of type and value of provider
        // for previously created resources will be faster
        for (HeaderProvider<T> tsp : ServiceFinder.find(HeaderProvider.class)) {
            if (tsp.supports(type))
                return tsp;
        }     
        
        throw new IllegalArgumentException("A header provider for type, " + type + ", is not supported");
    }
}