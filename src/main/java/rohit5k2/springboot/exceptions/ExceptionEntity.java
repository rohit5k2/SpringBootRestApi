package rohit5k2.springboot.exceptions;

public class ExceptionEntity {
    private int code = ExceptionCodes.Codes.Unknown.value;
    private String message = "An error occured.";

    public ExceptionEntity(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
