package com.pitang.desafio.exception.handlerException;

import com.pitang.desafio.constants.Constantes;
import com.pitang.desafio.dto.response.ErrorResponseDto;
import com.pitang.desafio.exception.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

    /**
     * Method responsible for validate DTO
     * @param ex the exception to handle
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return ResponseEntity<Object>
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {

        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();
        List<ErrorResponseDto> listError = new ArrayList<>();

        validationErrorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String validationMsg = error.getDefaultMessage();
            String errorCode = String.valueOf(status.value());
            ErrorResponseDto errorResponseDto =
                    ErrorResponseDto.builder()
                            .errorCode(errorCode)
                            .message(validationMsg + " " + fieldName)
                            .build();
            listError.add(errorResponseDto);
        });
        return new ResponseEntity<>(listError, HttpStatus.BAD_REQUEST);
    }

    /**
     * Method responsible for manage EmailAlreadyExistsException
     * @param exception
     * @param webRequest
     * @return ResponseEntity<ErrorResponseDto>
     */
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception,
                                                                                 WebRequest webRequest){
        ErrorResponseDto errorResponseDto =
                ErrorResponseDto.builder()
                        .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .message(exception.getMessage())
                        .build();

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);

    }

    /**
     * Method responsible for manage LoginAlreadyExistsException
     * @param exception
     * @param webRequest
     * @return ResponseEntity<ErrorResponseDto>
     */
    @ExceptionHandler(LoginAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleEmailAlreadyExistsException(LoginAlreadyExistsException exception,
                                                                              WebRequest webRequest){
        ErrorResponseDto errorResponseDto =
                ErrorResponseDto.builder()
                        .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .message(exception.getMessage())
                        .build();

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);

    }

    /**
     * Method responsible for manage UsuarioNotFoundException
     * @param exception
     * @param webRequest
     * @return ResponseEntity<ErrorResponseDto>
     */
    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleUsuarioNotFoundException(UsuarioNotFoundException exception,
                                                                           WebRequest webRequest){
        ErrorResponseDto errorResponseDto =
                ErrorResponseDto.builder()
                        .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .message(exception.getMessage())
                        .build();

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);

    }

    /**
     * Method responsible for manage TokenNotSendedException
     * @param exception
     * @param webRequest
     * @return ResponseEntity<ErrorResponseDto>
     */
    @ExceptionHandler(TokenNotSendedException.class)
    public ResponseEntity<ErrorResponseDto> handleTokenNotSendedException(TokenNotSendedException exception,
                                                                           WebRequest webRequest){
        ErrorResponseDto errorResponseDto =
                ErrorResponseDto.builder()
                        .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .message(exception.getMessage())
                        .build();

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);

    }

    /**
     * Method responsible for manage CarNotFoundException
     * @param exception
     * @param webRequest
     * @return ResponseEntity<ErrorResponseDto>
     */
    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleCarNotFoundException(CarNotFoundException exception,
                                                                       WebRequest webRequest){
        ErrorResponseDto errorResponseDto =
                ErrorResponseDto.builder()
                        .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .message(exception.getMessage())
                        .build();

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);

    }

    /**
     * Method responsible for manage TokenExpiredException
     * @param exception
     * @param webRequest
     * @return ResponseEntity<ErrorResponseDto>
     */
    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<ErrorResponseDto> handleTokenExpiredException(TokenExpiredException exception,
                                                                        WebRequest webRequest){
        ErrorResponseDto errorResponseDto =
                ErrorResponseDto.builder()
                        .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .message(exception.getMessage())
                        .build();

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);

    }

    /**
     * Method responsible for manage PlacaAlreadyExistsException
     * @param exception
     * @param webRequest
     * @return ResponseEntity<ErrorResponseDto>
     */
    @ExceptionHandler(PlacaAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handlePlacaAlreadyExistsException(PlacaAlreadyExistsException exception,
                                                                              WebRequest webRequest){
        ErrorResponseDto errorResponseDto =
                ErrorResponseDto.builder()
                        .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .message(exception.getMessage())
                        .build();

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);

    }


    /**
     * Method responsible for manage InvalidLoginPasswordException
     * @param exception
     * @param webRequest
     * @return ResponseEntity<ErrorResponseDto>
     */
    @ExceptionHandler(InvalidLoginPasswordException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidLoginPasswordException(InvalidLoginPasswordException exception,
                                                                                WebRequest webRequest){
        ErrorResponseDto errorResponseDto =
                ErrorResponseDto.builder()
                        .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .message(exception.getMessage())
                        .build();

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);

    }

    /**
     * Method responsible for manage Exception
     * @param exception
     * @param webRequest
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception,
                                                                  WebRequest webRequest){
        ErrorResponseDto errorResponseDto =
                ErrorResponseDto.builder()
                        .errorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                        .message(Constantes.GENERAL_FIELD_EXCEPTION)
                        .build();

        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
