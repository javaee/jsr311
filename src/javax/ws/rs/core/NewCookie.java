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
 * NewCookie.java
 *
 * Created on March 12, 2007, 5:08 PM
 *
 */

package javax.ws.rs.core;

import java.net.URI;
import java.util.regex.Matcher;

/**
 * Represents a new cookie that will be sent in a response.
 * @see <a href="http://www.ietf.org/rfc/rfc2109.txt">IETF RFC 2109</a>
 */
public class NewCookie implements Cookie {
    
    private String comment = null;
    private int maxAge = -1;
    private boolean secure = false;
    private String name;
    private String value;
    private int version = 1;
    private String path = null;
    private String domain = null;
    
    /**
     * Make a new instance using the supplied name and value.
     * @param name the cookie name
     * @param value the cookie value
     */
    public NewCookie(String name, String value) {
        this.name = name;
        this.value = value;
    }
    
    /**
     * Make a new instance copying the information in the supplied cookie.
     * @param cookie the cookie clone
     */
    public NewCookie(Cookie cookie) {
        this.name = cookie.getName();
        this.value = cookie.getValue();
        this.version = cookie.getVersion();
        this.domain = cookie.getDomain();
        this.path = cookie.getPath();
    }

    /**
     * Get the comment associated with the cookie.
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Set the comment associated with the cookie.
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Get the maximum age of the the cookie in seconds. Cookies older than
     * the maximum age are discarded. A value of -1 indicates that the cookie
     * will be discarded at the end of the browser/application session.
     * @return the maximum age in seconds
     */
    public int getMaxAge() {
        return maxAge;
    }

    /**
     * Set the maximum age of the the cookie in seconds. Cookies older than
     * the maximum age are discarded. A cookie can be unset by sending a new
     * cookie with maximum age of 0 since it will overwrite any existing cookie
     * and then be immediately discarded. A value of -1 indicates that the cookie
     * will be discarded at the end of the browser/application session.
     * @param maxAge the maximum age in seconds
     */
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    /**
     * Whether the cookie will only be sent over a secure connection. Defaults
     * to false.
     * @return true if the cookie will only be sent over a secure connection,
     * false otherwise.
     */
    public boolean isSecure() {
        return secure;
    }

    /**
     * Set whether the cookie will only be sent over a secure connection.
     * Defaults to false.
     * @param secure true if the cookie will only be sent over a secure connection,
     * false otherwise.
     */
    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    /**
     * @inheritDoc 
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the cookie.
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @inheritDoc 
     */
    public String getValue() {
        return value;
    }

    /**
     * Set the value of the cookie.
     * @param value the value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @inheritDoc 
     */
    public int getVersion() {
        return version;
    }

    /**
     * Set the version of the cookie.
     * @param version the version. If not set, the default is version 1
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * @inheritDoc 
     */
    public String getPath() {
        return path;
    }

    /**
     * Set the path of the cookie.
     * @param path the path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @inheritDoc 
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Set the domain of the cookie.
     * @param domain the domain
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }
    
}
