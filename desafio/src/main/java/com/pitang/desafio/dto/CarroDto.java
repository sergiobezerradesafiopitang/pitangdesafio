package com.pitang.desafio.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarroDto {

    @JsonProperty("id_carro")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idCarro;

    @NotNull(message = "Invalid or Missing fields")
    @JsonProperty("year")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer year;

    @NotEmpty(message = "Invalid fields")
    @NotBlank(message = "Missing fields")
    @JsonProperty("license_plate")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String licensePlate;

    @NotEmpty(message = "Invalid fields")
    @NotBlank(message = "Missing fields")
    @JsonProperty("model")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String model;

    @NotEmpty(message = "Invalid fields")
    @NotBlank(message = "Missing fields")
    @JsonProperty("color")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String color;

    @JsonProperty("id_Usuario")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String idUsuario;


}
