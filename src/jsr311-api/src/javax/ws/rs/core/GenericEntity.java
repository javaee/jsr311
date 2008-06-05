package javax.ws.rs.core;

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
 *
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.ws.rs.ext.MessageBodyWriter;

/**
 * Represents a response entity of a generic type {@code T}.
 * 
 * <p>Normally type erasure removes generic type information such that a
 * {@link Response} instance that contains, e.g., an entity of type
 * {@code List<String>} appears to contain a raw {@code List<?>} at runtime.
 * When the generic type is required to select a suitable
 * {@link MessageBodyWriter}, this class may be used to wrap the entity and
 * capture its generic type.</p>
 * 
 * <p>Users are required to create a subclass of this class which enables
 * retrieval of the type information at runtime despite type erasure. For 
 * example, the following code shows how to create a {@link Response}
 * containing an entity of type {@code List<String>} whose generic type will be
 * available at runtime for selection of a suitable {@link MessageBodyWriter}:
 * 
 * <pre>List&lt;String&gt; list = new ArrayList<String>();
 *GenericEntity&lt;List&lt;String&gt;&gt; entity = new GenericEntity&lt;List&lt;String&gt;&gt;(list) {};
 *Response response = Response.ok(entity);</pre>
 *
 * <p>where <code>list</code> is the instance of <code>List&lt;String&gt</code>
 * that will form the response body and entity is an instance of an anonymous
 * subclass of {@code GenericEntity}.
 */
public class GenericEntity<T> {

  final Class<?> rawType;
  final Type type;
  final T entity;

  /**
   * Constructs a new generic entity. Derives represented class from type
   * parameter.
   *
   * @param entity the entity instance
   */
  protected GenericEntity(T entity) {
    if (entity==null)
        throw new IllegalArgumentException();
    this.entity = entity;
    this.type = getSuperclassTypeParameter(getClass());
    this.rawType = entity.getClass();
  }

  /**
   * Returns the type from super class's type parameter.
   */
  private static Type getSuperclassTypeParameter(Class<?> subclass) {
    Type superclass = subclass.getGenericSuperclass();
    if (superclass instanceof Class) {
      throw new RuntimeException("Missing type parameter.");
    }
    ParameterizedType parameterized = (ParameterizedType) superclass;
    return parameterized.getActualTypeArguments()[0];
  }

  /**
   * Gets the raw type of the enclosed entity. Note that this is the raw type of
   * the instance, not the raw type of the type parameter. I.e. in the example
   * in the introduction, the raw type is {@code ArrayList} not {@code List}.
   * @return the raw type
   */
  public final Class<?> getRawType() {
    return rawType;
  }

  /**
   * Gets underlying {@code Type} instance. Note that this is derived from the
   * type parameter, not the enclosed instance. I.e. in the example
   * in the introduction, the type is {@code List<String>} not
   * {@code ArrayList<String>}.
   * @return the type
   */
  public final Type getType() {
    return type;
  }

  /**
   * Get the enclosed entity
   * @return the enclosed entity
   */
  public final T getEntity() {
      return entity;
  }
}