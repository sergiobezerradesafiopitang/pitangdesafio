package com.pitang.desafio.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    @JsonProperty("status_code")
    private Integer statusCode;

    @JsonProperty("message")
    private String message;

}
