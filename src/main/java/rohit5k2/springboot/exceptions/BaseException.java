package rohit5k2.springboot.exceptions;

public class BaseException extends Exception implements IExceptionEntity{
    protected ExceptionCodes.Codes code = ExceptionCodes.Codes.BaseException;
    protected String message = "An error occurred";

    /**
     * Gets exception message
     * @return
     */
    @Override
    public String getMessage() {
        return this.message;
    }

    /**
     * Gets the exception code
     * @return
     */
    public ExceptionCodes.Codes getCode(){
        return this.code;
    }

    /**
     * Gets the Exception entity which should be returned to the client
     * in case of any exception. This contains exception code and a message.
     * @return
     */
    public ExceptionEntity getExceptionEntity() {
        return new ExceptionEntity(getCode(), getMessage());
    }
}
