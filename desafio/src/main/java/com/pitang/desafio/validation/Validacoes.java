package com.pitang.desafio.validation;

import com.pitang.desafio.constants.Constantes;
import com.pitang.desafio.dto.UsuarioDto;
import com.pitang.desafio.exception.EmailAlreadyExistsException;
import com.pitang.desafio.exception.LoginAlreadyExistsException;
import com.pitang.desafio.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Pattern;


@RequiredArgsConstructor
public class Validacoes {

    private final IUsuarioRepository usuarioRepository;

    /**
     * Method responsible for check duplicated email
     * @param usuarioDto
     */
    public void checarEmailDuplicado(UsuarioDto usuarioDto){

        usuarioRepository.findByEmail(usuarioDto.getEmail())
                .ifPresent(value-> {throw new EmailAlreadyExistsException();});

    }

    /**
     * Method responsible for check duplicated login
     * @param usuarioDto
     */
    public void checarLoginDuplicado(UsuarioDto usuarioDto){

        usuarioRepository.findByLogin(usuarioDto.getLogin())
                .ifPresent(value-> {throw new LoginAlreadyExistsException();});

    }

    /**
     * Method responsible for check birthday
     * @param usuarioDto
     */
    public void checkBirthday(UsuarioDto usuarioDto){

        if(null == usuarioDto.getBirthday()){
            throw new RuntimeException(Constantes.GENERAL_FIELD_EXCEPTION);
        }

        String pattern = "yyyy-MM-dd";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        String finalDate = dateFormat.format(usuarioDto.getBirthday());
        boolean isBirthdayValid = Pattern.matches("^([0-9]{4})-([0-9]{2})-([0-9]{2})$", finalDate);

        if(!isBirthdayValid){
            throw new RuntimeException(Constantes.GENERAL_FIELD_EXCEPTION);
        }

    }
}
