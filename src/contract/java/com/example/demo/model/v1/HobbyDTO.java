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
 * HobbyDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class HobbyDTO   {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("personid")
  private Long personid;

  @JsonProperty("nomehobby")
  private String nomehobby;

  public HobbyDTO id(Long id) {
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

  public HobbyDTO personid(Long personid) {
    this.personid = personid;
    return this;
  }

  /**
   * Get personid
   * @return personid
  */
  
  @Schema(name = "personid", required = false)
  public Long getPersonid() {
    return personid;
  }

  public void setPersonid(Long personid) {
    this.personid = personid;
  }

  public HobbyDTO nomehobby(String nomehobby) {
    this.nomehobby = nomehobby;
    return this;
  }

  /**
   * Get nomehobby
   * @return nomehobby
  */
  
  @Schema(name = "nomehobby", required = false)
  public String getNomehobby() {
    return nomehobby;
  }

  public void setNomehobby(String nomehobby) {
    this.nomehobby = nomehobby;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HobbyDTO hobbyDTO = (HobbyDTO) o;
    return Objects.equals(this.id, hobbyDTO.id) &&
        Objects.equals(this.personid, hobbyDTO.personid) &&
        Objects.equals(this.nomehobby, hobbyDTO.nomehobby);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, personid, nomehobby);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HobbyDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    personid: ").append(toIndentedString(personid)).append("\n");
    sb.append("    nomehobby: ").append(toIndentedString(nomehobby)).append("\n");
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

