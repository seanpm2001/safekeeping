/*
 * Safekeeping Server
 * Safekeeping OpenAPI
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.vmware.safekeeping.cxf.rest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * SerializableManagedByInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2022-08-31T19:06:45.540Z[GMT]")public class SerializableManagedByInfo   {
  @JsonProperty("ExtensionKey")
  private String extensionKey = null;

  @JsonProperty("Type")
  private String type = null;

  public SerializableManagedByInfo extensionKey(String extensionKey) {
    this.extensionKey = extensionKey;
    return this;
  }

  /**
   * Get extensionKey
   * @return extensionKey
   **/
  @JsonProperty("ExtensionKey")
  @Schema(description = "")
  public String getExtensionKey() {
    return extensionKey;
  }

  public void setExtensionKey(String extensionKey) {
    this.extensionKey = extensionKey;
  }

  public SerializableManagedByInfo type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @JsonProperty("Type")
  @Schema(description = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SerializableManagedByInfo serializableManagedByInfo = (SerializableManagedByInfo) o;
    return Objects.equals(this.extensionKey, serializableManagedByInfo.extensionKey) &&
        Objects.equals(this.type, serializableManagedByInfo.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extensionKey, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SerializableManagedByInfo {\n");
    
    sb.append("    extensionKey: ").append(toIndentedString(extensionKey)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
