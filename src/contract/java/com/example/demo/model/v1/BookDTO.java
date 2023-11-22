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
 * BookDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class BookDTO   {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("titololibro")
  private String titololibro;

  @JsonProperty("personid")
  private Long personid;

  public BookDTO id(Long id) {
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

  public BookDTO titololibro(String titololibro) {
    this.titololibro = titololibro;
    return this;
  }

  /**
   * Get titololibro
   * @return titololibro
  */
  
  @Schema(name = "titololibro", required = false)
  public String getTitololibro() {
    return titololibro;
  }

  public void setTitololibro(String titololibro) {
    this.titololibro = titololibro;
  }

  public BookDTO personid(Long personid) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookDTO bookDTO = (BookDTO) o;
    return Objects.equals(this.id, bookDTO.id) &&
        Objects.equals(this.titololibro, bookDTO.titololibro) &&
        Objects.equals(this.personid, bookDTO.personid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, titololibro, personid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    titololibro: ").append(toIndentedString(titololibro)).append("\n");
    sb.append("    personid: ").append(toIndentedString(personid)).append("\n");
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

