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

package javax.ws.rs.spi.resolver;

/**
 * A factory for WebResourceRsolver instances
 * @author Paul.Sandoz@Sun.Com
 */
public interface WebResourceResolverFactory {
    /**
     * Create the resolver for the Web resource.
     * <p>
     * The resolver will be used by the Web application to resolve the 
     * Class of the Web resource to an instance of that Class.
     *
     * @param resourceClass the Web resource class.
     * @return the Web resource resolver, or null if 
     * no resolving strategy for the Web resource is supported.
     */
    WebResourceResolver createWebResourceResolver(Class<?> resourceClass);
}
