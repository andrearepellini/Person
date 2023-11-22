package com.example.demo.model.v1;

import java.net.URI;
import java.util.Objects;
import com.example.demo.model.v1.BookDTO;
import com.example.demo.model.v1.CourseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * PersonDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PersonDTO   {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("nome")
  private String nome;

  @JsonProperty("cognome")
  private String cognome;

  @JsonProperty("eta")
  private Integer eta;

  @JsonProperty("libri")
  @Valid
  private List<BookDTO> libri = null;

  @JsonProperty("corsi")
  @Valid
  private List<CourseDTO> corsi = null;

  public PersonDTO id(Long id) {
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

  public PersonDTO nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
  */
  
  @Schema(name = "nome", required = false)
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public PersonDTO cognome(String cognome) {
    this.cognome = cognome;
    return this;
  }

  /**
   * Get cognome
   * @return cognome
  */
  
  @Schema(name = "cognome", required = false)
  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public PersonDTO eta(Integer eta) {
    this.eta = eta;
    return this;
  }

  /**
   * Get eta
   * @return eta
  */
  
  @Schema(name = "eta", required = false)
  public Integer getEta() {
    return eta;
  }

  public void setEta(Integer eta) {
    this.eta = eta;
  }

  public PersonDTO libri(List<BookDTO> libri) {
    this.libri = libri;
    return this;
  }

  public PersonDTO addLibriItem(BookDTO libriItem) {
    if (this.libri == null) {
      this.libri = new ArrayList<>();
    }
    this.libri.add(libriItem);
    return this;
  }

  /**
   * Get libri
   * @return libri
  */
  @Valid 
  @Schema(name = "libri", required = false)
  public List<BookDTO> getLibri() {
    return libri;
  }

  public void setLibri(List<BookDTO> libri) {
    this.libri = libri;
  }

  public PersonDTO corsi(List<CourseDTO> corsi) {
    this.corsi = corsi;
    return this;
  }

  public PersonDTO addCorsiItem(CourseDTO corsiItem) {
    if (this.corsi == null) {
      this.corsi = new ArrayList<>();
    }
    this.corsi.add(corsiItem);
    return this;
  }

  /**
   * Get corsi
   * @return corsi
  */
  @Valid 
  @Schema(name = "corsi", required = false)
  public List<CourseDTO> getCorsi() {
    return corsi;
  }

  public void setCorsi(List<CourseDTO> corsi) {
    this.corsi = corsi;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonDTO personDTO = (PersonDTO) o;
    return Objects.equals(this.id, personDTO.id) &&
        Objects.equals(this.nome, personDTO.nome) &&
        Objects.equals(this.cognome, personDTO.cognome) &&
        Objects.equals(this.eta, personDTO.eta) &&
        Objects.equals(this.libri, personDTO.libri) &&
        Objects.equals(this.corsi, personDTO.corsi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, cognome, eta, libri, corsi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    eta: ").append(toIndentedString(eta)).append("\n");
    sb.append("    libri: ").append(toIndentedString(libri)).append("\n");
    sb.append("    corsi: ").append(toIndentedString(corsi)).append("\n");
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

