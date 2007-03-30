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
 * Cookie.java
 *
 * Created on March 12, 2007, 5:01 PM
 *
 */

package javax.ws.rs.core;

/**
 * Represents a HTTP cookie.
 * @see <a href="http://www.ietf.org/rfc/rfc2109.txt">IETF RFC 2109</a>
 */
public interface Cookie {
    
    /**
     * Get the name of the cookie
     * @return the name
     */
    public String getName();

    /**
     * Get the value of the cookie
     * @return the value
     */
    public String getValue();
    
    /**
     * Get the version of the cookie
     * @return the version
     */
    public int getVersion();

    /**
     * Get the domain of the cookie
     * @return the domain
     */
    public String getDomain();

    /**
     * Get the path of the cookie
     * @return the path
     */
    public String getPath();

}
