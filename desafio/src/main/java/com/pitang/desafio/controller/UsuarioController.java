package com.pitang.desafio.controller;

import com.pitang.desafio.dto.LoginDto;
import com.pitang.desafio.dto.UsuarioDto;
import com.pitang.desafio.dto.response.ErrorResponseDto;
import com.pitang.desafio.dto.response.ResponseDto;
import com.pitang.desafio.service.IUsuarioService;
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
public class UsuarioController {

    private final IUsuarioService usuarioService;

    /**
     * Endpoint responsible for get the Token jwt
     * @param loginDto
     * @return String
     */
    @Operation(
            summary = "Sign in",
            description = "Endpoint for sign in"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status CREATED",
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
    @PostMapping(path = "/signin", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseDto> getToken(@Valid @RequestBody LoginDto loginDto){
        return usuarioService.getToken(loginDto);
    }

    /**
     * Endpoint responsible for get Usuario's information
     * @return UsuarioDto
     */
    @Operation(
            summary = "Information about User",
            description = "Endpoint for get information about user"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Get all information about the user",
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
    @PostMapping(path = "/me")
    public ResponseEntity<UsuarioDto> getInformacoesUsuarioLOgado(@Valid @RequestBody LoginDto loginDto){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.informacoesUsuario(loginDto));
    }

    /**
     * Endpoint responsible for create Usuario
     * @param usuarioDto
     * @return ResponseDto
     */
    @Operation(
            summary = "Create User",
            description = "Create user"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Create User",
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
    @PostMapping(path = "/users", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody UsuarioDto usuarioDto){
        return usuarioService.createUsuario(usuarioDto);
    }

    /**
     * Endpoint responsible for get all users
     * @return List<UsuarioDto>
     */
    @Operation(
            summary = "Get all Users",
            description = "Get all Users"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Get all users",
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
    @GetMapping(path = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UsuarioDto>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getAllUsers());
    }

    /**
     * Endpoint responsible for get Usuario by Id
     * @param id
     * @return UsuarioDto
     */
    @Operation(
            summary = "Get User by Id",
            description = "Endpoint for sign in"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Get User by Id",
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
    @GetMapping(path = "/users/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsuarioDto> getUsuarioPorId(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getUsuarioPorId(id));
    }

    /**
     * Endpoint responsible for update Usuario by Id
     * @param id
     * @param usuarioDto
     * @return ResponseDto
     */
    @Operation(
            summary = "Update User",
            description = "Update User"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status CREATED",
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
    @PutMapping(path = "/users/{id}")
    public ResponseEntity<ResponseDto> atualizarUsuarioPorId(@PathVariable String id,
                                                             @Valid @RequestBody UsuarioDto usuarioDto){
        return usuarioService.atualizarUsuarioPorId(id, usuarioDto);
    }

    /**
     * Endpoint responsible for delete Usuario by Id
     * @param id
     * @return
     */
    @Operation(
            summary = "Delete User by Id",
            description = "Delete User Id"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status CREATED",
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
    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<ResponseDto> deleteUsuarioPorId(@PathVariable String id){
        return usuarioService.deleteUsuarioPorId(id);
    }

}
