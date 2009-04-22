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

package javax.ws.rs.core;

import javax.ws.rs.ext.RuntimeDelegate;
import junit.framework.TestCase;

public class CookieTest extends TestCase {
    
    public CookieTest(String testName) {
        super(testName);
    }            

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        RuntimeDelegate.setInstance(new RuntimeDelegateStub());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        RuntimeDelegate.setInstance(null);
    }

    /**
     * Test of equals method, of class Cookie and NewCookie.
     */
    public void testEquals() {
        System.out.println("equals");
        Object nullObj = null;
        Cookie cookie = new Cookie("name", "value");
        Cookie cookie1 = new Cookie("name", "value");
        Cookie cookie2 = new Cookie("name", "value2");
        NewCookie newCookie = new NewCookie("name", "value");
        NewCookie newCookie1 = new NewCookie("name", "value");
        NewCookie newCookie2 = new NewCookie("name", "value2");
        assertFalse(cookie.equals(nullObj));
        assertFalse(cookie.equals(newCookie));
        assertFalse(cookie.equals(cookie2));
        assertTrue(cookie.equals(cookie1));
        assertTrue(cookie.equals(newCookie.toCookie()));
        assertTrue(newCookie.equals(newCookie1));
        assertFalse(newCookie.equals(newCookie2));
    }

}
