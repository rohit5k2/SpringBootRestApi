package rohit5k2.springboot.Exceptions;

public class ExceptionEntity {
    private ExceptionCodes.Codes code = ExceptionCodes.Codes.Unknown;
    private String message = "An error occured.";

    public ExceptionEntity(ExceptionCodes.Codes code, String message){
        this.code = code;
        this.message = message;
    }

    public ExceptionCodes.Codes getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
