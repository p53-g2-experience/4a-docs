package co.misiontic.p53.planes_ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody

public class DisponibilidadReservaAdvice {
    @ResponseBody
    @ExceptionHandler(DisponibilidadReservaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String DisponibilidadReservaAdvice(DisponibilidadReservaException ex){
        return ex.getMessage();
    }
}
