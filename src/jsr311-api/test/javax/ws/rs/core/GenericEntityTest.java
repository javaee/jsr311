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

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

public class GenericEntityTest extends TestCase {
    
    public GenericEntityTest(String testName) {
        super(testName);
    }            

    public void testListOfString() {
        System.out.println("testListOfString");
        List<String> list = new ArrayList<String>();
        GenericEntity<List<String>> listOfString = new GenericEntity<List<String>>(list) {};
        Class<?> rawType = listOfString.getRawType();
        assertEquals(rawType, ArrayList.class);
        Type type = listOfString.getType();
        assertTrue(type instanceof ParameterizedType);
        ParameterizedType pType = (ParameterizedType)type;
        Type typeArgs[] = pType.getActualTypeArguments();
        assertEquals(1, typeArgs.length);
        assertTrue(typeArgs[0] instanceof Class<?>);
        Class<?> typeArgType = (Class<?>)typeArgs[0];
        assertEquals(typeArgType, String.class);
    }

    @SuppressWarnings("unchecked")
    public void testArrayOfListOfString() {
        System.out.println("testArrayOfListOfString");
        List<String> array[] = new List[1];
        GenericEntity<List<String>[]> arrayOfListOfString = new GenericEntity<List<String>[]>(array) {};
        Class<?> rawType = arrayOfListOfString.getRawType();
        assertTrue(rawType.isArray());
        Type type = arrayOfListOfString.getType();
        assertTrue(type instanceof GenericArrayType);
        type = ((GenericArrayType)type).getGenericComponentType();
        assertTrue(type instanceof ParameterizedType);
        ParameterizedType pType = (ParameterizedType)type;
        Type typeArgs[] = pType.getActualTypeArguments();
        assertEquals(1, typeArgs.length);
        assertTrue(typeArgs[0] instanceof Class<?>);
        Class<?> typeArgType = (Class<?>)typeArgs[0];
        assertEquals(typeArgType, String.class);
    }
    
    public void testNumber() {
        System.out.println("testNumber");
        Number n = new Integer(0);
        GenericEntity<Number> number = new GenericEntity<Number>(n) {};
        Class<?> rawType = number.getRawType();
        assertEquals(rawType, Integer.class);
        Type type = number.getType();
        assertTrue(type instanceof Class);
        Class<?> genericType = (Class<?>)type;
        assertEquals(genericType, Number.class);
    }


}
