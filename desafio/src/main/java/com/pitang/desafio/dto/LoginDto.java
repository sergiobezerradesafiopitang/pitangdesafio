package com.pitang.desafio.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginDto {

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

}
