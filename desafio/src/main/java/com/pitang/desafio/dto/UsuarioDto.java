package com.pitang.desafio.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pitang.desafio.model.Carro;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDto {

    @JsonProperty("id_usuario")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idUsuario;

    @NotEmpty(message = "Invalid fields")
    @NotBlank(message = "Missing fields")
    @JsonProperty("first_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;

    @NotEmpty(message = "Invalid fields")
    @NotBlank(message = "Missing fields")
    @JsonProperty("last_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;

    @Email(message = "Invalid fields")
    @NotBlank(message = "Missing fields")
    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    @JsonProperty("birthday")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date birthday;

    @NotEmpty(message = "Invalid fields")
    @NotBlank(message = "Missing fields")
    @JsonProperty("login")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String login;

    @NotEmpty(message = "Invalid fields")
    @NotBlank(message = "Missing fields")
    @JsonProperty("password")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    @NotEmpty(message = "Invalid fields")
    @NotBlank(message = "Missing fields")
    @JsonProperty("phone")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;

    @JsonProperty("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime createdAt;

    @JsonProperty("last_login")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime lastLogin;

    @JsonProperty("cars")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Carro> cars;


}
