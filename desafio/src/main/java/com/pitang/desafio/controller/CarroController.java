package com.pitang.desafio.controller;

import com.pitang.desafio.dto.CarroDto;
import com.pitang.desafio.dto.response.ErrorResponseDto;
import com.pitang.desafio.dto.response.ResponseDto;
import com.pitang.desafio.service.ICarroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Validated
@RestController
@CrossOrigin(maxAge = 300)
@RequestMapping(path = "/v1/api")
@RequiredArgsConstructor
public class CarroController {

    private final ICarroService carroService;

    /**
     * Endpoint responsible for get all Cars
     * @return List<CarroDto>
     */
    @Operation(
            summary = "Get all Cars",
            description = "Get all Cars"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Get all Cars",
                    content = @Content(
                            schema = @Schema(implementation = ResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "BAD REQUEST",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping(path = "/cars", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CarroDto>> getAllCars(){
        return ResponseEntity.status(HttpStatus.OK).body(carroService.getAllCars());
    }

    /**
     * Endpoint responsible for get a car by Id
     * @return CarroDto
     */
    @Operation(
            summary = "Get Car by Id",
            description = "Get Car by Id"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Get Car by Id",
                    content = @Content(
                            schema = @Schema(implementation = ResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "BAD REQUEST",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping(path = "/cars/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CarroDto> getCarroById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(carroService.buscaCarroPorId(id));
    }

    /**
     * Endpoint responsible for create a Car
     * @param carroDto
     * @return ResponseDto
     */
    @Operation(
            summary = "Create Car",
            description = "Create Car"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Create Car",
                    content = @Content(
                            schema = @Schema(implementation = ResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "BAD REQUEST",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PostMapping(path = "/cars", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseDto> cadastrarCarroUsuario(@Valid @RequestBody CarroDto carroDto){
        return carroService.cadastrarCarro(carroDto);
    }

    /**
     * Endpoint responsible for update a Car by Id
     * @param id
     * @return
     */
    @Operation(
            summary = "Update Car by Id",
            description = "Update Car by Id"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Update Car by Id",
                    content = @Content(
                            schema = @Schema(implementation = ResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "BAD REQUEST",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping(path = "/cars/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseDto> atualizarCarroPorId(@PathVariable String id,
                                                           @Valid @RequestBody CarroDto carroDto){
        return carroService.atualizarCarro(id, carroDto);
    }

    /**
     * Endpoint responsible for delete a car
     * @param id
     * @return
     */
    @Operation(
            summary = "Delete Car by Id",
            description = "Delete Car by Id"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Delete Car by Id",
                    content = @Content(
                            schema = @Schema(implementation = ResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "BAD REQUEST",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping(path = "/cars/{id}")
    public ResponseEntity<ResponseDto> removerCarro(@PathVariable String id){
        return carroService.removerCarro(id);
    }

}
