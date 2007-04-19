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
 * ResponseProvider.java
 *
 * Created on April 18, 2007, 9:00 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package javax.ws.rs.core;

/**
 * Defines the contract between a returned instance and the runtime should
 * the returned instance need to provide metadata to the runtime. An application
 * class can implement this interface directly or a method can return an instance
 * of Response instead.
 * @see Response
 */
public interface ResponseProvider {
    Object getEntity();
    int getStatus();
    void addMetadata(MultivaluedMap<String, Object> metadata);
}
