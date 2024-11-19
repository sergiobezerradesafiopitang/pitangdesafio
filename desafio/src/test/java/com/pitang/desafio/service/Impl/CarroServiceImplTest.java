package com.pitang.desafio.service.Impl;

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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CarroServiceImplTest {

    @InjectMocks
    private CarroServiceImpl carroServiceImplMock;

    @Mock
    private  ICarroRepository carroRepository;

    @Mock
    private  IUsuarioRepository usuarioRepository;

    @Mock
    private Carro carro;

    @Mock
    private CarroDto carroDto;

    @Mock
    private Usuario usuario;

    @Mock
    private List<Carro> listaCarro;

    @Mock
    private Optional<Usuario> optionalUsuario;

    @Mock
    private Optional<Carro> optionalCarro;

    @Mock
    private List<CarroDto> listaCarroDto;


    @BeforeEach
    public void setUp(){

        carro = Carro.builder().idCarro(1L)
                               .year(2020)
                               .licensePlate("WW-1234")
                               .model("Honda")
                               .color("Prata")
                               .build();

        carroDto = CarroDto.builder().idCarro(1L)
                                     .year(2020)
                                     .licensePlate("WW-1234")
                                     .model("Honda")
                                     .color("Prata")
                                     .idUsuario("1")
                                     .build();

        usuario = new Usuario();
        usuario.setIdUsuario(1L);

        optionalUsuario = Optional.of(usuario);
        optionalCarro = Optional.of(carro);

        listaCarro = Arrays.asList(carro);
        listaCarroDto = Arrays.asList(carroDto);


    }

    @DisplayName("Get all Cars")
    @Test
    void test_getAllCars(){
        when(carroRepository.findAll()).thenReturn(listaCarro);
        try (MockedStatic<Mapper> map = Mockito.mockStatic(Mapper.class)) {
            map.when(() -> Mapper.convertToCarroDto(ArgumentMatchers.any()))
                    .thenReturn(carroDto);
        }

        List<CarroDto> test = carroServiceImplMock.getAllCars();

        assertEquals(listaCarroDto.get(0).getIdCarro(), test.get(0).getIdCarro());
        verify(carroRepository, atLeastOnce()).findAll();
    }

    @DisplayName("Cadastrar Carro")
    @Test
    void test_cadastrarCarro(){
        CarroDto newCarroDto = CarroDto.builder().idUsuario("2").licensePlate(null).build();
        when(usuarioRepository.findById(ArgumentMatchers.anyLong())).thenReturn(optionalUsuario);
        when(carroRepository.findByLicensePlate(ArgumentMatchers.isNull())).thenReturn(Optional.ofNullable(null));
        doReturn(usuario).when(usuarioRepository).save(ArgumentMatchers.any());

        ResponseEntity<ResponseDto> test = carroServiceImplMock.cadastrarCarro(newCarroDto);

        assertEquals(HttpStatus.CREATED.value(), test.getStatusCode().value());
        verify(usuarioRepository, atLeastOnce()).findById(ArgumentMatchers.anyLong());
        verify(carroRepository, atLeastOnce()).findByLicensePlate(ArgumentMatchers.any());
        verify(usuarioRepository, atLeastOnce()).save(ArgumentMatchers.any());

    }

    @DisplayName("Valida Usuario Cadastrar Carro")
    @Test
    void test_cadastrarCarro_no_user(){
        when(usuarioRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(null));
        assertThrows(UsuarioNotFoundException.class, () -> carroServiceImplMock.cadastrarCarro(carroDto));
        verify(usuarioRepository, atLeastOnce()).findById(ArgumentMatchers.anyLong());
    }

    @DisplayName("Valida Placa Cadastrar Carro")
    @Test
    void test_cadastrarCarro_license_plate(){
        when(usuarioRepository.findById(ArgumentMatchers.anyLong())).thenReturn(optionalUsuario);
        when(carroRepository.findByLicensePlate(ArgumentMatchers.anyString())).thenReturn(optionalCarro);

        assertThrows(PlacaAlreadyExistsException.class, () -> carroServiceImplMock.cadastrarCarro(carroDto));

        verify(usuarioRepository, atLeastOnce()).findById(ArgumentMatchers.anyLong());
        verify(carroRepository, atLeastOnce()).findByLicensePlate(ArgumentMatchers.any());

    }

    @DisplayName("Buscar Carro por Id")
    @Test
    void test_buscarCarroPorId(){
        when(carroRepository.findById(ArgumentMatchers.anyLong())).thenReturn(optionalCarro);
        try (MockedStatic<Mapper> map = Mockito.mockStatic(Mapper.class)) {
            map.when(() -> Mapper.convertToCarroDto(ArgumentMatchers.any()))
                    .thenReturn(carroDto);
        }

        CarroDto test = carroServiceImplMock.buscaCarroPorId("1");

        assertEquals(carroDto.getIdCarro(), test.getIdCarro());
        verify(carroRepository, atLeastOnce()).findById(ArgumentMatchers.anyLong());
    }

    @DisplayName("Atualizar Carro")
    @Test
    void test_atualizarCarro(){
        when(carroRepository.findById(ArgumentMatchers.anyLong())).thenReturn(optionalCarro);
        doReturn(carro).when(carroRepository).save(ArgumentMatchers.any());

        ResponseEntity<ResponseDto> test = carroServiceImplMock.atualizarCarro("1", carroDto);

        assertEquals(HttpStatus.NO_CONTENT.value(), test.getStatusCode().value());
        verify(carroRepository, atLeastOnce()).findById(ArgumentMatchers.anyLong());
        verify(carroRepository, atLeastOnce()).save(ArgumentMatchers.any());
    }

    @DisplayName("Atualizar Carro - not found")
    @Test
    void test_atualizarCarro_not_found(){
        when(carroRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(null));
        assertThrows(CarNotFoundException.class, () -> carroServiceImplMock.atualizarCarro("2", carroDto));
        verify(carroRepository, atLeastOnce()).findById(ArgumentMatchers.anyLong());
    }

    @DisplayName("Remover Carro")
    @Test
    void test_removerCarro(){
        when(carroRepository.findById(ArgumentMatchers.anyLong())).thenReturn(optionalCarro);
        doNothing().when(carroRepository).delete(ArgumentMatchers.any());

        ResponseEntity<ResponseDto> test = carroServiceImplMock.removerCarro("1");

        assertEquals(HttpStatus.OK.value(), test.getStatusCode().value());
        verify(carroRepository, atLeastOnce()).findById(ArgumentMatchers.anyLong());
        verify(carroRepository, atLeastOnce()).delete(ArgumentMatchers.any());
    }

    @DisplayName("Not found Remover Carro")
    @Test
    void test_removerCarro_not_found(){
        when(carroRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.ofNullable(null));
        assertThrows(CarNotFoundException.class, () -> carroServiceImplMock.removerCarro("2"));
        verify(carroRepository, atLeastOnce()).findById(ArgumentMatchers.anyLong());

    }

}
