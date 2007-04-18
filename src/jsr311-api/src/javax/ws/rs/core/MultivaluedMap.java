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
 * MultivaluedMap.java
 *
 * Created on February 13, 2007, 2:30 PM
 *
 */

package javax.ws.rs.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A map of key-values pairs. Each key can have zero or more values.
 * 
 */
public class MultivaluedMap<K, V> extends HashMap<K, List<V>> {
    
    /**
     * Set the key's value to be a one item list consisting of the supplied value.
     * Any existing values will be replaced.
     * 
     * @param key the key
     * @param value the single value of the key
     */
    void putSingle(K key, V value) {
        List<V> values = get(key);
        if (values != null)
            values.clear();
        else {
            values = new ArrayList<V>();
            put(key, values);
        }
        values.add(value);
    }
    
    /**
     * Add a value to the current list of values for the supplied key.
     * @param key the key 
     * @param value the value to be added.
     */
    void add(K key, V value) {
        List<V> values = get(key);
        if (values == null) {
            values = new ArrayList<V>();
            put(key, values);
        }
        values.add(value);
    }
    
    /**
     * A shortcut to get the first value of the supplied key.
     * @param key the key
     * @return the first value for the specified key or null if the key is
     * not in the map.
     */
    V getFirst(K key) {
        List<V> values = get(key);
        if (values == null || values.size()<1)
            return null;
        return values.get(0);
    }
    
}

