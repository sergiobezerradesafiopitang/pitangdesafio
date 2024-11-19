package com.pitang.desafio.service.Impl;

import com.pitang.desafio.constants.Constantes;
import com.pitang.desafio.dto.CarroDto;
import com.pitang.desafio.dto.response.ResponseDto;
import com.pitang.desafio.exception.CarNotFoundException;
import com.pitang.desafio.exception.PlacaAlreadyExistsException;
import com.pitang.desafio.exception.UsuarioNotFoundException;
import com.pitang.desafio.mapper.Mapper;
import com.pitang.desafio.model.Carro;
import com.pitang.desafio.model.Usuario;
import com.pitang.desafio.repository.ICarroRepository;
import com.pitang.desafio.repository.IUsuarioRepository;
import com.pitang.desafio.service.ICarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarroServiceImpl implements ICarroService {

    private final ICarroRepository carroRepository;
    private final IUsuarioRepository usuarioRepository;

    /**
     * Method responsible for get all cars
     * @return List<CarroDto>
     */
    @Override
    @Transactional(readOnly = true)
    public List<CarroDto> getAllCars() {
        return carroRepository.findAll().stream().map(value -> Mapper.convertToCarroDto(value)).collect(Collectors.toList());
    }

    /**
     * Method responsible for create a cars
     * @param carroDto
     * @return ResponseDto
     */
    @Override
    @Transactional
    public ResponseEntity<ResponseDto> cadastrarCarro(CarroDto carroDto) {
        Usuario usuario = usuarioRepository.findById(Long.parseLong(carroDto.getIdUsuario())).orElseThrow(() -> {throw new UsuarioNotFoundException();});
        carroRepository.findByLicensePlate(carroDto.getLicensePlate()).ifPresent(value -> {throw new PlacaAlreadyExistsException();});
        usuario.getCars().add(Mapper.convertToCarro(carroDto));
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED.value(), Constantes.CARRO_CADASTRADO_COM_SUCESSO));
    }

    /**
     * Method responsible for get car by Id
     * @param id
     * @return CarroDto
     */
    @Override
    @Transactional(readOnly = true)
    public CarroDto buscaCarroPorId(String id) {
        return Mapper.convertToCarroDto(carroRepository.findById(Long.parseLong(id)).orElse(new Carro()));
    }

    /**
     * Method responsible for update car by Id
     * @param id
     * @return ResponseDto
     */
    @Override
    @Transactional
    public ResponseEntity<ResponseDto> atualizarCarro(String id, CarroDto carroDto) {
        Carro carro = carroRepository.findById(Long.parseLong(id)).orElseThrow(() -> {throw new CarNotFoundException();});
        Mapper.atualizarCarro(carro, carroDto);
        carroRepository.save(carro);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(new ResponseDto(HttpStatus.NO_CONTENT.value(), Constantes.CARRO_ATUALIZADO_COM_SUCESSO));
    }

    /**
     * Method responsible for delete car
     * @param id
     * @return ResponseDto
     */
    @Override
    public ResponseEntity<ResponseDto> removerCarro(String id) {
        Carro carro = carroRepository.findById(Long.parseLong(id)).orElseThrow(() -> {throw new CarNotFoundException();});
        carroRepository.delete(carro);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.value(), Constantes.CARRO_REMOVIDO_COM_SUCESSO));
    }
}
