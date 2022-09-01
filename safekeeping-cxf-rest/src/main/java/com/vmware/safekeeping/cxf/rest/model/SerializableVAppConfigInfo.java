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
import com.vmware.safekeeping.cxf.rest.model.SerializableManagedByInfo;
import com.vmware.safekeeping.cxf.rest.model.SerializableVAppEntityConfigInfo;
import com.vmware.safekeeping.cxf.rest.model.SerializableVAppIPAssignmentInfo;
import com.vmware.safekeeping.cxf.rest.model.SerializableVAppOvfSectionInfo;
import com.vmware.safekeeping.cxf.rest.model.SerializableVAppProductInfo;
import com.vmware.safekeeping.cxf.rest.model.SerializableVAppPropertyInfo;
import com.vmware.safekeeping.cxf.rest.model.SerializableVmConfigInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * SerializableVAppConfigInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2022-08-31T19:06:45.540Z[GMT]")public class SerializableVAppConfigInfo extends SerializableVmConfigInfo  {
  @JsonProperty("Annotation")
  private String annotation = null;

  @JsonProperty("EntityConfig")
  private List<SerializableVAppEntityConfigInfo> entityConfig = null;

  @JsonProperty("InstanceUuid")
  private String instanceUuid = null;

  @JsonProperty("ManagedBy")
  private SerializableManagedByInfo managedBy = null;

  public SerializableVAppConfigInfo annotation(String annotation) {
    this.annotation = annotation;
    return this;
  }

  /**
   * Get annotation
   * @return annotation
   **/
  @JsonProperty("Annotation")
  @Schema(description = "")
  public String getAnnotation() {
    return annotation;
  }

  public void setAnnotation(String annotation) {
    this.annotation = annotation;
  }

  public SerializableVAppConfigInfo entityConfig(List<SerializableVAppEntityConfigInfo> entityConfig) {
    this.entityConfig = entityConfig;
    return this;
  }

  public SerializableVAppConfigInfo addEntityConfigItem(SerializableVAppEntityConfigInfo entityConfigItem) {
    if (this.entityConfig == null) {
      this.entityConfig = new ArrayList<SerializableVAppEntityConfigInfo>();
    }
    this.entityConfig.add(entityConfigItem);
    return this;
  }

  /**
   * Get entityConfig
   * @return entityConfig
   **/
  @JsonProperty("EntityConfig")
  @Schema(description = "")
  @Valid
  public List<SerializableVAppEntityConfigInfo> getEntityConfig() {
    return entityConfig;
  }

  public void setEntityConfig(List<SerializableVAppEntityConfigInfo> entityConfig) {
    this.entityConfig = entityConfig;
  }

  public SerializableVAppConfigInfo instanceUuid(String instanceUuid) {
    this.instanceUuid = instanceUuid;
    return this;
  }

  /**
   * Get instanceUuid
   * @return instanceUuid
   **/
  @JsonProperty("InstanceUuid")
  @Schema(description = "")
  public String getInstanceUuid() {
    return instanceUuid;
  }

  public void setInstanceUuid(String instanceUuid) {
    this.instanceUuid = instanceUuid;
  }

  public SerializableVAppConfigInfo managedBy(SerializableManagedByInfo managedBy) {
    this.managedBy = managedBy;
    return this;
  }

  /**
   * Get managedBy
   * @return managedBy
   **/
  @JsonProperty("ManagedBy")
  @Schema(description = "")
  @Valid
  public SerializableManagedByInfo getManagedBy() {
    return managedBy;
  }

  public void setManagedBy(SerializableManagedByInfo managedBy) {
    this.managedBy = managedBy;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SerializableVAppConfigInfo serializableVAppConfigInfo = (SerializableVAppConfigInfo) o;
    return Objects.equals(this.annotation, serializableVAppConfigInfo.annotation) &&
        Objects.equals(this.entityConfig, serializableVAppConfigInfo.entityConfig) &&
        Objects.equals(this.instanceUuid, serializableVAppConfigInfo.instanceUuid) &&
        Objects.equals(this.managedBy, serializableVAppConfigInfo.managedBy) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(annotation, entityConfig, instanceUuid, managedBy, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SerializableVAppConfigInfo {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    annotation: ").append(toIndentedString(annotation)).append("\n");
    sb.append("    entityConfig: ").append(toIndentedString(entityConfig)).append("\n");
    sb.append("    instanceUuid: ").append(toIndentedString(instanceUuid)).append("\n");
    sb.append("    managedBy: ").append(toIndentedString(managedBy)).append("\n");
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
