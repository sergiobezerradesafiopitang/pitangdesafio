package com.pitang.desafio.service.Impl;

import com.pitang.desafio.Util.Utils;
import com.pitang.desafio.constants.Constantes;
import com.pitang.desafio.dto.LoginDto;
import com.pitang.desafio.dto.UsuarioDto;
import com.pitang.desafio.dto.response.ResponseDto;
import com.pitang.desafio.exception.InvalidLoginPasswordException;
import com.pitang.desafio.exception.TokenNotSendedException;
import com.pitang.desafio.exception.UsuarioNotFoundException;
import com.pitang.desafio.mapper.Mapper;
import com.pitang.desafio.model.Usuario;
import com.pitang.desafio.repository.IUsuarioRepository;
import com.pitang.desafio.service.IKeykloakService;
import com.pitang.desafio.service.IUsuarioService;
import com.pitang.desafio.validation.Validacoes;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;
    private final Validacoes validacoes;
    private final IKeykloakService keykloakService;


    /**
     * Method responsible for get all Usuários
     * @return Lista de UsuárioDto
     */
    @Override
    @Transactional(readOnly=true)
    public List<UsuarioDto> getAllUsers() {
        return usuarioRepository.findAll().stream().map(value -> Mapper.convertToUsuarioDto(value)).collect(Collectors.toList());
    }

    /**
     * Method responsible for create Usuario
     * @param usuarioDto
     * @return ResponseEntity<ResponseDto>
     */
    @Override
    @Transactional
    public ResponseEntity<ResponseDto> createUsuario(UsuarioDto usuarioDto) {

        this.checarValidacoesUsuario(usuarioDto);
        Usuario usuario = Mapper.convertToUsuario(usuarioDto);
        usuario.setCreatedAt(LocalDateTime.now());
        Usuario usuarioFinal = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).header("id_usuario", usuarioFinal.getIdUsuario().toString())
                .body(new ResponseDto(HttpStatus.CREATED.value(), Constantes.USUARIO_CREATED));

    }

    /**
     * Method responsible for get Usuario by id
     * @param id
     * @return UsuarioDto
     */
    @Override
    @Transactional(readOnly = true)
    public UsuarioDto getUsuarioPorId(String id) {

        Usuario usuario = usuarioRepository.findById(Long.parseLong(id)).orElseThrow(() -> {throw new UsuarioNotFoundException();});
        return Mapper.convertToUsuarioDto(usuario);

    }

    /**
     * Method responsible for update Usuario by id
     * @param id
     * @return ResponseDto
     */
    @Override
    @Transactional
    public ResponseEntity<ResponseDto> atualizarUsuarioPorId(String id, UsuarioDto usuarioDto) {

        Usuario usuario = usuarioRepository.findById(Long.parseLong(id)).orElseThrow(() -> {throw new UsuarioNotFoundException();});
        Mapper.updateUsuarioFromUsuarioDto(usuario, usuarioDto);
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(new ResponseDto(HttpStatus.NO_CONTENT.value(), Constantes.USUARIO_UPDATED));

    }

    /**
     * Method responsible for delete Usuario by id
     * @param id
     * @return ResponseDto
     */
    @Override
    @Transactional
    public ResponseEntity<ResponseDto> deleteUsuarioPorId(String id) {

        Usuario usuario = usuarioRepository.findById(Long.parseLong(id)).orElseThrow(() -> {throw new UsuarioNotFoundException();});
        usuarioRepository.delete(usuario);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.value(), Constantes.USUARIO_DELETED));

    }

    /**
     * Method responsible for get token
     * @param loginDto
     * @return
     */
    @Override
    public ResponseEntity<ResponseDto> getToken(LoginDto loginDto) {

        String responseToken = null;
        Usuario usuario = null;

        try{
            usuario = usuarioRepository.findByLoginAndPassword(loginDto.getLogin(), Utils.encodePassword(loginDto.getPassword()));
            if(null != usuario && !usuario.getEmail().equals("")){
                responseToken = keykloakService.getTokenFromHttpRequest(usuario);
            }else{
                throw new UsuarioNotFoundException();
            }
        } catch (UsuarioNotFoundException ex) {
            throw new UsuarioNotFoundException();
        } catch (InvalidLoginPasswordException ex){
            throw new InvalidLoginPasswordException();
        } catch (Exception ex){
            throw new TokenNotSendedException();
        }

        usuario.setLastLogin(LocalDateTime.now());
        usuarioRepository.save(usuario);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.value(), responseToken));

    }

    /**
     * Method responsible for get Usuario's information
     * @param loginDto
     * @return UsuarioDto
     */
    @Override
    public UsuarioDto informacoesUsuario(LoginDto loginDto) {
        Usuario usuario = usuarioRepository.findByLoginAndPassword(loginDto.getLogin(), Utils.encodePassword(loginDto.getPassword()));
        if(null == usuario){
            throw new UsuarioNotFoundException();
        }
        return Mapper.convertToUsuarioDtoForInformation(usuario);
    }

    /**
     * Method responsible for validation
     * @param usuarioDto
     */
    private void checarValidacoesUsuario(UsuarioDto usuarioDto){

        validacoes.checarEmailDuplicado(usuarioDto);
        validacoes.checarLoginDuplicado(usuarioDto);
        validacoes.checkBirthday(usuarioDto);

    }

}
