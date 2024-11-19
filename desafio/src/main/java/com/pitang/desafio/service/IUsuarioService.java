package com.pitang.desafio.service;

import com.pitang.desafio.dto.LoginDto;
import com.pitang.desafio.dto.UsuarioDto;
import com.pitang.desafio.dto.response.ResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUsuarioService {

    /**
     * Method responsible for get all Usuários
     * @return Lista de UsuárioDto
     */
    List<UsuarioDto> getAllUsers();

    /**
     * Method responsible for create Usuario
     * @param usuarioDto
     * @return ResponseEntity<ResponseDto>
     */
    ResponseEntity<ResponseDto> createUsuario(UsuarioDto usuarioDto);

    /**
     * Method responsible for get Usuario by id
     * @param id
     * @return UsuarioDto
     */
    UsuarioDto getUsuarioPorId(String id);

    /**
     * Method responsible for update Usuario by id
     * @param id
     * @param usuarioDto
     * @return ResponseDto
     */
    ResponseEntity<ResponseDto> atualizarUsuarioPorId(String id, UsuarioDto usuarioDto);

    /**
     * Method responsible for delete Usuario by id
     * @param id
     * @return ResponseDto
     */
    ResponseEntity<ResponseDto> deleteUsuarioPorId(String id);

    /**
     * Method responsible for get token
     * @param loginDto
     * @return ResponseDto
     */
    ResponseEntity<ResponseDto> getToken(LoginDto loginDto);

    /**
     * Method responsible for get Usuario's information
     * @param loginDto
     * @return UsuarioDto
     */
    UsuarioDto informacoesUsuario(LoginDto loginDto);
}
