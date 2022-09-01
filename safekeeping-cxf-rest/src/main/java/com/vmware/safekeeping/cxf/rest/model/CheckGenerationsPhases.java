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
 * Gets or Sets CheckGenerationsPhases
 */
public enum CheckGenerationsPhases {
  NONE("NONE"),
    START("START"),
    START_ACCESS_ARCHIVE("START_ACCESS_ARCHIVE"),
    END_ACCESS_ARCHIVE("END_ACCESS_ARCHIVE"),
    START_RETRIEVE_REQUESTED_GENERATIONS("START_RETRIEVE_REQUESTED_GENERATIONS"),
    END_RETRIEVE_REQUESTED_GENERATIONS("END_RETRIEVE_REQUESTED_GENERATIONS"),
    START_RETRIEVE_DEPENDING_GENERATIONS("START_RETRIEVE_DEPENDING_GENERATIONS"),
    END_RETRIEVE_DEPENDING_GENERATIONS("END_RETRIEVE_DEPENDING_GENERATIONS"),
    START_CHECK_GENERATIONS("START_CHECK_GENERATIONS"),
    START_CHECK_GENERATION("START_CHECK_GENERATION"),
    START_LOAD_GENERATION_PROFILE("START_LOAD_GENERATION_PROFILE"),
    END_LOAD_GENERATION_PROFILE("END_LOAD_GENERATION_PROFILE"),
    START_CHECK_FILES("START_CHECK_FILES"),
    START_CHECK_FILE("START_CHECK_FILE"),
    END_CHECK_FILE("END_CHECK_FILE"),
    END_CHECK_FILES("END_CHECK_FILES"),
    END_CHECK_GENERATION("END_CHECK_GENERATION"),
    END_CHECK_GENERATIONS("END_CHECK_GENERATIONS"),
    START_UPDATE_FCO_PROFILES_CATALOG("START_UPDATE_FCO_PROFILES_CATALOG"),
    END_UPDATE_FCO_PROFILES_CATALOG("END_UPDATE_FCO_PROFILES_CATALOG"),
    END("END");

  private String value;

  CheckGenerationsPhases(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static CheckGenerationsPhases fromValue(String text) {
    for (CheckGenerationsPhases b : CheckGenerationsPhases.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
