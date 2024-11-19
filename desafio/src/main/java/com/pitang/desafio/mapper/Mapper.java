package com.pitang.desafio.mapper;

import com.pitang.desafio.Util.Utils;
import com.pitang.desafio.dto.CarroDto;
import com.pitang.desafio.dto.UsuarioDto;
import com.pitang.desafio.model.Carro;
import com.pitang.desafio.model.Usuario;

public class Mapper {

    /**
     * Method responsible for convert from Usuario to UsuarioDto
     * @param usuario
     * @return UsuarioDto
     */
    public static UsuarioDto convertToUsuarioDto(Usuario usuario){

        String novoPassword = usuario.getPassword();
        if(!usuario.getPassword().equals("")){
            novoPassword = Utils.decodePassword(usuario.getPassword());
        }

        return UsuarioDto.builder()
            .idUsuario(usuario.getIdUsuario())
            .firstName(usuario.getFirstName())
            .lastName(usuario.getLastName())
            .email(usuario.getEmail())
            .birthday(usuario.getBirthday())
            .login(usuario.getLogin())
            .password(novoPassword)
            .phone(usuario.getPhone())
            .cars(null)
            .build();
    }

    /**
     * Method responsible for convert from Usuario to UsuarioDto for get information about himself
     * @param usuario
     * @return UsuarioDto
     */
    public static UsuarioDto convertToUsuarioDtoForInformation(Usuario usuario){

        String novoPassword = usuario.getPassword();
        if(!usuario.getPassword().equals("")){
            novoPassword = Utils.decodePassword(usuario.getPassword());
        }

        return UsuarioDto.builder()
                .idUsuario(usuario.getIdUsuario())
                .firstName(usuario.getFirstName())
                .lastName(usuario.getLastName())
                .email(usuario.getEmail())
                .birthday(usuario.getBirthday())
                .login(usuario.getLogin())
                .password(novoPassword)
                .phone(usuario.getPhone())
                .lastLogin(usuario.getLastLogin())
                .createdAt(usuario.getCreatedAt())
                .cars(usuario.getCars())
                .build();
    }

    /**
     * Method responsible for convert from UsuarioDto to Usuario
     * @param usuarioDto
     * @return Usuario
     */
    public static Usuario convertToUsuario(UsuarioDto usuarioDto){

        String novoPassword = usuarioDto.getPassword();
        if(!usuarioDto.getPassword().equals("")){
            novoPassword = Utils.encodePassword(usuarioDto.getPassword());
        }

        return Usuario.builder()
                .firstName(usuarioDto.getFirstName())
                .lastName(usuarioDto.getLastName())
                .email(usuarioDto.getEmail())
                .birthday(usuarioDto.getBirthday())
                .login(usuarioDto.getLogin())
                .password(novoPassword)
                .phone(usuarioDto.getPhone())
                .cars(usuarioDto.getCars())
                .build();

    }

    /**
     * Method responsible for convert the update from UsuarioDto to Usuario
     * @param usuario
     * @param usuarioDto
     */
    public static void updateUsuarioFromUsuarioDto(Usuario usuario, UsuarioDto usuarioDto){

        String novoPassword = usuarioDto.getPassword();
        if(!usuarioDto.getPassword().equals("")){
            novoPassword = Utils.encodePassword(usuarioDto.getPassword());
        }

        usuario.setFirstName(usuarioDto.getFirstName());
        usuario.setLastName(usuarioDto.getLastName());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setBirthday(usuarioDto.getBirthday());
        usuario.setLogin(usuarioDto.getLogin());
        usuario.setPassword(novoPassword);
        usuario.setPhone(usuarioDto.getPhone());

    }

    /**
     * Method responsible for convert to CarroDto
     * @param carro
     * @return CarroDto
     */
    public static CarroDto convertToCarroDto(Carro carro){

        return CarroDto.builder()
                       .idCarro(carro.getIdCarro())
                       .year(carro.getYear())
                       .model(carro.getModel())
                       .licensePlate(carro.getLicensePlate())
                       .color(carro.getColor())
                       .build();
    }

    /**
     * Method responsible for convert to Carro
     * @param carroDto
     * @return Carro
     */
    public static Carro convertToCarro(CarroDto carroDto){

        return Carro.builder()
                    .year(carroDto.getYear())
                    .model(carroDto.getModel())
                    .licensePlate(carroDto.getLicensePlate())
                    .color(carroDto.getColor())
                    .build();

    }

    public static void atualizarCarro(Carro carro, CarroDto carroDto){

        carro.setYear(carroDto.getYear());
        carro.setLicensePlate(carroDto.getLicensePlate());
        carro.setModel(carroDto.getModel());
        carro.setColor(carroDto.getColor());

    }

}
