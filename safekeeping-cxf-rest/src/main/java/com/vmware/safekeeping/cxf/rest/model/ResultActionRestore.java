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
import com.vmware.safekeeping.cxf.rest.model.AbstractResultActionBackupRestore;
import com.vmware.safekeeping.cxf.rest.model.FcoLocation;
import com.vmware.safekeeping.cxf.rest.model.GenerationInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * ResultActionRestore
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2022-08-31T19:06:45.540Z[GMT]")public class ResultActionRestore extends AbstractResultActionBackupRestore  {
  @JsonProperty("RestoreFcoIndex")
  private Integer restoreFcoIndex = null;

  public ResultActionRestore restoreFcoIndex(Integer restoreFcoIndex) {
    this.restoreFcoIndex = restoreFcoIndex;
    return this;
  }

  /**
   * Get restoreFcoIndex
   * @return restoreFcoIndex
   **/
  @JsonProperty("RestoreFcoIndex")
  @Schema(description = "")
  public Integer getRestoreFcoIndex() {
    return restoreFcoIndex;
  }

  public void setRestoreFcoIndex(Integer restoreFcoIndex) {
    this.restoreFcoIndex = restoreFcoIndex;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResultActionRestore resultActionRestore = (ResultActionRestore) o;
    return Objects.equals(this.restoreFcoIndex, resultActionRestore.restoreFcoIndex) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(restoreFcoIndex, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultActionRestore {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    restoreFcoIndex: ").append(toIndentedString(restoreFcoIndex)).append("\n");
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
