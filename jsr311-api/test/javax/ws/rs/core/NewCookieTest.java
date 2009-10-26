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

public class NewCookieTest extends TestCase {
    
    public NewCookieTest(String testName) {
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
     * Test of valueOf method, of class NewCookie.
     */
    public void testCtor() {
        System.out.println("ctor");
        Cookie c = new Cookie("name","value");
        NewCookie nc = new NewCookie(c);
        assertEquals(nc.getName(), c.getName());
        try {
            nc = new NewCookie(null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
        try {
            nc = new NewCookie(null, "comment", 120, true);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

}
