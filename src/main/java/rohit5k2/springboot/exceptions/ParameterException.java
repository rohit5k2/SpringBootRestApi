package rohit5k2.springboot.exceptions;

import org.springframework.util.StringUtils;

public class ParameterException extends BaseException {
    public ParameterException(String message){
        this.message = StringUtils.hasLength(message) ? message : "Invalid parameter passed";
        this.code = ExceptionCodes.Codes.ParameterException;
    }
}
