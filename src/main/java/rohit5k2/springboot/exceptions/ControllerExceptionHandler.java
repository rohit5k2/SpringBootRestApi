package rohit5k2.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.constraints.NotNull;

@ControllerAdvice(basePackages = {"rohit5k2.springboot.controllers"})
class ControllerExceptionHandler {
    @ExceptionHandler(ParameterException.class)
    public ResponseEntity<ExceptionEntity> parameterExceptionHandler(@NotNull ParameterException parameterException) {
        return new ResponseEntity(parameterException.getExceptionEntity(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DBAccessException.class)
    public ResponseEntity<ExceptionEntity> dbAccessExceptionHandler(@NotNull DBAccessException dbAccessException) {
        return new ResponseEntity(dbAccessException.getExceptionEntity(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionEntity> baseExceptionHandler(@NotNull Exception exception){
        return new ResponseEntity<>(new BaseException().getExceptionEntity(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
