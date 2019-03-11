/*
 * Copyright (c) 2014-2016 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package com.snowplowanalytics.iglu.schemaddl.jsonschema
package properties

/**
  * Marker trait for properties specific *ONLY* for arrays
  */
private[iglu] sealed trait ArrayProperty

object ArrayProperty {

  /**
   * ADT representing value for `items` keyword
   *
   * @see http://json-schema.org/latest/json-schema-validation.html#anchor37
   */
  sealed trait Items[A] extends JsonSchemaProperty with ArrayProperty {
    def keyName = "items"
  }
  object Items {
    case class ListItems[A](value: A) extends Items[A]
    case class TupleItems[A](value: List[A]) extends Items[A]
  }

  /**
   * ADT representing value for `additionalItems` keyword
   *
   * @see http://json-schema.org/latest/json-schema-validation.html#anchor37
   */
  sealed trait AdditionalItems[A] extends JsonSchemaProperty with ArrayProperty {
    def keyName = "additionalItems"
  }
  object AdditionalItems {
    case class AdditionalItemsAllowed[A](value: Boolean) extends AdditionalItems[A]
    case class AdditionalItemsSchema[A](value: A) extends AdditionalItems[A]
  }

  /**
   * Container representing value for `maxItems` keyword
   *
   * @see http://json-schema.org/latest/json-schema-validation.html#anchor42
   */
  case class MaxItems(value: BigInt) extends JsonSchemaProperty with ArrayProperty {
    def keyName = "maxItems"
  }

  /**
   * Container representing value for `minItems` keyword
   *
   * @see http://json-schema.org/latest/json-schema-validation.html#anchor45
   */
  case class MinItems(value: BigInt) extends JsonSchemaProperty with ArrayProperty {
    def keyName = "minItems"
  }
}


