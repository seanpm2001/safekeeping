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
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import javax.validation.constraints.*;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets FileBackingInfoProvisioningType
 */
public enum FileBackingInfoProvisioningType {
  EAGER_ZEROED_THICK("EAGER_ZEROED_THICK"),
    LAZY_ZEROED_THICK("LAZY_ZEROED_THICK"),
    THIN("THIN");

  private String value;

  FileBackingInfoProvisioningType(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static FileBackingInfoProvisioningType fromValue(String text) {
    for (FileBackingInfoProvisioningType b : FileBackingInfoProvisioningType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
