package com.pitang.desafio.service;

import com.pitang.desafio.dto.CarroDto;
import com.pitang.desafio.dto.response.ResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICarroService {

    /**
     * Method responsible for get all cars
     * @return List<CarroDto>
     */
    List<CarroDto> getAllCars();

    /**
     * Method responsible for create a cars
     * @param carroDto
     * @return ResponseDto
     */
    ResponseEntity<ResponseDto> cadastrarCarro(CarroDto carroDto);

    /**
     * Method responsible for get car by Id
     * @param id
     * @return CarroDto
     */
    CarroDto buscaCarroPorId(String id);

    /**
     * Method responsible for update car by Id
     * @param id
     * @param carroDto
     * @return ResponseDto
     */
    ResponseEntity<ResponseDto> atualizarCarro(String id, CarroDto carroDto);

    /**
     * Method responsible for delete car
     * @param id
     * @return ResponseDto
     */
    ResponseEntity<ResponseDto> removerCarro(String id);
}
