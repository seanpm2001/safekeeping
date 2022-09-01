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
import com.vmware.safekeeping.cxf.rest.model.BackupMode;
import com.vmware.safekeeping.cxf.rest.model.Generation;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * GeneretionDependenciesInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2022-08-31T19:06:45.540Z[GMT]")public class GeneretionDependenciesInfo   {
  @JsonProperty("DependingGenerationId")
  private Generation dependingGenerationId = null;

  @JsonProperty("DependOnGenerationId")
  private Integer dependOnGenerationId = null;

  @JsonProperty("GenId")
  private Integer genId = null;

  @JsonProperty("Mode")
  private BackupMode mode = null;

  @JsonProperty("DependingOn")
  private Boolean dependingOn = null;

  @JsonProperty("Exist")
  private Boolean exist = null;

  public GeneretionDependenciesInfo dependingGenerationId(Generation dependingGenerationId) {
    this.dependingGenerationId = dependingGenerationId;
    return this;
  }

  /**
   * Get dependingGenerationId
   * @return dependingGenerationId
   **/
  @JsonProperty("DependingGenerationId")
  @Schema(description = "")
  @Valid
  public Generation getDependingGenerationId() {
    return dependingGenerationId;
  }

  public void setDependingGenerationId(Generation dependingGenerationId) {
    this.dependingGenerationId = dependingGenerationId;
  }

  public GeneretionDependenciesInfo dependOnGenerationId(Integer dependOnGenerationId) {
    this.dependOnGenerationId = dependOnGenerationId;
    return this;
  }

  /**
   * Get dependOnGenerationId
   * @return dependOnGenerationId
   **/
  @JsonProperty("DependOnGenerationId")
  @Schema(description = "")
  public Integer getDependOnGenerationId() {
    return dependOnGenerationId;
  }

  public void setDependOnGenerationId(Integer dependOnGenerationId) {
    this.dependOnGenerationId = dependOnGenerationId;
  }

  public GeneretionDependenciesInfo genId(Integer genId) {
    this.genId = genId;
    return this;
  }

  /**
   * Get genId
   * @return genId
   **/
  @JsonProperty("GenId")
  @Schema(description = "")
  public Integer getGenId() {
    return genId;
  }

  public void setGenId(Integer genId) {
    this.genId = genId;
  }

  public GeneretionDependenciesInfo mode(BackupMode mode) {
    this.mode = mode;
    return this;
  }

  /**
   * Get mode
   * @return mode
   **/
  @JsonProperty("Mode")
  @Schema(description = "")
  @Valid
  public BackupMode getMode() {
    return mode;
  }

  public void setMode(BackupMode mode) {
    this.mode = mode;
  }

  public GeneretionDependenciesInfo dependingOn(Boolean dependingOn) {
    this.dependingOn = dependingOn;
    return this;
  }

  /**
   * Get dependingOn
   * @return dependingOn
   **/
  @JsonProperty("DependingOn")
  @Schema(description = "")
  public Boolean isDependingOn() {
    return dependingOn;
  }

  public void setDependingOn(Boolean dependingOn) {
    this.dependingOn = dependingOn;
  }

  public GeneretionDependenciesInfo exist(Boolean exist) {
    this.exist = exist;
    return this;
  }

  /**
   * Get exist
   * @return exist
   **/
  @JsonProperty("Exist")
  @Schema(description = "")
  public Boolean isExist() {
    return exist;
  }

  public void setExist(Boolean exist) {
    this.exist = exist;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeneretionDependenciesInfo generetionDependenciesInfo = (GeneretionDependenciesInfo) o;
    return Objects.equals(this.dependingGenerationId, generetionDependenciesInfo.dependingGenerationId) &&
        Objects.equals(this.dependOnGenerationId, generetionDependenciesInfo.dependOnGenerationId) &&
        Objects.equals(this.genId, generetionDependenciesInfo.genId) &&
        Objects.equals(this.mode, generetionDependenciesInfo.mode) &&
        Objects.equals(this.dependingOn, generetionDependenciesInfo.dependingOn) &&
        Objects.equals(this.exist, generetionDependenciesInfo.exist);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dependingGenerationId, dependOnGenerationId, genId, mode, dependingOn, exist);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeneretionDependenciesInfo {\n");
    
    sb.append("    dependingGenerationId: ").append(toIndentedString(dependingGenerationId)).append("\n");
    sb.append("    dependOnGenerationId: ").append(toIndentedString(dependOnGenerationId)).append("\n");
    sb.append("    genId: ").append(toIndentedString(genId)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    dependingOn: ").append(toIndentedString(dependingOn)).append("\n");
    sb.append("    exist: ").append(toIndentedString(exist)).append("\n");
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
