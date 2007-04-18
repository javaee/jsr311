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

package javax.ws.rs.spi;

/**
 * Factory for getting {@link TypeStreamingProvider} instances.
 *
 * @author Paul.Sandoz@Sun.Com
 * @author Marc.Hadley@Sun.Com
 */
public final class TypeStreamingFactory {
    
    /**
     * Get a {@link TypeStreamingProvider} that supports the type (or {@link Class})
     * requested.
     * <p>
     * The list of service-provider supporting the {@link TypeStreamingProvider} 
     * service-provider will be iterated over until the first one supports the type 
     * is found.
     * <p>
     * @param type the supporting type.
     * @return the instance of {@link TypeStreamingProvider} supporting the type.
     * @throws IllegalArgumentException if a {@link TypeStreamingProvider} instance 
     *         cannot be obtained for the type.
     */
    @SuppressWarnings("unchecked")
    public static <T> TypeStreamingProvider<T> getTypeStreamingProvider(Class<T> type) throws IllegalArgumentException {        
        // This is obviously slow
        // Caching the providers using a Map with key of type and value of provider
        // for previously created resources will be faster
        for (TypeStreamingProvider<T> tsp : ServiceFinder.find(TypeStreamingProvider.class)) {
            if (tsp.supports(type))
                return tsp;
        }     
        
        throw new IllegalArgumentException("A type streaming provider for type, " + type + ", is not supported");
    }
}