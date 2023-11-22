package com.example.demo.model.v1;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CourseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CourseDTO   {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("nomecorso")
  private String nomecorso;

  public CourseDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CourseDTO nomecorso(String nomecorso) {
    this.nomecorso = nomecorso;
    return this;
  }

  /**
   * Get nomecorso
   * @return nomecorso
  */
  
  @Schema(name = "nomecorso", required = false)
  public String getNomecorso() {
    return nomecorso;
  }

  public void setNomecorso(String nomecorso) {
    this.nomecorso = nomecorso;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CourseDTO courseDTO = (CourseDTO) o;
    return Objects.equals(this.id, courseDTO.id) &&
        Objects.equals(this.nomecorso, courseDTO.nomecorso);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nomecorso);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CourseDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nomecorso: ").append(toIndentedString(nomecorso)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

