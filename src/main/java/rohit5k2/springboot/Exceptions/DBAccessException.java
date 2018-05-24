package rohit5k2.springboot.Exceptions;

import org.springframework.util.StringUtils;

public class DBAccessException extends BaseException {
    public DBAccessException(String message){
        this.message = StringUtils.hasLength(message) ? message : "Error accessing Database.";
        this.code = ExceptionCodes.Codes.DBAccessException;
    }
}
