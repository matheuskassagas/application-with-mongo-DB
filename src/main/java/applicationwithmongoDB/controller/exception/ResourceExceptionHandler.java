package applicationwithmongoDB.controller.exception;

import applicationwithmongoDB.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice//intercepta as exceptions que acontecerem, para o obj excultar um possivel tratamento
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)//meu metodo vai intercepta qualquer exception do tipo que foi lancada e ira fazer o tratamento
    public ResponseEntity<StandardError> objectNotFound (ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), "Resource not Found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
